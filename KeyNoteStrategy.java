import java.awt.Point;

/**
 * A class used to set the behaviours and specialize the movement strategy of "Key note" key.
 * 
 * @author  Ramanan R Muralitharan (1141128291)
 */

public class KeyNoteStrategy extends MoveStrategy {

    /**
     * Default constructor for the KeyNoteStrategy class.
     * Does not do anything.
     * 
     * @author  Ramanan
     */
    public KeyNoteStrategy() {}

    /**
     * Retrieves the squares that a player can move towards.
     * Key note movement restricts the player to move two squares in any direction. 
     * 
     * @author  Ramanan
     * @param   player The player that is interacting with the key.
     * @return  an ArrayList of Points.
     */
    @Override
    public ArrayList<Point> getValidMoveLocations(Player player) {

        ArrayList<Point> validPoints = new ArrayList(8);
        Point p = player.getSquare().getPosition();

        int x = 2;
        int y = 2;

        for (int i = x; i >= 0; i = i - x) {
            for (int j = y; j >= -y; j = j - y){
                if (i != 0 && j != 0) {
                    if (p.getX() + i > -1 && p.getX() + i < 9 && p.getY() + j > -1 && p.getY() + j < 9)
                        validPoints.add(new Point(p.getX() + i, p.getY() + j));
                    else if (p.getX() - i > -1 && p.getX() - i < 9 && p.getY() - j > -1 && p.getY() - j < 9)
                            validPoints.add(new Point(p.getX() - i, p.getY() - j));

                }
            }
        }

        return validPoints;
    }
}