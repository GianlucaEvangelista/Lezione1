package pawtropolis.command.model;
import pawtropolis.game.GameController;
import pawtropolis.map.model.Room;
import java.util.Map;

public class GoCommand extends Command {
    public GoCommand(GameController gameController) {
        super(gameController);
    }

    @Override
    public boolean execute(GameController gameController, String[] chosenCommand) {
        Map<String, Room> currentAdjacentRooms = gameController.getMapController().getCurrentRoomAdjacentRooms();
        String directionNotAvailable = "There isn't a room in the required direction!";
        switch(chosenCommand[1]) {
            case "north":
                return goNorth(gameController, currentAdjacentRooms, directionNotAvailable);
            case "east":
                return goEast(gameController, currentAdjacentRooms, directionNotAvailable);
            case "south":
                return goSouth(gameController, currentAdjacentRooms, directionNotAvailable);
            case "west":
                return goWest(gameController, currentAdjacentRooms, directionNotAvailable);
            default:
                break;
        }
        return false;
    }

    public static boolean goNorth(GameController gameController, Map<String, Room> currentAdjacentRooms, String directionNotAvailable) {
        if(currentAdjacentRooms.containsKey("north")) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms.get("north"));
            return true;
        } else {
            System.out.println(directionNotAvailable);
            return false;
        }
    }

    public static boolean goEast(GameController gameController, Map<String, Room> currentAdjacentRooms, String directionNotAvailable) {
        if(currentAdjacentRooms.containsKey("east")) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms.get("east"));
            return true;
        } else {
            System.out.println(directionNotAvailable);
            return false;
        }
    }

    public static boolean goSouth(GameController gameController, Map<String, Room> currentAdjacentRooms, String directionNotAvailable) {
        if(currentAdjacentRooms.containsKey("south")) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms.get("south"));
            return true;
        } else {
            System.out.println(directionNotAvailable);
            return false;
        }
    }

    public static boolean goWest(GameController gameController, Map<String, Room> currentAdjacentRooms, String directionNotAvailable) {
        if(currentAdjacentRooms.containsKey("west")) {
            gameController.getMapController().setCurrentRoom(currentAdjacentRooms.get("west"));
            return true;
        } else {
            System.out.println(directionNotAvailable);
            return false;
        }
    }
}