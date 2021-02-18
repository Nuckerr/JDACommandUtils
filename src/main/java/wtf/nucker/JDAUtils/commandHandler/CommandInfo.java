package wtf.nucker.JDAUtils.commandHandler;

public class CommandInfo {

    private final String description;
    private final String usage;

    public CommandInfo(String description, String usage) {
        this.description = description;
        this.usage = usage;
    }

    public String getDescription() {
        return description;
    }

    public String getUsage() {
        return usage;
    }
}
