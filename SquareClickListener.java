import java.awt.event.*;  
/**
 * A class for listening mouse clicks on the squares.
 * 
 * @author  Ramanan R Muralitharan (1141128291)
 */
public class SquareClickListener implements ActionListener{
    /**
     * The board view.
     */
    private BoardView boardView;
    /**
     * The button that is clicked.
     */
    private SquareButton button;

    /**
     * Default constructor for the SquareClickListener class.
     * Sets the square button that is clicked.
     * 
     * @author  Ramanan
     */
    public SquareClickListener(BoardView boardView, SquareButton button) {
        this.boardView = boardView;
        this.button = button;
    }
    
    /**
     * Moves the player to the clicked square.
     * If successful, the player reference is removed from the square he was in, and the player turn advances.
     * 
     * @author  Ramanan
     * @author  Haryz
     * @param   evt The mouse click on the square.
     */
    public void actionPerformed(ActionEvent evt) {
        Board board = Board.getInstance();
        Player player = board.getCurrentPlayer();
        Square newSquare = button.getSquare();
        Square oldSquare = player.getSquare();
        System.out.println("clicked " + newSquare.getPosition());
        System.out.println(player.getPlayerName());
        if (player.move(newSquare)) {
            System.out.println("player moved successfully");
            oldSquare.removePlayer(player);
            SpecialPiece specialPiece = newSquare.getSpecialPiece();
            if (specialPiece != null) {
                specialPiece.interact(player);
            }
            boardView.refreshBoard();
            board.advanceTurn();
        }
    } 
}