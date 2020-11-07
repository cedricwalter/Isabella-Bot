# Isabella Happyness telegram-bot

## help
```
Help
These are the registered commands for this Bot:

/help
Get all the commands this bot provides
```

# Installation

Create a new bot using https://telegram.me/BotFather and /newbot

if it goes well you will get in return

```
Done! Congratulations on your new bot. You will find it at t.me/xx-name-of-bot-xx. 

You can now add a description, about section and profile picture for your bot, see /help for a list of commands.
By the way, when you've finished creating your cool bot, ping our Bot Support if you want a better username for it. 
Just make sure the bot is fully operational before you do this.

Use this token to access the HTTP API:
xxxxxxxxxx:xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

For a description of the Bot API, see this page: https://core.telegram.org/bots/api
```

Copy the config.properties in classpath and configure

```
token=xxxxxxxxxx:xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
user=xx-name-of-bot-xx
whitelisted=name of @username allowed to use the bot
excel=full path to excel file
```

Execute maven package and run like this 
```
java -jar isabella-1.0-SNAPSHOT-jar-with-dependencies.jar
```

# Resources
https://core.telegram.org/bots
