import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A JPanel that displays information about player's turns and their key inventory.
 * Uses the singleton design pattern.
 * 
 * @author  Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */
public class Scoreboard extends JPanel {
    /**
     * The singleton instance for the scoreboard.
     */
    private static Scoreboard instance = new Scoreboard();

    /**
     * The board model.
     */
    private Board board;

    /**
     * Constructor for the Scoreboard class.
     * 
     * @author Haryz
     */
    private Scoreboard() {
        super(new GridLayout(4, 7));
        board = Board.getInstance();
        refreshScoreboard();
    }
    
    /**
     * Gets the instance of the scoreboard.
     * 
     * @author Haryz
     * @return the instance
     */
    public static Scoreboard getInstance() {
        return instance;
    }

    /**
     * Repaints the scoreboard with the current data from the board.
     * 
     * @author Haryz
     */
    public void refreshScoreboard() {
        for (Component c : getComponents()) {
            remove(c);
        }
        ArrayList<Player> players = board.getAllPlayers();
        for (int i = 0; i < 4; i++) {
            Player player = players.get(i);
            JLabel playerLabel = new JLabel(player.getIcon());
            if (board.getCurrentPlayer().equals(player)) {
                playerLabel.setBackground(Color.ORANGE);
                playerLabel.setOpaque(true);
            }
            add(playerLabel);
            add(new JLabel(player.getPlayerName()));
            ArrayList<Key> playerKeys = player.getKeys();
            for (int j = 0; j < 5; j++) {
                if (j < playerKeys.size()) {
                    Key key = playerKeys.get(j);
                    add(new JLabel(key.getIcon()));
                }
                else {
                    add(new JLabel("Empty"));
                }
            }
        }
    }
}