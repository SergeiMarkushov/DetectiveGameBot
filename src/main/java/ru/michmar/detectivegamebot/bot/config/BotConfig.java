package ru.michmar.detectivegamebot.bot.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class BotConfig {

    @Value("${bot.username}")
    private String botUserName;

    @Value("${bot.token}")
    private String token;
}
