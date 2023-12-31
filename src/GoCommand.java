public class GoCommand implements Command  {
    public void execute(Game game, String[] commandParts) {
        // Logic to handle "go" command
        if (commandParts.length > 1) {
            String direction = commandParts[1];
            move(direction);
        } else {
            System.out.println("Go where?");
        }
    }


    /**
     * Moves the player in the specified direction if possible.
     *
     * @param direction The direction in which the player wants to move.
     */
    private void move(String direction) {
        Direction dir = null;
        switch (direction) {
            case "north":
                dir = Direction.NORTH;
                break;
            case "east":
                dir = Direction.EAST;
                break;
            case "south":
                dir = Direction.SOUTH;
                break;
            case "west":
                dir = Direction.WEST;
                break;
            default:
                System.out.println("Invalid direction.");
                return;
        }

//        Location nextLocation = currentLocation.getExit(dir);
//        if (nextLocation != null) {
//            currentLocation = nextLocation;
//            System.out.println("You have moved to: " + currentLocation.getDescription());
//        } else {
//            System.out.println("You cannot go that way.");
//        }
    }
}
