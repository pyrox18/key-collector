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
     * If successful, the player reference is removed from the square he was in, and the player turn advances.
     * 
     * @author  Ramanan
     * @param   evt The mouse click on the square.
     * @param   square The square to move to.
     */
    public void actionPerformed(ActionEvent evt, Square square) {
        Board board = Board.getInstance();
        Player player = board.getCurrentPlayer();
        Square oldSquare = player.getSquare();
        if (player.move(square)) {
            square.placePlayer(player);
            oldSquare.removePlayer(player);
            SpecialPiece specialPiece = square.getSpecialPiece();
            if (specialPiece != null) {
                specialPiece.interact(player);
            }
            board.advanceTurn();
        }
    } 
}