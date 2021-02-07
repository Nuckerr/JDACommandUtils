package wtf.nucker.JDAUtils.commandHandler;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static wtf.nucker.JDAUtils.commandHandler.CommandManager.commandMap;


public class MessageEvent extends ListenerAdapter {

    private final CommandManager manager;

    public MessageEvent(CommandManager manager) {
        this.manager = manager;
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        if(e.getMessage().getContentRaw().startsWith(manager.getPrefix())) {
            String command = e.getMessage().getContentRaw().substring(1);
            String[] args = command.split(" ");
            if(commandMap.containsKey(args[0])) {
                commandMap.get(args[0]).onCommand(e.getMessage(), e.getGuild(), e.getChannel(), args);
            }
        }
    }
}
