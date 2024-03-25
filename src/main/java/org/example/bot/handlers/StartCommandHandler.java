package org.example.bot.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.example.bot.Market_Bot;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class StartCommandHandler implements CommandHandler {
    @Override
    public void handleCommand(Message message) {
        Long chatId = message.getChatId();

        String response = """
                Bizning telegram do'konimizga xush kelibsiz! 🎉
                Mijozimiz ekanligingizdan xursandmiz 😊 
                Xarid qilmoqchi bo`lgan mahsulotingizni topishda yozdam beramiz 🛒🛒🛒 
                Ishonchli va qulay xaridlar! 💳
                
                """;

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(response);

        ReplyKeyboardMarkup keyboardMarkup = getReplyKeyboardMarkup();

        sendMessage.setReplyMarkup(keyboardMarkup);

        try {
            Market_Bot bot = new Market_Bot();
            bot.execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ReplyKeyboardMarkup getReplyKeyboardMarkup() {
        KeyboardRow row1 = new KeyboardRow();

        KeyboardButton categories = new KeyboardButton("\uD83D\uDDC2\uFE0F Categories");

        KeyboardButton btn2 = new KeyboardButton("button 2");

        row1.add(categories);
        row1.add(btn2);

        KeyboardRow row2 = new KeyboardRow();

        KeyboardButton btn3 = new KeyboardButton("button 3");

        KeyboardButton btn4 = new KeyboardButton("button 4");
        row2.add(btn3);
        row2.add(btn4);

        KeyboardRow row3 = new KeyboardRow();
        KeyboardButton btn5 = new KeyboardButton("button 5");

        row3.add(btn5);

        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(row1);
        keyboard.add(row2);
        keyboard.add(row3);

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setKeyboard(keyboard);
        keyboardMarkup.setResizeKeyboard(true);
        return keyboardMarkup;
    }
}
