import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.lang.Object;

/**
 * A class that is used to save and load the state of the current game.
 * The states that are saved include the current player turn, player data and key data.
 * Saves are made into text files.
 * A previous save is loaded from a text file.
 * Uses the memento design pattern, where this class acts as the memento.
 * 
 * @author Ramanan R Muralitharan (1141128291)
 */
public class SaveFile {
    /**
     * The current player turn
     */
    private int playerTurn;
    
    /**
     * Array list of all of the players
     */
    private ArrayList<Player> playerData;

    /**
     * Array list of all of the keys
     */
    private ArrayList<Key> keyData;

    /**
     * Icon path to the chest piece
     */
    private String chestIconPath;

    /**
     * Default constructor for the SaveFile class.
     * Does not do anything.
     * 
     * @author  Ramanan
     */
    public SaveFile() {}

    /**
     * A constructor for SaveFile class.
     * Sets the player turn to the current player turn.
     * Sets the player data to the current states of all players on the board.
     * Sets the key data to the current states of all keys on the board.
     * Writes the current state of the instance into a text file.
     * 
     * @author  Ramanan
     * @param   fileName The name of the file to save into.
     */
    public SaveFile(String fileName) {
        playerData = new ArrayList<Player>(4);
        keyData = new ArrayList<Key>(7);

        playerTurn = Board.getInstance().getPlayerTurn();

        for (Player player : Board.getInstance().getAllPlayers()) {
            playerData.add(player);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Object specialPiece = Board.getInstance().getSquare(i,j).getSpecialPiece();
                if (specialPiece instanceof Key) {
                    keyData.add((Key) specialPiece);
                }
                else if (specialPiece instanceof Chest) {
                    chestIconPath = specialPiece.toString();
                }
            }    
        }
        writeToFile(fileName);
    }
    
    /**
     * A private constructor for SaveFile class.
     * Sets the player turn to the player turn from file.
     * Sets the player data to the states of all players in the file.
     * Sets the key data to the current states of all keys in the file.
     * Does not save the new instance to file.
     * 
     * @author  Ramanan
     * @param   playerTurn The player turn from file.
     * @param   playerData The players' data from file.
     * @param   keyData The keys' data from file.
     */
    private SaveFile(int playerTurn, ArrayList<Player> playerData, ArrayList<Key> keyData, String chestIconPath) {
        this.playerTurn = playerTurn;
        this.playerData = playerData;
        this.keyData = keyData;
        this.chestIconPath = chestIconPath;
    }

    /**
     * Gets the current player turn.
     * 
     * @author  Ramanan
     * @return  An int - the counter for the current player turn.
     */
    public int getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Gets the players on the board.
     * 
     * @author  Ramanan
     * @return  An array list of players - the players on the board.
     */
    public ArrayList<Player> getPlayerData() {
        return playerData;
    }

    /**
     * Gets the keys on the board.
     * 
     * @author  Ramanan
     * @return  An array list of keys - the keys on the board.
     */
    public ArrayList<Key> getKeyData() {
        return keyData;
    }

    /**
     * Gets the chest icon path.
     * 
     * @author  Ramanan
     * @return  The chestIconPath.
     */
    public String getChestIconPath() {
        return chestIconPath;
    }

    /**
     * Loads this instance to a previous state.
     * This instance's attributes are set to the attributes from a previous session.
     * 
     * @author  Ramanan
     * @param   fileName The saved file to load from.
     */
    public SaveFile load(String fileName) {
        return readFromFile(fileName);
    }

    /**
     * Writes the current state of the instance into a file.
     * 
     * @author  Ramanan
     * @param   fileName The file to save into.
     */
    private void writeToFile(String fileName) {
        String writeString = playerTurn + "\n";
        for (Key key : keyData) {
            writeString = writeString + key + "\n";
        }
        for (Player player : playerData) {
            writeString = writeString + player + "\n";
        }
        writeString = writeString + chestIconPath;
        
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(writeString);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Unable to write to file '" + fileName + "" );
        }
    }

    /**
     * Reads from a save file and creates a save file instance.
     * 
     * @author  Ramanan
     * @param   fileName The saved file to load from.
     * @return  A save file - the saved file from a previous session.
     */
    private SaveFile readFromFile(String fileName) {
        String fileString = null;
        int line = 1;
        
        int fileTurn = 0;
        ArrayList<Key> fileKey = new ArrayList<Key>(5);
        ArrayList<Player> filePlayer = new ArrayList<Player>(4);
        String fileChestPath = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            fileString = bufferReader.readLine();
            while(fileString != null) {
                if (line == 1) {
                    fileTurn = Integer.parseInt(fileString); 
                }
                else if (line < 7) {
                    Key key = new Key(fileString);
                    fileKey.add(new Key(fileString));
                    Board.getInstance().getSquare(key.getSquare().getPosition().x, key.getSquare().getPosition().y).setSpecialPiece(key);
                }
                else if (line < 11) {
                    filePlayer.add(new Player(fileString));
                }
                else {
                    fileChestPath = fileString.split("\\|")[2];
                }
                fileString = bufferReader.readLine();
                line++;
            }
            bufferReader.close();
            
        } catch (Exception e) {
            System.out.println("Unable to read from file '" + fileName + "'" );
        }
        return new SaveFile(fileTurn, filePlayer, fileKey, fileChestPath);
    }
}

