package wtf.nucker.JDAUtils.commandHandler;

import net.dv8tion.jda.api.JDA;
import wtf.nucker.JDAUtils.LoadupEvent;

import java.util.HashMap;


public class CommandManager {

    private final JDA bot;
    public static HashMap<String, Command> commandMap;
    private final String prefix;

    public CommandManager(JDA jda, String prefix) {
        this.bot = jda;
        this.prefix = prefix;
        commandMap = new HashMap<>();
        bot.addEventListener(new LoadupEvent());
        bot.addEventListener(new MessageEvent(this));
    }

    public void registerCommand(String name, Command cmd, String... aliases) {
        commandMap.put(name, cmd);
        for (int i = 0; i < aliases.length; i++) {
            commandMap.put(aliases[i], cmd);
        }
    }

    public HashMap<String, Command> getCommandMap() {
        return commandMap;
    }

    public Command getCommandByName(String name) {
        return commandMap.get(name);
    }

    public String getPrefix() {
        return prefix;
    }
}
