package ru.michmar.detectivegamebot.bot.scenario.scenario_steps;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.michmar.detectivegamebot.bot.TelegramBot;
import ru.michmar.detectivegamebot.bot.entity.BotButton;
import ru.michmar.detectivegamebot.bot.scenario.BotAnswers;
import ru.michmar.detectivegamebot.bot.util.MessageUtil;

@Component
@AllArgsConstructor
public class EndAction {
    private final MessageUtil messageUtil;
    private final BotAnswers botAnswers;

    public void firstEnd(Long chatId, Integer messageId, TelegramBot telegramBot) {
        end(chatId, messageId, telegramBot, botAnswers.endOne());
    }

    public void secondEnd(Long chatId, Integer messageId, TelegramBot telegramBot) {
        end(chatId, messageId, telegramBot, botAnswers.endTwo());
    }

    public void thirdEnd(Long chatId, Integer messageId, TelegramBot telegramBot) {
        end(chatId, messageId, telegramBot, botAnswers.endThree());
    }

    private void end(Long chatId, Integer messageId, TelegramBot telegramBot, String action) {
        var button = new BotButton("Начать заново", "CONTINUE_GAME");
        var buttons = messageUtil.makeButtons(button);

        messageUtil.sentMessageAndClearButtons(chatId, messageId, buttons, telegramBot, action);
    }

}