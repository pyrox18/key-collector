import java.awt.Point;

/**
 * A class used to set the behaviours and specialize the movement strategy of "Pinkey" key.
 * 
 * @author  Ramanan R Muralitharan (1141128291)
 */

public class PinkeyStrategy extends MoveStrategy {

    /**
     * Default constructor for the PinkeyStrategy class.
     * Does not do anything.
     * 
     * @author  Ramanan
     */
    public PinkeyStrategy() {}

    /**
     * Retrieves the squares that a player can move towards.
     * Pinkey movement permits the player to move one square any direction. 
     * 
     * @author  Ramanan
     * @param   player The player that is interacting with the key.
     * @return  an ArrayList of Points.
     */
    @Override
    public ArrayList<Point> getValidMoveLocations(Player player) {

        ArrayList<Point> validPoints = new ArrayList(9);
        Point p = player.getSquare().getPosition();

        for (int i = -1; i <= 1; i++){
            for (int j = -1; i <= 1; j++){
                if (p.getX() + i > -1 && p.getX() + i < 9 && p.getY() + j > -1 && p.getY() + j < 9) 
                    validPoints.add(new Point(p.getX() + i, p.getY() + j));
            }
        }
        return validPoints;
    }
}