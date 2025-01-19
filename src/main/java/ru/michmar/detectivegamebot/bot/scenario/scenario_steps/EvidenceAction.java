package ru.michmar.detectivegamebot.bot.scenario.scenario_steps;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.michmar.detectivegamebot.bot.TelegramBot;
import ru.michmar.detectivegamebot.bot.entity.BotButton;
import ru.michmar.detectivegamebot.bot.scenario.BotAnswers;
import ru.michmar.detectivegamebot.bot.util.MessageUtil;

@Component
@AllArgsConstructor
public class EvidenceAction {
    private final MessageUtil messageUtil;
    private final BotAnswers botAnswers;

    public void evidenceDecisionOne(Long chatId, Integer messageId, TelegramBot telegramBot) {
        //send message botAnswers.evidenceDecisionOne() with buttons
        var firstButton = new BotButton("1", "ACT_2_DECISION_1_1");
        var secondButton = new BotButton("2", "ACT_2_DECISION_1_2");

        var buttons = messageUtil.makeButtons(firstButton, secondButton);

        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.evidenceDecisionOne());
    }

    public void evidenceDecisionTwo(Long chatId, Integer messageId, TelegramBot telegramBot) {
        var firstButton = new BotButton("Ого, что это?", "ACT_2_DECISION_2_1");
        var secondButton = new BotButton("2", "ACT_2_DECISION_2_2");

        var buttons = messageUtil.makeButtons(firstButton, secondButton);

        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.evidenceDecisionTwo());
    }

    public void evidenceDecisionThree(Long chatId, Integer messageId, TelegramBot telegramBot) {
        var firstButton = new BotButton("1", "ACT_2_DECISION_3_1");
        var secondButton = new BotButton("2", "ACT_2_DECISION_3_2");

        var buttons = messageUtil.makeButtons(firstButton, secondButton);

        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.evidenceDecisionThree());
    }

    public void afterOfficerDecision(Long chatId, Integer messageId, TelegramBot telegramBot) {
        var firstButton = new BotButton("1", "ACT_2_DECISION_4_1");
        var secondButton = new BotButton("2", "ACT_2_DECISION_4_2");

        var buttons = messageUtil.makeButtons(firstButton, secondButton);

        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.afterOfficerDecision());
    }
}
