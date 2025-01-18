package ru.michmar.detectivegamebot.bot.util;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.michmar.detectivegamebot.bot.TelegramBot;
import ru.michmar.detectivegamebot.bot.entity.BotButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageUtil {
    public void clearButtonsFromMessage(long chatId, int messageId, TelegramBot telegramBot) {
        EditMessageReplyMarkup editMessageReplyMarkup = new EditMessageReplyMarkup();
        editMessageReplyMarkup.setChatId(chatId);
        editMessageReplyMarkup.setMessageId(messageId);
        editMessageReplyMarkup.setReplyMarkup(null);

        try {
            telegramBot.execute(editMessageReplyMarkup);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sentMessageAndClearButtons(long chatId, Integer messageId,
                                           InlineKeyboardMarkup buttons, TelegramBot telegramBot, String answer) {
        if (messageId != null) {
            clearButtonsFromMessage(chatId, messageId, telegramBot);
        }

        sendMessage(chatId, buttons, answer, telegramBot);
    }

    public InlineKeyboardMarkup makeTwoButtons(BotButton button1, BotButton button2) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();

        InlineKeyboardButton firstButton = new InlineKeyboardButton();
        firstButton.setText(button1.getText());
        firstButton.setCallbackData(button1.getData());

        InlineKeyboardButton secondButton = new InlineKeyboardButton();
        secondButton.setText(button2.getText());
        secondButton.setCallbackData(button2.getData());

        rowInline.add(firstButton);
        rowInline.add(secondButton);
        rowsInline.add(rowInline);

        markupInline.setKeyboard(rowsInline);

        return markupInline;
    }

    public void sendMessage(long chatId, InlineKeyboardMarkup buttons, String message, TelegramBot telegramBot) {
        SendMessage sendMessage = new SendMessage();
        if (buttons != null) {
            sendMessage.setReplyMarkup(buttons);
        }
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
