package ru.michmar.detectivegamebot.bot.scenario;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.michmar.detectivegamebot.bot.TelegramBot;
import ru.michmar.detectivegamebot.bot.entity.BotButton;
import ru.michmar.detectivegamebot.bot.util.MessageUtil;

@Component
@AllArgsConstructor
public class ScenarioSteps {
    private final MessageUtil messageUtil;
    private final BotAnswers botAnswers;
    public void startGame(long chatId, int messageId, String username, TelegramBot telegramBot) {
        BotButton go = new BotButton("Поехали!", "CONTINUE_GAME");
        BotButton no = new BotButton("Не, я пасс...", "END_GAME");

        var buttons = messageUtil.makeTwoButtons(go, no);
        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.startHello(username));
    }

    public void continueGame(long chatId, int messageId, String username, TelegramBot telegramBot) {
        BotButton officer = new BotButton("К офицеру", "OFFICER");
        BotButton crime = new BotButton("Место падения", "CRIME_PLACE");

        var buttons = messageUtil.makeTwoButtons(officer, crime);
        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.firstStep(username));
    }

    public void endGame(long chatId, int messageId, String username, TelegramBot telegramBot) {
        messageUtil.clearButtonsFromMessage(chatId, messageId, telegramBot);
        messageUtil.sendMessage(chatId, null, "Очень жаль, " + username + ", было бы интересно", telegramBot);
    }

    public void crimePlace(long chatId, int messageId, String username, TelegramBot telegramBot) {
        messageUtil.clearButtonsFromMessage(chatId, messageId, telegramBot);
        messageUtil.sendMessage(chatId, null, botAnswers.toCrimePlace(username), telegramBot);
    }

    public void officer(long chatId, int messageId, String username, TelegramBot telegramBot) {
        messageUtil.clearButtonsFromMessage(chatId, messageId, telegramBot);
        messageUtil.sendMessage(chatId, null, botAnswers.toOfficer(username), telegramBot);
    }
}
