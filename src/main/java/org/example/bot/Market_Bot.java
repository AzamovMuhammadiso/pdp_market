package org.example.bot;

import org.example.bot.handlers.CommandHandler;
import org.example.bot.handlers.HelpCommandHandler;
import org.example.bot.handlers.StartCommandHandler;
import org.example.bot.model.Product;
import org.example.bot.services.ProductService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
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
            } else if (text.contains("Categories")) {
                sendProductButtons(chatId);
            } else if (text.contains("Clothes")) {
                sendClothing(chatId);
            } else if (text.contains("Food")) {
                sendFood(chatId);
            } else if (text.contains("Dairy")) {
                sendDairy(chatId);
            }  else if (text.contains("Coffee")) {
                sendCoffee(chatId);
            } else if (text.contains("Ice Cream")) {
                sendIceCream(chatId);
            } else if (text.contains("Milk")) {
                sendMilk(chatId);
            } else if (text.contains("Cheeses")) {
                sendCheeses(chatId);
            } else if (text.contains("Butter")) {
                sendButter(chatId);
            } else if (text.contains("Yogurt")) {
                sendYogurt(chatId);
            } else if (text.contains("Kefir")) {
                sendKefir(chatId);
            }else if (text.contains("Cream")) {
                sendCream(chatId);
            }
        }
    }

    private void sendKefir(Long chatId) {
        try {
            ProductService productService = new ProductService();
            List<Product> clothingProducts = productService.getProductsForCategory("Kefir");

            for (Product product : clothingProducts){
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setPhoto(new InputFile(product.getImageUrl()));

                // Construct the caption with product details
                StringBuilder caption = new StringBuilder();
                caption.append("<b>Name:</b> ").append(product.getName()).append("\n")
                        .append("<b>Description:</b> ").append(product.getDescription()).append("\n")
                        .append("<b>Price:</b> $").append(product.getPrice());

                sendPhoto.setCaption(caption.toString());
                sendPhoto.setParseMode(ParseMode.HTML);

                execute(sendPhoto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendYogurt(Long chatId) {
        try {
            ProductService productService = new ProductService();
            List<Product> clothingProducts = productService.getProductsForCategory("Yogurt");

            for (Product product : clothingProducts) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setPhoto(new InputFile(product.getImageUrl()));

                // Construct the caption with product details
                StringBuilder caption = new StringBuilder();
                caption.append("<b>Name:</b> ").append(product.getName()).append("\n")
                        .append("<b>Description:</b> ").append(product.getDescription()).append("\n")
                        .append("<b>Price:</b> $").append(product.getPrice());

                sendPhoto.setCaption(caption.toString());
                sendPhoto.setParseMode(ParseMode.HTML);

                execute(sendPhoto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendButter(Long chatId) {
        try {
            ProductService productService = new ProductService();
            List<Product> clothingProducts = productService.getProductsForCategory("Butter");

            for (Product product : clothingProducts) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setPhoto(new InputFile(product.getImageUrl()));

                // Construct the caption with product details
                StringBuilder caption = new StringBuilder();
                caption.append("<b>Name:</b> ").append(product.getName()).append("\n")
                        .append("<b>Description:</b> ").append(product.getDescription()).append("\n")
                        .append("<b>Price:</b> $").append(product.getPrice());

                sendPhoto.setCaption(caption.toString());
                sendPhoto.setParseMode(ParseMode.HTML);

                execute(sendPhoto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendCheeses(Long chatId) {
        try {
            ProductService productService = new ProductService();
            List<Product> clothingProducts = productService.getProductsForCategory("Cheeses");

            for (Product product : clothingProducts) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setPhoto(new InputFile(product.getImageUrl()));

                // Construct the caption with product details
                StringBuilder caption = new StringBuilder();
                caption.append("<b>Name:</b> ").append(product.getName()).append("\n")
                        .append("<b>Description:</b> ").append(product.getDescription()).append("\n")
                        .append("<b>Price:</b> $").append(product.getPrice());

                sendPhoto.setCaption(caption.toString());
                sendPhoto.setParseMode(ParseMode.HTML);

                execute(sendPhoto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMilk(Long chatId) {
        try {
            ProductService productService = new ProductService();
            List<Product> clothingProducts = productService.getProductsForCategory("Milk");

            for (Product product : clothingProducts) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setPhoto(new InputFile(product.getImageUrl()));

                // Construct the caption with product details
                StringBuilder caption = new StringBuilder();
                caption.append("<b>Name:</b> ").append(product.getName()).append("\n")
                        .append("<b>Description:</b> ").append(product.getDescription()).append("\n")
                        .append("<b>Price:</b> $").append(product.getPrice());

                sendPhoto.setCaption(caption.toString());
                sendPhoto.setParseMode(ParseMode.HTML);

                execute(sendPhoto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendIceCream(Long chatId) {
        try {
            ProductService productService = new ProductService();
            List<Product> clothingProducts = productService.getProductsForCategory("Ice Cream");

            for (Product product : clothingProducts) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setPhoto(new InputFile(product.getImageUrl()));

                // Construct the caption with product details
                StringBuilder caption = new StringBuilder();
                caption.append("<b>Name:</b> ").append(product.getName()).append("\n")
                        .append("<b>Description:</b> ").append(product.getDescription()).append("\n")
                        .append("<b>Price:</b> $").append(product.getPrice());

                sendPhoto.setCaption(caption.toString());
                sendPhoto.setParseMode(ParseMode.HTML);

                execute(sendPhoto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendCoffee(Long chatId) {
        try {
            ProductService productService = new ProductService();
            List<Product> clothingProducts = productService.getProductsForCategory("Coffee");

            for (Product product : clothingProducts) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setPhoto(new InputFile(product.getImageUrl()));

                // Construct the caption with product details
                StringBuilder caption = new StringBuilder();
                caption.append("<b>Name:</b> ").append(product.getName()).append("\n")
                        .append("<b>Description:</b> ").append(product.getDescription()).append("\n")
                        .append("<b>Price:</b> $").append(product.getPrice());

                sendPhoto.setCaption(caption.toString());
                sendPhoto.setParseMode(ParseMode.HTML);

                execute(sendPhoto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendCream(Long chatId) {
        try {
            ProductService productService = new ProductService();
            List<Product> clothingProducts = productService.getProductsForCategory("Cream");

            for (Product product : clothingProducts) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setPhoto(new InputFile(product.getImageUrl()));

                // Construct the caption with product details
                StringBuilder caption = new StringBuilder();
                caption.append("<b>Name:</b> ").append(product.getName()).append("\n")
                        .append("<b>Description:</b> ").append(product.getDescription()).append("\n")
                        .append("<b>Price:</b> $").append(product.getPrice());

                sendPhoto.setCaption(caption.toString());
                sendPhoto.setParseMode(ParseMode.HTML);

                execute(sendPhoto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendDairy(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        String response = "Please select Dairy types:";
        sendMessage.setText(response);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("\uD83E\uDD5B Cream"));
        row1.add(new KeyboardButton("☕\uFE0F Coffee"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("\uD83C\uDF68 Ice Cream"));
        row2.add(new KeyboardButton("\uD83E\uDD5B Milk"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("\uD83E\uDDC0 Cheeses"));
        row3.add(new KeyboardButton("\uD83E\uDDC8 Butter"));

        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("\uD83E\uDD63 Yogurt"));
        row4.add(new KeyboardButton("\uD83C\uDF76 Kefir"));


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

    private void sendFood(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        String response = "Please select food types:";
        sendMessage.setText(response);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("\uD83E\uDD5B Dairy"));
        row1.add(new KeyboardButton("\uD83E\uDD66 Vegetables"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("\uD83C\uDF47 Fruits"));
        row2.add(new KeyboardButton("\uD83C\uDF3E  Grains"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("\uD83C\uDF57 Protein"));


        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);

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

    private void sendClothing(Long chatId) {
        try {
            ProductService productService = new ProductService();
            List<Product> clothingProducts = productService.getProductsForCategory("Clothing");

            for (Product product : clothingProducts) {
                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(chatId);
                sendPhoto.setPhoto(new InputFile(product.getImageUrl()));

                // Construct the caption with product details
                StringBuilder caption = new StringBuilder();
                caption.append("<b>Name:</b> ").append(product.getName()).append("\n")
                        .append("<b>Description:</b> ").append(product.getDescription()).append("\n")
                        .append("<b>Price:</b> $").append(product.getPrice());

                sendPhoto.setCaption(caption.toString());
                sendPhoto.setParseMode(ParseMode.HTML);

                execute(sendPhoto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void sendProductButtons(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        String response = "Please select a category:";
        sendMessage.setText(response);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("\uD83D\uDC55 Clothes"));
        row1.add(new KeyboardButton("\uD83C\uDF54 Food"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("\uD83D\uDC5F Shoes"));
        row2.add(new KeyboardButton("\uD83D\uDEE0\uFE0F  Electronics"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("\uD83E\uDDF8 Children's Products"));
        row3.add(new KeyboardButton("\uD83C\uDFE0 Household Goods"));

        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("⚽ Sports & Recreation"));
        row4.add(new KeyboardButton("\uD83D\uDCDA Books"));

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
        return "javahandler_bot";
    }

    @Override
    public String getBotToken() {
        return "6418828734:AAGY2_c8qdBwNVEYzNrQEG0_arNXMnlATuU";
    }
}
