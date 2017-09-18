import java.awt.Point;

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

        ArrayList<Point> validPoints = new ArrayList(12);
        Point p = player.getSquare().getPosition();
        
        int x = 3;
        int y = 3;

        for (int i = x; i >= 0; i--) {
                for (int j = y; j >= -y; j = j - y){
                    if (p.getX() + i > -1 && p.getX() + i < 9 && p.getY() + j > -1 && p.getY() + j < 9)
                        validPoints.add(new Point(p.getX() + i, p.getY() + j));
                    else if (p.getX() - i > -1 && p.getX() - i < 9 && p.getY() - j > -1 && p.getY() - j < 9)
                            validPoints.add(new Point(p.getX() - i, p.getY() - j));
                }
            y--;
        }

        return validPoints;
    }
}