package ru.michmar.detectivegamebot.bot.service.interfaces;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.michmar.detectivegamebot.bot.TelegramBot;

public interface MessageHandler {
    void handleTextMessage(Update update, TelegramBot telegramBot);
}
