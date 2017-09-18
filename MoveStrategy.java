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
     * @param   square The square that the player is on.
     * @return  a boolean
     */
    public bool move(Player player, Square square) {
        for (Point p : (getValidMoveLocations(player))) {
            if (square.getPosition() == p) {
                square.placePlayer(player);
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