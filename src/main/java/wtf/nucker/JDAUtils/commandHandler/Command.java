package wtf.nucker.JDAUtils.commandHandler;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.HashMap;

import static wtf.nucker.JDAUtils.commandHandler.CommandManager.commandMap;


public abstract class Command {
    public static void registerCommand(String name, Command command, String... aliases) {
        commandMap.put(name, command);
        for (int i = 0; i < aliases.length; i++) {
            commandMap.put(aliases[i], command);
        }
    }

    public static void loadCommands() {
        commandMap = new HashMap<>();
    }
    public abstract void onCommand(Message message, Guild guild, TextChannel channel, String[] args);
}
