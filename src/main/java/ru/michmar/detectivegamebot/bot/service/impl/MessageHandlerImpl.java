package ru.michmar.detectivegamebot.bot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.michmar.detectivegamebot.bot.TelegramBot;
import ru.michmar.detectivegamebot.bot.service.interfaces.MessageHandler;
import ru.michmar.detectivegamebot.bot.util.CreatingMessage;
import ru.michmar.detectivegamebot.bot.util.MessageUtil;

@Component
@AllArgsConstructor
public class MessageHandlerImpl implements MessageHandler {
    private final CreatingMessage creatingMessage;
    private final MessageUtil messageUtil;

    @Override
    public void handleTextMessage(Update update, TelegramBot telegramBot) {
        String messageText = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();
        String username = update.getMessage().getFrom().getFirstName();

        if (messageText.equals("/start")) {
            creatingMessage.sendMainMenu(chatId, telegramBot);
        } else if (messageText.equals("/help")) {
            creatingMessage.showHelp(chatId, username, telegramBot);
        } else {
            messageUtil.sendMessage(chatId, null, "Тут надо кнопки нажимать а не писать", telegramBot);
        }
    }
}
