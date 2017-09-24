import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * An abstract class that serves as the basis for pieces that are present on the game board
 * (players, keys and chest).
 * Uses the factory method design pattern to generate subclass instances.
 * 
 * @author  Mohamed Haryz Izzudin bin Mohamed Rafy (1141127874)
 * @author  Ramanan R Muralitharan (1141128291)
 */

public abstract class Piece {
    /**
     * The square that the piece is currently on.
     */
    private Square square;

    /**
     * The icon for the piece.
     */
    private ImageIcon icon;

    /**
     * The icon path for the piece.
     */
    private String iconPath;
    
    /**
     * A list of player name strings used for generating Player objects.
     */
    private static final ArrayList<String> playerNames = new ArrayList<String>(Arrays.asList(
        "Ban Gei",
        "Ark Imides",
        "Can Ser",
        "Doz Ciztem"
    ));

    /**
     * A list of player coordinates used for generating Player objects.
     */
    private static final ArrayList<Point> playerPoints = new ArrayList<Point>(Arrays.asList(
        new Point(0, 0),
        new Point(0, 8),
        new Point(8, 0),
        new Point(8, 8)
    ));

    /**
     * A list of player icon path strings used for generating Player objects.
     */
    private static final ArrayList<String> playerIconPaths = new ArrayList<String>(Arrays.asList(
        "/icons/p1.gif",
        "/icons/p2.gif",
        "/icons/p3.gif",
        "/icons/p4.gif"
    ));

    /**
     * A list of key icon path strings used for generating Key objects.
     */
    private static final ArrayList<String> keyIconPaths = new ArrayList<String>(Arrays.asList(
        "/icons/monkey.gif",
        "/icons/donkey.gif",
        "/icons/keydisk.gif",
        "/icons/pinkey.gif",
        "/icons/keynote.gif"
    ));

    /**
     * A string containing the chest icon path.
     */
    private static final String chestIconPath = "/icons/chest.gif";

    /**
     * A list of key icon path strings used for generating Chest objects.
     */
    private static final ArrayList<MoveStrategy> keyStrategies = new ArrayList<MoveStrategy>(Arrays.asList(
        new MonkeyStrategy(),
        new DonkeyStrategy(),
        new KeyDiskStrategy(),
        new PinkeyStrategy(),
        new KeyNoteStrategy()
    ));

    /**
     * A counter to indicate the number of players already generated.
     */
    private static int playersGenerated = 0;

    /**
     * A counter to indicate the number of keys already generated.
     */
    private static int keysGenerated = 0;

    /**
     * Constructor for the Piece class.
     * Sets the square that the piece is initially on.
     * Sets the icon for the piece.
     * 
     * @author  Haryz
     * @param   square The square that the piece is initially on.
     * @param   iconPath The path to the icon for the piece.
     */
    public Piece(Square square, String iconPath){
        this.square = square;
        this.iconPath = iconPath;
        icon = new ImageIcon(getClass().getResource(iconPath));
    }

    /**
     * Gets the square that the piece is currently on.
     * 
     * @author Haryz
     * @return the square
     */
    public Square getSquare() {
        return square;
    }

    /**
     * Sets the square that the piece is currently on.
     * 
     * @author Haryz
     * @param square the square to set
     */
    public void setSquare(Square square) {
        this.square = square;
    }

    /**
     * Gets the icon for the piece.
     * 
     * @author  Ramanan
     * @return  an image icon - the icon used for the piece 
     */
    public ImageIcon getIcon () {
        return icon;
    }

    /**
     * Gets the path for the piece's icon.
     * 
     * @author Ramanan
     * @return a string - the string used to fetch the icon
     */
    public String getIconPath() {
        return iconPath;
    }
    
    /**
     * Produces a new Player object based on the fixed dataset given.
     * 
     * @author  Haryz
     * @return  An instance of Player.
     * @throws  Exception if there are no more players to generate.
     */
    public static Player generateNewPlayer() throws Exception {
        if (playersGenerated >= 4) {
            throw new Exception("Maximum number of players generated");
        }
        else {
            Point point = playerPoints.get(playersGenerated);
            Square square = Board.getInstance().getSquare(point.x, point.y);
            Player player = new Player(square, playerIconPaths.get(playersGenerated), playerNames.get(playersGenerated));
            square.placePlayer(player);
            playersGenerated++;
            return player;
        }
    }

    /**
     * Produces a new Key object based on the fixed dataset given.
     * 
     * @author  Haryz
     * @return  An instance of Key.
     * @throws  Exception if there are no more keys to generate.
     */
    public static Key generateNewKey() throws Exception {
        if (keysGenerated >= 5) {
            throw new Exception("Maximum number of players generated");
        }
        else {
            Board board = Board.getInstance();
            Square square;
            do {
                int randomX = ThreadLocalRandom.current().nextInt(0, 9);
                int randomY = ThreadLocalRandom.current().nextInt(0, 9);
                square = board.getSquare(randomX, randomY);
            } while (square.isPlayerSpawn() || square.getSpecialPiece() != null);
            Key key = new Key(square, keyIconPaths.get(keysGenerated), keyStrategies.get(keysGenerated));
            square.setSpecialPiece(key);
            keysGenerated++;
            return key;
        }
    }

    /**
     * Produces a new Chest object.
     * 
     * @author  Haryz
     * @return  An instance of Chest.
     */
    public static Chest generateNewChest() {
        Square square = Board.getInstance().getSquare(4, 4);
        Chest chest = new Chest(square, chestIconPath, 5);
        square.setSpecialPiece(chest);
        return chest;
    }
}