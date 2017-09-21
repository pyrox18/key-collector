import java.awt.Point;
import java.util.ArrayList;

/**
 * A class used to set the behaviours and specialize the movement strategy of "Key disk" key.
 * 
 * @author  Ramanan R Muralitharan (1141128291)
 */

public class KeyDiskStrategy extends MoveStrategy {

    /**
     * Default constructor for the KeyDiskStrategy class.
     * Does not do anything.
     * 
     * @author  Ramanan
     */
    public KeyDiskStrategy() {}

    /**
     * Retrieves the squares that a player can move towards.
     * Key disk movement permits the player to move up to three squares vertically or horizontally. 
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

        for (int i = 1; i <= x; i++) {
            if (p.y + i > -1 && p.y + i < 9)
                validPoints.add(new Point(p.x, p.y + i));
            if (p.y - i > -1 && p.y - i < 9)
                validPoints.add(new Point(p.x, p.y - i));
        }
        
        for (int j = 1; j <= y; j++) {
            if (p.x + j > -1 && p.x + j < 9)
                validPoints.add(new Point(p.x + j, p.y));
            if (p.x - j > -1 && p.x - j < 9)
                validPoints.add(new Point(p.x - j, p.y));
        }
        return validPoints;
    }
}