package ru.michmar.detectivegamebot.bot;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.michmar.detectivegamebot.bot.config.BotConfig;
import ru.michmar.detectivegamebot.bot.service.GameService;

@Component
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig botConfig;
    private final GameService gameService;

    @Override
    public String getBotUsername() {
        return botConfig.getBotUserName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            gameService.handleTextMessage(update, this);
        } else if (update.hasCallbackQuery()) {
            gameService.handleCallbackQuery(update.getCallbackQuery(), this);
        }
    }
}
