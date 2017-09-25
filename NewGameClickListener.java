import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A class that listens for mouse clicks on a New Game button.
 * 
 * @author  Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */
public class NewGameClickListener implements ActionListener {
    /**
     * The board view.
     */
    private BoardView boardView;

    /**
     * Constructor for the NewGameClickListener class.
     * Sets the board view.
     * 
     * @author  Haryz
     */
    public NewGameClickListener (BoardView boardView) {
        this.boardView = boardView;
    }

    /**
     * Resets and reinitialises the board for a new game.
     * 
     * @author  Haryz
     * @param   evt The mouse click event.
     */
    public void actionPerformed(ActionEvent evt) {
        Board board = Board.getInstance();
        Scoreboard scoreboard = Scoreboard.getInstance();
        Piece.resetPiecesGenerated();
        board.initializeBoard();
        boardView.newGame();
        scoreboard.refreshScoreboard();
    }
}