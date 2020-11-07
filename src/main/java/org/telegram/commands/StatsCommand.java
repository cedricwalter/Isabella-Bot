package org.telegram.commands;

import org.telegram.services.Emoji;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;


public class StatsCommand extends WhiteListedUserBotCommand {

    private static final String LOGTAG = "STATSCOMMAND";

    public StatsCommand(TelegramLongPollingCommandBot bot) {
        super(bot, "stats", "You want to stay (YES) or leave (NO!) here are some facts about your mood for the last month(s):");
    }

    @Override
    public void executeWhiteListedUser(AbsSender absSender, User user, Chat chat, String[] arguments) {
        try {
            sendMessage(chat, "coming soon...\nbut you want anyway to stay \n" + Emoji.SMILING_FACE_WITH_OPEN_MOUTH
                    + Emoji.SMILING_FACE_WITH_OPEN_MOUTH
                    + Emoji.SMILING_FACE_WITH_OPEN_MOUTH
                    + Emoji.SMILING_FACE_WITH_OPEN_MOUTH
                    + Emoji.HEAVY_BLACK_HEART);

        } catch (TelegramApiException e) {
            BotLogger.error(LOGTAG, e);
        }
    }
}