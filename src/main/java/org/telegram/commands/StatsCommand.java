package org.telegram.commands;

import org.telegram.services.Emoji;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StatsCommand extends WhiteListedUserBotCommand {

    private static final String LOGTAG = "STATSCOMMAND";

    public StatsCommand(TelegramLongPollingCommandBot bot) {
        super(bot, "stats", "You want to stay (YES) or leave (NO!) here are some facts about your mood for the last month(s):");
    }


    @Override
    public void executeWhiteListedUser(AbsSender absSender, User user, Chat chat, String[] arguments) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "really sad (1)");
        map.put("2", "I want to quit, aber gehst du wenn ich gehe? (2)");
        map.put("3", "unhappy (3)");
        map.put("4", "depressed (4)");
        map.put("5", "despairing (5)");
        map.put("6", "cheerful (6)");
        map.put("7", "happy (7)");
        map.put("8", "smiling (8)");
        map.put("9", "joyfull (9)");
        map.put("10", "Total happiness (10)");
        map.put("Sleep", "Sleep well unicorn " + Emoji.HEAVY_BLACK_HEART);

        try {
            sendMessage(chat, "Be happy...\nyou want anyway to stay \n" + Emoji.SMILING_FACE_WITH_OPEN_MOUTH
                    + Emoji.SMILING_FACE_WITH_OPEN_MOUTH
                    + Emoji.SMILING_FACE_WITH_OPEN_MOUTH
                    + Emoji.SMILING_FACE_WITH_OPEN_MOUTH
                    + Emoji.HEAVY_BLACK_HEART);
            List<String> strings = Files.readAllLines(Paths.get("./mood.txt"));
            for (String string : strings) {
                String[] split = string.split(",");
                String date = split[0];
                String emotions = split[1];

                sendMessage(chat, "You were " + map.get(emotions) + " on " + date);
            }

        } catch (Exception e) {
            BotLogger.error(LOGTAG, e);
        }
    }
}
