package ru.michmar.detectivegamebot.bot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ru.michmar.detectivegamebot.bot.TelegramBot;
import ru.michmar.detectivegamebot.bot.entity.BotButton;
import ru.michmar.detectivegamebot.bot.scenario.BotAnswers;
import ru.michmar.detectivegamebot.bot.service.interfaces.CallbackQueryHandler;
import ru.michmar.detectivegamebot.bot.util.CreatingMessage;
import ru.michmar.detectivegamebot.bot.util.MessageUtil;

@Component
@AllArgsConstructor
public class CallbackQueryHandlerImpl implements CallbackQueryHandler {
    private final BotAnswers botAnswers;
    private final CreatingMessage creatingMessage;
    private final MessageUtil messageUtil;

    @Override
    public void handleCallbackQuery(CallbackQuery callbackQuery, TelegramBot telegramBot) {
        String data = callbackQuery.getData();
        int messageId = callbackQuery.getMessage().getMessageId();
        long chatId = callbackQuery.getMessage().getChatId();
        String username = callbackQuery.getFrom().getFirstName();

        if (data.equals("START_GAME")) {
            startGame(chatId, messageId, username, telegramBot);
        } else if (data.equals("HELP")) {
            creatingMessage.showHelp(chatId, username, telegramBot);
        } else if (data.equals("CONTINUE_GAME")) {
            continueGame(chatId, messageId, username, telegramBot);
        } else if (data.equals("END_GAME")) {
            endGame(chatId, messageId, username, telegramBot);
        } else if (data.equals("CRIME_PLACE")) {
            crimePlace(chatId, messageId, username, telegramBot);
        } else if (data.equals("OFFICER")) {
            officer(chatId, messageId, username, telegramBot);
        }
    }

    private void startGame(long chatId, int messageId, String username, TelegramBot telegramBot) {
        BotButton go = new BotButton("Поехали!", "CONTINUE_GAME");
        BotButton no = new BotButton("Не, я пасс...", "END_GAME");

        var buttons = messageUtil.makeTwoButtons(go, no);
        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.startHello(username));
    }

    private void continueGame(long chatId, int messageId, String username, TelegramBot telegramBot) {
        BotButton officer = new BotButton("К офицеру", "OFFICER");
        BotButton crime = new BotButton("Место падения", "CRIME_PLACE");

        var buttons = messageUtil.makeTwoButtons(officer, crime);
        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.firstStep(username));
    }

    private void endGame(long chatId, int messageId, String username, TelegramBot telegramBot) {
        messageUtil.clearButtonsFromMessage(chatId, messageId, telegramBot);
        messageUtil.sendMessage(chatId, null, "Очень жаль, " + username + ", было бы интересно", telegramBot);
    }

    private void crimePlace(long chatId, int messageId, String username, TelegramBot telegramBot) {
        messageUtil.clearButtonsFromMessage(chatId, messageId, telegramBot);
        messageUtil.sendMessage(chatId, null, botAnswers.toCrimePlace(username), telegramBot);
    }

    private void officer(long chatId, int messageId, String username, TelegramBot telegramBot) {
        messageUtil.clearButtonsFromMessage(chatId, messageId, telegramBot);
        messageUtil.sendMessage(chatId, null, botAnswers.toOfficer(username), telegramBot);
    }
}
