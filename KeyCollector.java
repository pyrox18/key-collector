import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * The main application class for the KeyCollector game.
 * 
 * @author  Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 */
public class KeyCollector extends JFrame {
    /**
     * The view object for the board.
     */
    private BoardView boardView;
    /**
     * The scoreboard panel.
     */
    private Scoreboard scoreboard;

    /**
     * Constructor for the KeyCollector class.
     * Creates a BorderLayout window with the title set to "Key Collector",
     * then adds all the necessary view objects.
     * 
     * @author Haryz
     */
    public KeyCollector() {
        super("Key Collector");
        setLayout(new BorderLayout());
        boardView = new BoardView();
        scoreboard = Scoreboard.getInstance();
        add(boardView, BorderLayout.CENTER);
        add(scoreboard, BorderLayout.EAST);
        setSize(1100, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Main method for the KeyCollector application.
     * 
     * @author Haryz
     */
    public static void main(String[] args) {
        new KeyCollector();
    }
}