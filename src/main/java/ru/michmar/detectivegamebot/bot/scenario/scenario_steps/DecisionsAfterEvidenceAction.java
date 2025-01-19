package ru.michmar.detectivegamebot.bot.scenario.scenario_steps;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.michmar.detectivegamebot.bot.TelegramBot;
import ru.michmar.detectivegamebot.bot.entity.BotButton;
import ru.michmar.detectivegamebot.bot.scenario.BotAnswers;
import ru.michmar.detectivegamebot.bot.util.MessageUtil;
@Component
@AllArgsConstructor
public class DecisionsAfterEvidenceAction {

    private final MessageUtil messageUtil;
    private final BotAnswers botAnswers;


    public void afterEvidenceDecisionOnePointOne(Long chatId, Integer messageId, TelegramBot telegramBot) {
        //send message botAnswers.afterActTwoDecisionOfOnePointOne() with buttons

//        Здесь пишем вывод по выбору 1.1. и 4.2
//        И далее вопрос с двумя ответами

        var firstButton = new BotButton("1", "PRE_END_ANSWER_2_1");
        var secondButton = new BotButton("2", "PRE_END_ANSWER_2_2");

        var buttons = messageUtil.makeButtons(firstButton, secondButton);

        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.afterEvidenceDecisionOnePointOneAndFourPointOne());
    }
    public void afterEvidenceDecisionOnePointTwoAndTwoPointTwoAndThePointOne(Long chatId, Integer messageId, TelegramBot telegramBot) {
        var firstButton = new BotButton("1", "PRE_END_ANSWER_1_1");
        var secondButton = new BotButton("2", "PRE_END_ANSWER_1_2");

        var buttons = messageUtil.makeButtons(firstButton, secondButton);

        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.afterEvidenceDecisionOnePointTwoAndTwoPointTwoAndThreePointOne());
    }

    public void afterEvidenceDecisionTwoPointOne(Long chatId, Integer messageId, TelegramBot telegramBot) {
        var firstButton = new BotButton("Начать заново", "CONTINUE_GAME");

        var buttons = messageUtil.makeButtons(firstButton);

        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.afterEvidenceDecisionTwoPointOne());
    }

    public void afterEvidenceDecisionThreePointTwoAndFourPointOne(Long chatId, Integer messageId, TelegramBot telegramBot) {
        var firstButton = new BotButton("1", "PRE_END_ANSWER_3_1");
        var secondButton = new BotButton("2", "PRE_END_ANSWER_3_2");

        var buttons = messageUtil.makeButtons(firstButton,secondButton);

        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, botAnswers.afterEvidenceDecisionThreePointTwoAndFourPointOne());
    }
}

