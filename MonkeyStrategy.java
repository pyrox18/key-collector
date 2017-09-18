import java.awt.Point;

/**
 * A class used to set the behaviours and specialize the movement strategy of "Monkey" key.
 * 
 * @author  Ramanan R Muralitharan (1141128291)
 */

public class MonkeyStrategy extends MoveStrategy {

    /**
     * Default constructor for the MonkeyStrategy class.
     * Does not do anything.
     * 
     * @author  Ramanan
     */
    public MonkeyStrategy() {}

    /**
     * Retrieves the squares that a player can move towards.
     * Monkey movement permits the player to move up to three squares in any direction. 
     * 
     * @author  Ramanan
     * @param   player The player that is interacting with the key.
     * @return  an ArrayList of Points.
     */
    @Override
    public ArrayList<Point> getValidMoveLocations(Player player) {

        ArrayList<Point> validPoints = new ArrayList(24);
        Point p = player.getSquare().getPosition();
        
        int x = 3;
        int y = 3;

        for (int i = x; i >= 0; i--) {
            if (i == 0) {
                for (int j = y; j > 0; j--) {
                    if (p.getX() + i > -1 && p.getX() + i < 9 && p.getY() + j > -1 && p.getY() + j < 9)
                        validPoints.add(new Point(p.getX() + i, p.getY() + j));
                    else if (p.getX() - i > -1 && p.getX() - i < 9 && p.getY() - j > -1 && p.getY() - j < 9)
                            validPoints.add(new Point(p.getX() - i, p.getY() - j));
                }
            }
            else {
                for (int j = y; j >= -y; j = j - y){
                    if (p.getX() + i > -1 && p.getX() + i < 9 && p.getY() + j > -1 && p.getY() + j < 9)
                        validPoints.add(new Point(p.getX() + i, p.getY() + j));
                    else if (p.getX() - i > -1 && p.getX() - i < 9 && p.getY() - j > -1 && p.getY() - j < 9)
                            validPoints.add(new Point(p.getX() - i, p.getY() - j));
                }
            }  
            y--;
        }

        return validPoints;
    }
}