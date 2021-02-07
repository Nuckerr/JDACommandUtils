# JDAUtils
A Utils libary for JDA

Example:

```java
public static void main(String[] args) throws LoginException {
        JDA bot = JDABuilder.createDefault("TokenGoesHere").build();
        CommandManager manager = new CommandManager(bot, "-");
        manager.registerCommand("example", new ExampleCommand());
    }
```
And `ExampleCommand()`
```java
public class ExampleCommand extends Command {

    @Override
    public void onCommand(Message message, Guild guild, TextChannel channel, String[] args) {
        channel.sendMessage("Example command").queue();
    }
}
```
