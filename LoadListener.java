import java.awt.event.*;
import java.util.ArrayList;

/**
 * 
 */
public class LoadListener implements ActionListener {

    private Board board;
    
    private BoardView boardView;

    public LoadListener (BoardView boardView) {
        this.boardView = boardView;
    }

    public void actionPerformed(ActionEvent evt) {
        board = Board.getInstance();
        ArrayList<Player> players = board.getAllPlayers();
        
        for (Player player : players) {
            player.getSquare().removePlayer(player);
        }
        board.load();
        boardView.refreshBoard();
        
    }
}