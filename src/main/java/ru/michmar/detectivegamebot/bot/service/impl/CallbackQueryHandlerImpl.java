package ru.michmar.detectivegamebot.bot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ru.michmar.detectivegamebot.bot.TelegramBot;
import ru.michmar.detectivegamebot.bot.scenario.scenario_steps.DecisionsAfterEvidenceAction;
import ru.michmar.detectivegamebot.bot.scenario.scenario_steps.EndAction;
import ru.michmar.detectivegamebot.bot.scenario.scenario_steps.EvidenceAction;
import ru.michmar.detectivegamebot.bot.scenario.scenario_steps.StartAction;
import ru.michmar.detectivegamebot.bot.service.interfaces.CallbackQueryHandler;
import ru.michmar.detectivegamebot.bot.util.CreatingMessage;

@Component
@AllArgsConstructor
public class CallbackQueryHandlerImpl implements CallbackQueryHandler {
    private final CreatingMessage creatingMessage;
    private final StartAction startAction;
    private final EvidenceAction evidenceAction;
    private final DecisionsAfterEvidenceAction decisionsAfterEvidenceAction;
    private final EndAction endAction;

    @Override
    public void handleCallbackQuery(CallbackQuery callbackQuery, TelegramBot telegramBot) {
        var data = callbackQuery.getData();
        var messageId = callbackQuery.getMessage().getMessageId();
        var chatId = callbackQuery.getMessage().getChatId();
        var username = callbackQuery.getFrom().getFirstName();

        switch (data) {
            //action1
            //start
            case "START_GAME" -> startAction.startGame(chatId, messageId, username, telegramBot);
            case "HELP" -> creatingMessage.showHelp(chatId, username, telegramBot);
            case "CONTINUE_GAME" -> startAction.continueGame(chatId, messageId, username, telegramBot);
            case "END_GAME" -> startAction.endGame(chatId, messageId, username, telegramBot);
            case "GO_TO_CRIME_PLACE" -> startAction.goToCrimePlace(chatId, messageId, telegramBot);
            case "GO_TO_OFFICER" -> startAction.goToOfficer(chatId, messageId,username, telegramBot);

            //action 2
            //crime
            case "EVIDENCE_1", "EVIDENCE_1_2" -> evidenceAction.evidenceDecisionOne(chatId,messageId,telegramBot);
            case "EVIDENCE_2", "EVIDENCE_2_3" -> evidenceAction.evidenceDecisionTwo(chatId,messageId,telegramBot);
            case "EVIDENCE_3", "EVIDENCE_1_3" -> evidenceAction.evidenceDecisionThree(chatId,messageId,telegramBot);
            //officer
            case "CHOICE_OFFICER" -> evidenceAction.afterOfficerDecision(chatId,messageId,telegramBot);

            //DECISIONS AFTER CRIME PLACE AND OFFICER DIALOG
            case "ACT_2_DECISION_1_1", "ACT_2_DECISION_4_2"  -> decisionsAfterEvidenceAction.afterEvidenceDecisionOnePointOne(chatId, messageId, telegramBot);
            case "ACT_2_DECISION_1_2",
                    "ACT_2_DECISION_2_2",
                    "ACT_2_DECISION_3_1" -> decisionsAfterEvidenceAction.afterEvidenceDecisionOnePointTwoAndTwoPointTwoAndThePointOne(chatId, messageId, telegramBot);

            case "ACT_2_DECISION_2_1" -> decisionsAfterEvidenceAction.afterEvidenceDecisionTwoPointOne(chatId, messageId, telegramBot);

            case "ACT_2_DECISION_3_2", "ACT_2_DECISION_4_1" -> decisionsAfterEvidenceAction.afterEvidenceDecisionThreePointTwoAndFourPointOne(chatId, messageId, telegramBot);

            //pre end question answers
            case "PRE_END_ANSWER_1_1", "PRE_END_ANSWER_2_1" -> endAction.firstEnd(chatId, messageId, telegramBot);
            case "PRE_END_ANSWER_1_2", "PRE_END_ANSWER_3_1" -> endAction.secondEnd(chatId, messageId, telegramBot);
            case "PRE_END_ANSWER_2_2", "PRE_END_ANSWER_3_2" -> endAction.thirdEnd(chatId, messageId, telegramBot);


        }
    }
}
