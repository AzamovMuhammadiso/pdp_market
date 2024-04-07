package org.example.bot;

import org.example.bot.categoryhandlers.Categoryhandler;
import org.example.bot.db.DbProps;
import org.example.bot.handlers.CommandHandler;
import org.example.bot.handlers.HelpCommandHandler;
import org.example.bot.handlers.StartCommandHandler;
import org.example.bot.model.Product;
import org.example.bot.model.User;
import org.example.bot.services.ProductService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Market_Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();
            String text = message.getText();

            System.out.println("Received message: " + text);
            if (message.hasContact()) {
                System.out.println("contact received");
                handleContact(message, chatId);
            } else if (text.equals("/start") || text.contains("Menu")) {
                CommandHandler handler = new StartCommandHandler();
                handler.handleCommand(message);
            } else if (text.contains("/admin") || text.contains("Admin")) {
                if (isAdmin(message.getFrom().getId())) {
                    handleAdminActions(chatId);
                } else {
                    sendNonAdminMessage(chatId);
                }
            } else if (text.equals("/help")) {
                CommandHandler handler = new HelpCommandHandler();
                handler.handleCommand(message);
            } else if (text.contains("Categories")) {
                Categoryhandler.sendProductButtons(this, chatId);
            } else if (text.contains("Clothes")) {
                Categoryhandler.sendClothing(this, chatId);
            } else if (text.contains("Food")) {
                Categoryhandler.sendFood(this, chatId);
            } else if (text.contains("Dairy")) {
                Categoryhandler.sendDairy(this, chatId);
            } else if (text.contains("Coffee")) {
                Categoryhandler.sendCoffee(this, chatId);
            } else if (text.contains("Ice Cream")) {
                Categoryhandler.sendIceCream(this, chatId);
            } else if (text.contains("Milk")) {
                Categoryhandler.sendMilk(this, chatId);
            } else if (text.contains("Cheeses")) {
                Categoryhandler.sendCheeses(this, chatId);
            } else if (text.contains("Butter")) {
                Categoryhandler.sendButter(this, chatId);
            } else if (text.contains("Yogurt")) {
                Categoryhandler.sendYogurt(this, chatId);
            } else if (text.contains("Kefir")) {
                Categoryhandler.sendKefir(this, chatId);
            } else if (text.contains("Cream")) {
                Categoryhandler.sendCream(this, chatId);
            } else if (text.contains("About Us")) {
                handleAboutUs(chatId);
            } else if (text.contains("Support")) {
                handleSupport(chatId);
            }
        }
    }

    private void handleContact(Message message, Long chatId) {
        Contact contact = message.getContact();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        org.telegram.telegrambots.meta.api.objects.User telegramUser = message.getFrom();

        if (contact != null) {
            User user = new User();
            if (telegramUser.getId().equals(user.getId())) {
                System.out.println("Contact shared:" + "userID: " + contact.getUserId() + ", Username: " + telegramUser.getUserName() + "\nName: " + contact.getFirstName() + " " + contact.getLastName() + "\nPhone number: " + contact.getPhoneNumber());
                user.setId(telegramUser.getId());
                user.setUsername(telegramUser.getUserName());
                user.setFirstName(contact.getFirstName());
                user.setLastName(contact.getLastName());

                insertUserIntoDatabase(user, contact.getPhoneNumber());

                sendMessage.setText("Contact shared:\n" + "userID: " + contact.getUserId() + "\n" + "Username: " + telegramUser.getUserName() + "\nFirstname: " + contact.getFirstName() + "\nLastname: " + contact.getLastName() + "\nPhone number: " + contact.getPhoneNumber());
            } else {
                System.out.println("User already exist.");
                sendMessage.setText("You have already shared a contact.");

            }
        } else {
            System.out.println("No contact shared in the message.");
            sendMessage.setText("Please share contact for delivery.");
        }

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
            System.out.println("Failed to send contact message.");
        }
    }


    private void insertUserIntoDatabase(User user, String phoneNumber) {
        String urlSQL = DbProps.get("db.url");
        String usernameSQL = DbProps.get("db.username");
        String passwordSQL = DbProps.get("db.password");
        try {
            Connection connection = DriverManager.getConnection(urlSQL, usernameSQL, passwordSQL);
            Statement statement = connection.createStatement();

            String query = "INSERT INTO users (id, username, firstname, lastname, phonenumber) " +
                    "VALUES ('" + user.getId() + "', '" + user.getUsername() + "', '" + user.getFirstName() + "','" + user.getLastName() + "','" + phoneNumber + "')";

            statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void handleSupport(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        String response = """
                🤖 Need assistance? We're here to help! 🤖
                    
                If you have any questions, concerns, or feedback, feel free to reach out to our support team. 🔍📞
                    
                You can also contact us directly via email at azamovmuhammadiso@gmail.com or by phone at <a href='tel:+998938220038'>+938220038</a>. 📧📞
                    
                Our dedicated team is available 24/7 to ensure your queries are addressed promptly. 💬✨
                    
                If you wish to make a payment or need assistance with transactions, you can use our support card:
                💳 <code>5614 6819 1845 9268</code>
                    
                Rest assured that your transactions are secure and handled with care by our team. 💰🔒
                """;
        sendMessage.setText(response);
        sendMessage.setParseMode(ParseMode.HTML);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    private void handleAboutUs(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        String response = """
                🌟 Welcome to our Bot! 🌟
                        
                We're here to make your shopping experience delightful and hassle-free. 💼🛍️
                        
                Our goal is to provide you with the best products and services, ensuring your satisfaction every step of the way. 🤝
                        
                Feel free to explore our categories and discover amazing deals. Happy shopping! 🎉🛒
                """;

        sendMessage.setText(response);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private boolean isAdmin(Long userId) {
        return userId.equals(1921970232L);
    }

    private void handleAdminActions(Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Admin actions:\n1. Action 1\n2. Action 2\n3. Action 3");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendNonAdminMessage(Long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("You are not an admin.");
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "pdp_online_market_bot";
    }

    @Override
    public String getBotToken() {
        return "6856693785:AAEFOqWNDhPKYc0usVfZyqANPVxuCiOJ_2M";
    }
}
