import java.awt.Point;
import java.util.ArrayList;

/**
 * A class used to set the behaviours and specialize the movement strategy of "Donkey" key.
 * 
 * @author  Ramanan R Muralitharan (1141128291)
 */

public class DonkeyStrategy extends MoveStrategy {

    /**
     * Default constructor for the DonkeyStrategy class.
     * Does not do anything.
     * 
     * @author  Ramanan
     */
    public DonkeyStrategy() {}

    /**
     * Retrieves the squares that a player can move towards.
     * Donkey movement permits the player to move up to three squares diagonally. 
     * 
     * @author  Ramanan
     * @param   player The player that is interacting with the key.
     * @return  an ArrayList of Points.
     */
    @Override
    public ArrayList<Point> getValidMoveLocations(Player player) {

        ArrayList<Point> validPoints = new ArrayList<Point>(12);
        Point p = player.getSquare().getPosition();
        
        int x = 3;
        int y = 3;

        for (int i = x; i >= 0; i--) {
            if (y > 0) {
                for (int j = y; j >= -y; j = j - y){
                    if (j != 0) {
                        if (p.x + i > -1 && p.x + i < 9 && p.y + j > -1 && p.y + j < 9)
                            validPoints.add(new Point(p.x + i, p.y + j));
                        if (p.x - i > -1 && p.x - i < 9 && p.y - j > -1 && p.y - j < 9)
                            validPoints.add(new Point(p.x - i, p.y - j));
                    }        
                }
                y--;
            }
        }

        return validPoints;
    }

    /**
     * Gets a string containing the name of the strategy.
     * 
     * @author  Haryz
     * @return  The strategy's name as a string.
     */
    @Override
    public String toString() {
        return "DonkeyStrategy";
    }
}