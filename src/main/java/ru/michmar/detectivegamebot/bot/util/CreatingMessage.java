package ru.michmar.detectivegamebot.bot.util;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.michmar.detectivegamebot.bot.TelegramBot;
import ru.michmar.detectivegamebot.bot.entity.BotButton;

@Component
@AllArgsConstructor
public class CreatingMessage {
    private final MessageUtil messageUtil;

    public void sendMainMenu(long chatId, TelegramBot telegramBot) {
        BotButton start = new BotButton("Начать игру", "START_GAME");
        BotButton help = new BotButton("Помощь", "HELP");
        var buttons = messageUtil.makeTwoButtons(start, help);
        messageUtil.sentMessageAndClearButtons(chatId, null, buttons, telegramBot, "Меню");
    }

    public void showHelp(long chatId, String username, TelegramBot telegramBot) {
        String help = "Привет, " + username + "! Вот список доступных команд:\n" +
                "/start - показать главное меню\n" +
                "/help - показать эту справочную информацию\n";
        messageUtil.sendMessage(chatId, null, help, telegramBot);
    }
}
