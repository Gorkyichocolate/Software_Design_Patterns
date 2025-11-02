package Notfications;

import Observer.NotifierStrategy;
import TelegramBot.Bot;

public class TelegramBot implements NotifierStrategy {
    private Long chatId;

    public TelegramBot(Long chatId) {
        this.chatId = chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    @Override
    public void sendNotification(String message) {
        if (chatId != null) {
            Bot bot = Bot.getInstance();
            if (bot != null) {
                bot.sendText(chatId, message);
            }
        }
    }
}