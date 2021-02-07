package wtf.nucker.JDAUtils;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import wtf.nucker.JDAUtils.commandHandler.CommandManager;

import javax.security.auth.login.LoginException;

public class LoadupEvent extends ListenerAdapter {

    public void onLoadUpEvent(ReadyEvent e) {
        System.out.println("JDA Utils is running");
    }
}
