import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private final Map<String, Command> commandMap;

    public CommandProcessor() {
        this.commandMap = new HashMap<>();
        initializeCommands();
    }

    private void initializeCommands() {
        commandMap.put("go", new GoCommand());
        commandMap.put("look", new LookCommand());
        commandMap.put("help", new HelpCommand());

        // Add other commands to the map
    }

    public void processCommand(Game game, String command) {
        String[] commandParts = command.toLowerCase().split(" ");
        Command cmd = commandMap.get(commandParts[0]);
        if (cmd != null) {
            cmd.execute(game, commandParts);
        } else {
            System.out.println("Invalid command. Type 'help' for instructions.");
        }
    }
}
