import java.util.Map;

public class GameEngine {
    private Player player;
    private Map<String, Location> locations;

    public GameEngine() {
        commandProcessor = new CommandProcessor();
    }

    public void processUserInput(String input) {
        commandProcessor.processCommand(this, input);
    }
}
