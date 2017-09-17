import java.awt.Point;

/**
 * A class used to set the behaviours and specialize the movement strategy of "Pinkey" key.
 * 
 * @author  Ramanan R Muralitharan (1141128291)
 */

public class PinkeyMoveStrategy extends MoveStrategy {

    /**
     * Default constructor for the PinkeyMoveStrategy class.
     * Does not do anything.
     * 
     * @author  Ramanan
     */
    public PinkeyMoveStrategy() {}

    /**
     * Retrieves the squares that a player can move towards.
     * Pinkey movement strategy permits the player to move one square in any direction.
     * 
     * @author  Ramanan
     * @param   player The player that is interacting with the key.
     * @return  a boolean  
     */
    @Override
    public ArrayList<Square> getValidMoveLocations(Player player) {

        ArrayList<Square> validSquares = new ArrayList(9);
        Point p = player.getSquare().getLocation();

        for (int i = -1; i <= 1; i++){
            for (int j = -1; i <= 1; j++){
                try {
                    validSquares.add(instance.squares[p.getX() + i][p.getY() + j]);
                } catch (Exception e) {}
            }
        }
        return validSquares;
    }
}