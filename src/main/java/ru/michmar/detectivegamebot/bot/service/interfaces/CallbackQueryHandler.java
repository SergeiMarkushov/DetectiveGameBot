package ru.michmar.detectivegamebot.bot.service.interfaces;

import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ru.michmar.detectivegamebot.bot.TelegramBot;

public interface CallbackQueryHandler {
    void handleCallbackQuery(CallbackQuery callbackQuery, TelegramBot telegramBot);
}
