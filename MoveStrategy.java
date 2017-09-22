import java.awt.Point;
import java.util.ArrayList;

/**
 * An abstract class for the movement strategies of each key.
 * 
 * @author Ramanan R Muralitharan (1141128291)
 */

public abstract class MoveStrategy {
    /**
     * Defines the movement strategy of each key.
     * 
     * @author  Ramanan
     * @param   player The player that is interacting with the key.
     * @param   square The square that the player is attempting to move to.
     * @return  a boolean
     */
    public boolean move(Player player, Square square) {
        ArrayList<Point> validMoveLocations = getValidMoveLocations(player);
        for (Point p : validMoveLocations) {
            if (square.getPosition().equals(p)) {
                square.placePlayer(player);
                player.setSquare(square);
                return true;
            }
        }
        return false;
    }


    /**
     * Retrieves the squares that a player can move towards.
     * 
     * @author  Ramanan
     * @param   player The player that is interacting with the key.
     * @return  an ArrayList of Points.
     */
    public abstract ArrayList<Point> getValidMoveLocations(Player player);
}