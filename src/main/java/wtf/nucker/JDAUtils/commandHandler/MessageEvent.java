package wtf.nucker.JDAUtils.commandHandler;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.MessageType;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static wtf.nucker.JDAUtils.commandHandler.CommandManager.commandMap;


public class MessageEvent extends ListenerAdapter {

    private final CommandManager manager;

    public MessageEvent(CommandManager manager) {
        this.manager = manager;
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        if(!e.getMessage().getType().equals(MessageType.DEFAULT)) return;
        if(e.getMessage().getMember().getUser().isBot()) return;
        if(!e.getMessage().getChannelType().equals(ChannelType.TEXT)) return;
        if(Arrays.asList(manager.getPrefixes()).contains(String.valueOf(e.getMessage().getContentRaw().charAt(0)))) {
            String command = e.getMessage().getContentRaw().substring(1);
            String[] cmd = command.split(" ");
            if(commandMap.containsKey(cmd[0].toLowerCase())) {
                String[] args = command.substring(cmd[0].length()).split(" ");
                commandMap.get(cmd[0]).onCommand(e.getMessage(), e.getGuild(), e.getChannel(), args, e);
            }
        }
    }
}
