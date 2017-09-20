import java.awt.Point;
import java.util.ArrayList;

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

        ArrayList<Point> validPoints = new ArrayList<Point>(9);
        Point p = player.getSquare().getPosition();

        for (int i = -1; i <= 1; i++){
            for (int j = -1; i <= 1; j++){
                if (p.x + i > -1 && p.x + i < 9 && p.y + j > -1 && p.y + j < 9) 
                    validPoints.add(new Point(p.x + i, p.y + j));
            }
        }
        return validPoints;
    }
}