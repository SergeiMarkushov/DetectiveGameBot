package ru.michmar.detectivegamebot.bot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BotButton {
    private String text;
    private String data;
}
