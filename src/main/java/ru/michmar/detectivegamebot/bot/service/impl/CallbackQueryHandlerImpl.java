package ru.michmar.detectivegamebot.bot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ru.michmar.detectivegamebot.bot.TelegramBot;
import ru.michmar.detectivegamebot.bot.scenario.ScenarioSteps;
import ru.michmar.detectivegamebot.bot.service.interfaces.CallbackQueryHandler;
import ru.michmar.detectivegamebot.bot.util.CreatingMessage;

@Component
@AllArgsConstructor
public class CallbackQueryHandlerImpl implements CallbackQueryHandler {
    private final CreatingMessage creatingMessage;
    private final ScenarioSteps scenarioSteps;

    @Override
    public void handleCallbackQuery(CallbackQuery callbackQuery, TelegramBot telegramBot) {
        String data = callbackQuery.getData();
        int messageId = callbackQuery.getMessage().getMessageId();
        long chatId = callbackQuery.getMessage().getChatId();
        String username = callbackQuery.getFrom().getFirstName();

        switch (data) {
            case "START_GAME" -> scenarioSteps.startGame(chatId, messageId, username, telegramBot);
            case "HELP" -> creatingMessage.showHelp(chatId, username, telegramBot);
            case "CONTINUE_GAME" -> scenarioSteps.continueGame(chatId, messageId, username, telegramBot);
            case "END_GAME" -> scenarioSteps.endGame(chatId, messageId, username, telegramBot);
            case "CRIME_PLACE" -> scenarioSteps.crimePlace(chatId, messageId, username, telegramBot);
            case "OFFICER" -> scenarioSteps.officer(chatId, messageId, username, telegramBot);
        }
    }
}
