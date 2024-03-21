package org.example.bot.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.example.bot.Market_Bot;

public class StartCommandHandler implements CommandHandler {
    @Override
    public void handleCommand(Message message) {
        Long chatId = message.getChatId();

        String response = "Bizning onlayn do'konga xush kelibsiz! 🎉\n" +
                "Sizni ko'rishdan xursandmiz va sizni xarid qilishda yordam berishga tayyormiz. 💼\n " +"\n"+
                "Ishonchli va qulay xaridlar! 💳";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(response);

        try {
            // Send the message
            Market_Bot bot = new Market_Bot();
            bot.execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
