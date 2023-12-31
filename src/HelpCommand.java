public class HelpCommand implements Command{
    public void execute(Game game, String[] commandParts) {
        displayHelp();
    }
    private void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("- go [direction]");
        System.out.println("- look");
        System.out.println("- inventory");
        System.out.println("- take [item_name]");
        System.out.println("- drop [item_name]");
        System.out.println("- help");
        // Add descriptions or usage instructions for each command
    }
}
