/**
 * Manages the game's engine by processing user commands and controlling game logic.
 */
public class GameEngine {
    private Player player;

    /**
     * Constructs the game engine with a specified player.
     *
     * @param player The player object for the game.
     */
    public GameEngine(Player player) {
        this.player = player;
    }

    /**
     * Processes the user input as a command and executes it.
     *
     * @param userInput The input provided by the user.
     */
    public void processCommand(String userInput) {
        CommandParser parser = new CommandParser(player);
        Command command = parser.parseCommand(userInput);

        if (command != null) {
            command.execute(player);
        } else {
            System.out.println("Invalid command. Type 'help' for instructions.");
        }
    }
}
