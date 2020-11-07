package org.telegram.commands;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

import java.util.Arrays;
import java.util.List;

public abstract class WhiteListedUserBotCommand extends BotCommand {

    private static final String LOGTAG = "USERPERMISSIONS";
    TelegramLongPollingCommandBot bot;

    public WhiteListedUserBotCommand(TelegramLongPollingCommandBot bot, String commandIdentifier, String description) {
        super(commandIdentifier, description);
        this.bot = bot;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        try {
            if (!isInWhiteList(user)) {
                sendMessage(chat, "You are not authorized to use this bot and need to be whitelisted first, contact @CedricWalter and define an @username!");
                return;
            }

            executeWhiteListedUser(absSender, user, chat, strings);

        } catch (TelegramApiException e) {
            BotLogger.error(LOGTAG, e);
        }
    }

    public abstract void executeWhiteListedUser(AbsSender absSender, User user, Chat chat, String[] strings);

    protected void sendMessage(Chat chat, String text) throws TelegramApiException {
        SendMessage message = new SendMessage() // Create a message object object
                .setChatId(chat.getId())
                .setText(text);


        bot.sendMessage(message);
    }

    public boolean isInWhiteList(User user) {
        List<String> whiteList = getWhiteList();
        for (String name : whiteList) {
            if (user.getUserName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getWhiteList() {
        return Arrays.asList("Ellabee,CedricWalter".split(","));
    }
}
