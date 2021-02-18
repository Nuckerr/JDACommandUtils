package wtf.nucker.JDAUtils.commandHandler;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;




public abstract class Command {

    public abstract void onCommand(Message message, Guild guild, TextChannel channel, String[] args, GuildMessageReceivedEvent event);
    public abstract CommandInfo getInfo();


    public void success(TextChannel channel, String title, String content, String[]... fields) {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(0x67f444)
                .setTitle(title)
                .setDescription(content);
        for (String[] field : fields) {
            embedBuilder.addField(field[0], field[1], true);
        }
        channel.sendMessage(embedBuilder.build()).queue();
    }

    public void success(TextChannel channel, String content) {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(0x67f444)
                .setTitle("Success")
                .setDescription(content);
        channel.sendMessage(embedBuilder.build()).queue();
    }

    public void error(TextChannel channel, String title, String content, String[]... fields) {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(0xf44444)
                .setTitle(title)
                .setDescription(content);
        for (String[] field : fields) {
            embedBuilder.addField(field[0], field[1], true);
        }
        channel.sendMessage(embedBuilder.build()).queue();
    }
    public void error(TextChannel channel, String content) {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(0xf44444)
                .setTitle("Error")
                .setDescription(content);
        channel.sendMessage(embedBuilder.build()).queue();
    }

    public void warn(TextChannel channel, String title, String content, String[]... fields) {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(0xf4c844)
                .setTitle(title)
                .setDescription(content);
        for (String[] field : fields) {
            embedBuilder.addField(field[0], field[1], true);
        }
        channel.sendMessage(embedBuilder.build()).queue();
    }

    public void warn(TextChannel channel, String content) {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(0xf4c844)
                .setTitle("Warning")
                .setDescription(content);
        channel.sendMessage(embedBuilder.build()).queue();
    }
}
