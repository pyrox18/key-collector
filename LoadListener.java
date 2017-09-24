import java.awt.event.*;
import java.util.ArrayList;

/**
 * 
 */
public class LoadListener implements ActionListener {

    private Board board;
    
    private BoardView boardView;

    private Scoreboard scoreboard;

    public LoadListener (BoardView boardView) {
        this.boardView = boardView;
    }

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
        boardView.refreshBoard();
        scoreboard.refreshScoreboard();
    }
}