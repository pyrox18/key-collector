import java.awt.event.*;
import java.util.ArrayList;

/**
 * A button click listener for loading a saved game file.
 * 
 * @author  Ramanan R Muralitharan (1141128291)
 */
public class LoadListener implements ActionListener {
    /**
     * The game's board instance.
     */
    private Board board;
    
    /**
     * The board view.
     */
    private BoardView boardView;

    /**
     * The scoreboard view.
     */
    private Scoreboard scoreboard;

    /**
     * Constructor for the LoadListener class.
     * Sets the board view reference for the class.
     * 
     * @author  Ramanan
     */
    public LoadListener (BoardView boardView) {
        this.boardView = boardView;
    }

    /**
     * Loads a saved game state from a file when the button is clicked.
     * 
     * @author  Ramanan
     */
    public void actionPerformed(ActionEvent evt) {
        board = Board.getInstance();
        scoreboard = Scoreboard.getInstance();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i != 4 && j != 4) {
                    board.getSquare(i,j).removeSpecialPiece();
                }
            }
        }
        board.load();
        if (boardView.isGameEnded()) {
            boardView.newGame();
        }
        else {
            boardView.refreshBoard();
        }
        scoreboard.refreshScoreboard();
    }
}