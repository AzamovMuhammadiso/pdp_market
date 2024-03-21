package org.example.bot.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.example.bot.Market_Bot;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class StartCommandHandler implements CommandHandler {
    @Override
    public void handleCommand(Message message) {
        Long chatId = message.getChatId();

        String response = "Bizning onlayn do'konga xush kelibsiz! 🎉\n" +
                "Sizni ko'rishdan xursandmiz va sizni xarid qilishda yordam berishga tayyormiz. 💼\n " + "\n" +
                "Ishonchli va qulay xaridlar! 💳";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(response);

        KeyboardRow row1 = new KeyboardRow();

        KeyboardButton btn1 = new KeyboardButton("button 1");

        KeyboardButton btn2 = new KeyboardButton("button 2");

        row1.add(btn1);
        row1.add(btn2);

        KeyboardRow row2 = new KeyboardRow();

        KeyboardButton btn3 = new KeyboardButton("button 3");

        KeyboardButton btn4 = new KeyboardButton("button 4");
        row2.add(btn3);
        row2.add(btn4);

        KeyboardRow row3 = new KeyboardRow();
        KeyboardButton btn5 = new KeyboardButton("button 5");

        row3.add(btn5);


        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setKeyboard(List.of(row1, row2, row3));
        keyboardMarkup.setResizeKeyboard(true);

        sendMessage.setReplyMarkup(keyboardMarkup);


        try {
            Market_Bot bot = new Market_Bot();
            bot.execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
