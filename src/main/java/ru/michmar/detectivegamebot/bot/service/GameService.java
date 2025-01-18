package ru.michmar.detectivegamebot.bot.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.michmar.detectivegamebot.bot.TelegramBot;
import ru.michmar.detectivegamebot.bot.service.interfaces.CallbackQueryHandler;
import ru.michmar.detectivegamebot.bot.service.interfaces.MessageHandler;

@Service
@AllArgsConstructor
public class GameService {

    private final MessageHandler messageHandler;
    private final CallbackQueryHandler callbackQueryHandler;

    public void handleTextMessage(Update update, TelegramBot telegramBot) {
        messageHandler.handleTextMessage(update, telegramBot);
    }

    public void handleCallbackQuery(CallbackQuery callbackQuery, TelegramBot telegramBot) {
        callbackQueryHandler.handleCallbackQuery(callbackQuery, telegramBot);
    }
}
