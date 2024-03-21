package org.example.bot;

import org.example.bot.handlers.CommandHandler;
import org.example.bot.handlers.HelpCommandHandler;
import org.example.bot.handlers.StartCommandHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

public class Market_Bot extends TelegramLongPollingBot{


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            String text = message.getText();
            Long chatId = message.getChatId();

            // Log the received message
            System.out.println("Received message:): " + text);

            if (text.equals("/start")) {
                CommandHandler handler = new StartCommandHandler();
                handler.handleCommand(message);
            } else if (text.equals("/help")) {
                CommandHandler handler = new HelpCommandHandler();
                handler.handleCommand(message);
            }
            // Add more else if conditions for other commands
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
