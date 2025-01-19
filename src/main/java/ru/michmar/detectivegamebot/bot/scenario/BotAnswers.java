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

    //action 1
    public String toOfficer(String username) {
        return "Вы подошли к офицеру. Он вам рассказывает что выяснил. И вот что это....";
    }

    public String toCrimePlace() {
        return "Вы подошли к месту падения жертвы. Вы видите улики:" +
                "\n1)" +
                "\n2)" +
                "\n3)" +
                "\nВам нужно выбрать какие улики являются нужными для расследования. Выбор на кнопках)";
    }

    //description after action 1
    public String evidenceDecisionOne() {
        return "Выбраны улики 1 или 1 и 2. Давайте посмотрим какие выводы можно из этого сделать:"+
                "\n1)" +
                "\n2)" +
                "\nКакой правильный решать вам)";
    }

    public String evidenceDecisionTwo() {
        return "Выбраны улики 2 или 2 и 3. Давайте посмотрим какие выводы можно из этого сделать:"+
                "\n1) А что это там еще такое.... " +
                "\n2)" +
                "\nКакой правильный решать вам)";
    }

    public String evidenceDecisionThree() {
        return "Выбраны улики 3 или 1 и 3. Давайте посмотрим какие выводы можно из этого сделать:"+
                "\n1)" +
                "\n2)" +
                "\nКакой правильный решать вам)";
    }

    public String afterOfficerDecision() {
        return "После разговора с офицером. Давайте посмотрим какие выводы можно из этого сделать:"+
                "\n1)" +
                "\n2)" +
                "\nКакой правильный решать вам)";
    }

    //decisions after action1 and description
    public String afterEvidenceDecisionOnePointOneAndFourPointOne() {
        return  "Здесь пишем вывод по выбору 1.1. и 4.2" +
                "\nИ далее вопрос с двумя ответами";
    }
    public String afterEvidenceDecisionOnePointTwoAndTwoPointTwoAndThreePointOne() {
        return "Здесь пишем вывод по выбору 1.2. и (2.2 и 3.1)" +
        "\nИ далее вопрос с двумя ответами";
    }

    public String afterEvidenceDecisionTwoPointOne() {
        return "Вы подошли близко к окну из которого выпала жертва и вас сдуло порывом ветра. Игра окончена.";
    }

    public String afterEvidenceDecisionThreePointTwoAndFourPointOne() {
        return "Здесь пишем вывод по выбору 3.2 и 4.1" +
                "\nИ далее вопрос с двумя ответами";
    }

    public String endOne() {
        return "Первая концовка";
    }

    public String endTwo() {
        return "Вторая концовка";
    }

    public String endThree() {
        return "Третья концовка";
    }
}
