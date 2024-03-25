package org.example.bot;

import org.example.bot.handlers.CommandHandler;
import org.example.bot.handlers.HelpCommandHandler;
import org.example.bot.handlers.StartCommandHandler;
import org.example.bot.model.Product;
import org.example.bot.services.ProductService;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
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
            } else if (text.contains("Categories")) {
                sendProductButtons(chatId);
            } else if (text.contains("Clothes")) {
                sendClothing(chatId);
            }
        }
    }

    private void sendClothing(Long chatId) {
      try{  ProductService productService = new ProductService();

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
        System.out.println("Jo'natildi: " + response.toString());

        try {
            execute(sendMessage);
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
      }catch (Exception e){
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

//        KeyboardRow row5 = new KeyboardRow();
//        row5.add(new KeyboardButton("Categories"));

        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboard.add(row4);
//        keyboard.add(row5);

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
