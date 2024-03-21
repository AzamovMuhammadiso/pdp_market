package org.example.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

public class Market_Bot extends TelegramLongPollingBot{

    @Override
    public void onUpdateReceived(Update update) {
        Message message =update.getMessage();
        String text = message.getText();
        SendMessage sendMessage = new SendMessage();

        if(text.equals("/start")){
            KeyboardRow row1 =new KeyboardRow();

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
