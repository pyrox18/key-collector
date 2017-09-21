import javax.swing.JPanel;

/**
 * A JPanel that displays information about player's turns and their key inventory.
 * 
 * @author  Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */
public class Scoreboard extends JPanel {
    /**
     * The board model.
     */
    private Board board;

    /**
     * Constructor for the Scoreboard class.
     * 
     * @author Haryz
     */
    public Scoreboard() {
        super(new GridLayout(4, 7));
        board = Board.getInstance();
    }
}