package org.example.bot;
import org.example.bot.handlers.CommandHandler;
import org.example.bot.handlers.HelpCommandHandler;
import org.example.bot.handlers.StartCommandHandler;
import org.example.bot.model.Product;
import org.example.bot.services.ProductService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Market_Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String text = message.getText();
            Long chatId = message.getChatId();

            System.out.println("Received message: " + text);

            if (text.equals("/start")) {
                CommandHandler handler = new StartCommandHandler();
                handler.handleCommand(message);
            } else if (text.equals("/help")) {
                CommandHandler handler = new HelpCommandHandler();
                handler.handleCommand(message);
            } else if (text.equals("Categories")) {
                sendProductButtons(chatId);
            } else if (text.equals("Clothes")) {
                sendClothing(chatId);
            }
        }
    }

    private void sendClothing(Long chatId) {
        ProductService productService = new ProductService();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        List<Product> clothingProducts = productService.getProductsForCategory("Clothing");
        StringBuilder response = new StringBuilder("Here are the available clothing products:\n");

        for (Product product : clothingProducts) {
            response.append("\nName: ").append(product.getName())
                    .append("\nDescription: ").append(product.getDescription())
                    .append("\nPrice: $").append(product.getPrice())
                    .append("\nImage: ").append(product.getImageUrl())
                    .append("\n\n");
        }

        sendMessage.setText(response.toString());
        System.out.println("Sent: " + response.toString());
        System.out.println("Sent: " + response);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendProductButtons(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        String response = "Please select a category:";
        sendMessage.setText(response);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Clothes"));
        row1.add(new KeyboardButton("Food"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Shoes"));
        row2.add(new KeyboardButton("Electronics"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("Children's Products"));
        row3.add(new KeyboardButton("Household Goods"));

        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("Sports & Recreation"));
        row4.add(new KeyboardButton("Books"));

        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(keyboardMarkup);

        try {
            execute(sendMessage);
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
