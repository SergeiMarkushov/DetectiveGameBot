package ru.michmar.detectivegamebot.bot.scenario;

import org.springframework.stereotype.Component;

@Component
public class BotAnswers {
    public String startHello(String username) {
        return "Привет, " + username + "! Мы здесь собрались, что бы поиграть в интересную игру. Ты будешь детективом, который расследует таинственное падение жертвы из окна 14 этажа многоэтажки в элитном" +
                " районе. \nНа данный момент известно, что прибывшие на место происшествия сотрудники полиции отцепили все входы и выходы из многоэтажки и никого не пускают и не выпускают от туда никого." +
                "\nПредлагаю отправиться туда и посмотреть своими глазами на происходящее.";
    }

    public String firstStep(String username) {
        return "И так, детектив " + username + ", вы прибыли на место происшествия." +
                "\nПодойдя ближе вы видите сотрудника полиции который опрашивает свидетелей" +
                " и само место куда \"приземлилась\" жертва. Вам предстоит выбор: подойти к сотруднику или пойти к месту происшествия," +
            " куда пойдем?";
    }

    public String toOfficer(String username) {
        return "Вы подошли к офицеру";
    }

    public String toCrimePlace(String username) {
        return "Вы подошли к месту падения жертвы";
    }
}
