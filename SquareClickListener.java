import java.awt.event.*;  
/**
 * A class for listening mouse clicks on the squares.
 * 
 * @author  Ramanan R Muralitharan (1141128291)
 */
public class SquareClickListener implements ActionListener{

    private Square square;
    /**
     * Default constructor for the SquareClickListener class.
     * Does not do anything.
     * 
     * @author  Ramanan
     */
    public SquareClickListener() {}
    
    /**
     * Moves the player to the clicked square.
     * If succesful, the player reference is removed from the square he was in.
     * 
     * @author  Ramanan
     * @param   evt The mouse click on the square.
     */
    public void actionPerformed(ActionEvent evt) {
        Board board = Board.getInstance();
        Square playerSquare = board.getCurrentPlayer().getSquare();
        if (board.getCurrentPlayer().move(square)) {
            square.placePlayer(board.getCurrentPlayer());
            playerSquare.removePlayer(board.getCurrentPlayer());
        }
    } 
}