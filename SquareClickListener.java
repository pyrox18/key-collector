/**
 * A class for listening mouse clicks on the squares.
 * 
 * @author  Ramanan R Muralitharan (1141128291)
 */
public class SquareClickListener implements ActionListener{

    /**
     * Default constructor for the SquareClickListener class.
     * Does not do anything.
     * 
     * @author  Ramanan
     */
    public SquareClickListener() {}
    
    /**
     * Moves the player to the clicked square.
     * 
     * @author  Ramanan
     * @param   evt The mouse click on the square.
     * @param   player The player that is going to move.
     * @param   square The square the player wants to move to.
     */
    public void actionPerformed(ActionEvent evt, Player player, Square square) {
        player.move(square);
    } 
}