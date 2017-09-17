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
    public MonkeyMoveStrategy() {}

    /**
     * Retrieves the squares that a player can move towards.
     * Monkey movement strategy permits the player to move three squares in any direction.
     * 
     * @author  Ramanan
     * @param   player The player that is interacting with the key.
     * @return  a boolean  
     */
    @Override
    public ArrayList<Square> getValidMoveLocations(Player player) {

        ArrayList<Square> validSquares = new ArrayList(24);
        Point p = player.getSquare().getLocation();
        
        int x = 3;
        int y = 3;

        for (int i = x; i >= 0; i--) {
            if (i == 0) {
                for (int j = x; j > 0; j--) {
                    try {
                        validSquares.add(instance.squares[p.getX()][p.getY() + j]);
                    } catch (Exception e) {}
                    try {
                        validSquares.add(instance.squares[p.getX()][p.getY() - j]);
                    } catch (Exception e) {}
                }
            }
            else {
                for (int j = y; j >= -y; j = j - y){
                    try {
                        validSquares.add(instance.squares[p.getX() + i][p.getY() + j]);
                    } catch (Exception e) {}
                    try {
                        validSquares.add(instance.squares[p.getX() - i][p.getY() - j]);
                    } catch (Exception e) {}
                }
            }  
            y--;
        }

        return validSquares;
    }
}