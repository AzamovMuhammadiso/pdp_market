package org.example.bot.handlers;

import org.telegram.telegrambots.meta.api.objects.Message;

public interface CommandHandler {
    void handleCommand(Message message);
}
