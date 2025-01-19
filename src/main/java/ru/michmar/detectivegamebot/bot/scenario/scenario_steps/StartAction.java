package ru.michmar.detectivegamebot.bot.scenario.scenario_steps;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.michmar.detectivegamebot.bot.TelegramBot;
import ru.michmar.detectivegamebot.bot.entity.BotButton;
import ru.michmar.detectivegamebot.bot.scenario.BotAnswers;
import ru.michmar.detectivegamebot.bot.util.MessageUtil;

@Component
@AllArgsConstructor
public class StartAction {
    private final MessageUtil messageUtil;
    private final BotAnswers botAnswers;
    public void startGame(Long chatId, Integer messageId, String username, TelegramBot telegramBot) {
        var go = new BotButton("Поехали!", "CONTINUE_GAME");
        var no = new BotButton("Не, я пасс...", "END_GAME");

        var buttons = messageUtil.makeButtons(go, no);
        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.startHello(username));
    }

    public void continueGame(Long chatId, Integer messageId, String username, TelegramBot telegramBot) {
        var officer = new BotButton("К офицеру", "GO_TO_OFFICER");
        var crime = new BotButton("Место падения", "GO_TO_CRIME_PLACE");

        var buttons = messageUtil.makeButtons(officer, crime);
        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.firstStep(username));
    }

    public void endGame(long chatId, int messageId, String username, TelegramBot telegramBot) {
        messageUtil.clearButtonsFromMessage(chatId, messageId, telegramBot);
        messageUtil.sendMessage(chatId, null, "Очень жаль, " + username + ", было бы интересно", telegramBot);
    }

    public void goToCrimePlace(Long chatId, Integer messageId, TelegramBot telegramBot) {
        var firstButton = new BotButton("1", "EVIDENCE_1");
        var secondButton = new BotButton("2", "EVIDENCE_2");
        var thirdButton = new BotButton("3", "EVIDENCE_3");
        var fourthButton = new BotButton("1 и 2", "EVIDENCE_1_2");
        var fifthButton = new BotButton("2 и 3", "EVIDENCE_2_3");
        var sixButton = new BotButton("1 и 3", "EVIDENCE_1_3");

        var buttons = messageUtil.makeButtons(firstButton, secondButton, thirdButton, fourthButton, fifthButton, sixButton);

        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.toCrimePlace());
    }

    public void goToOfficer(Long chatId, Integer messageId, String username, TelegramBot telegramBot) {
        var firstButton = new BotButton("Давай подумаем над этим...", "CHOICE_OFFICER");

        var buttons = messageUtil.makeButtons(firstButton);

        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.toOfficer(username));
    }
}
