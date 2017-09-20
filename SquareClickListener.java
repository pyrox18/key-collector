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
<<<<<<< HEAD
    public void actionPerformed(ActionEvent evt) {
        Board board = Board.getInstance();
        Square playerSquare = board.getCurrentPlayer().getSquare();
        if (board.getCurrentPlayer().move(square)) {
            square.placePlayer(board.getCurrentPlayer());
            playerSquare.removePlayer(board.getCurrentPlayer());
=======
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
>>>>>>> 3d0b735be429ae57c9928fe5e8c1232022dec075
        }
    } 
}