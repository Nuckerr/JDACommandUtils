package wtf.nucker.JDAUtils;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;

public class LoadupEvent extends ListenerAdapter {

    public void onLoadUpEvent(ReadyEvent e) {
        System.out.println("JDA Utils is running");
    }
}
