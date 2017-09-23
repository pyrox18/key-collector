import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.lang.Object;

// TODO : write/read chest icon to file
// TODO : error handling for file IO operations

/**
 * A class that is used to save and load the state of the current game.
 * The states that are saved include the current player turn, player data and key data.
 * Saves are made into text files.
 * A previous save is loaded from a text file.
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
     * A constructor for SaveFile class.
     * Sets the player turn to the current player turn.
     * Sets the player data to the current states of all players on the board.
     * Sets the key data to the current states of all keys on the board.
     * Writes the current state of the instance into a text file.
     * 
     * @author Ramanan
     * @param filename - the name of the file to save into
     */
    public SaveFile(String fileName) {
        playerData = new ArrayList(4);
        keyData = new ArrayList(7);

        playerTurn = Board.getInstance().getPlayerTurn();

        for (Player player : Board.getInstance().getAllPlayers()) {
            playerData.add(player);
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Object key = Board.getInstance().getSquare(i,j).getSpecialPiece();
                if (key instanceof Key) {
                    keyData.add((Key) key);
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
     * @author Ramanan
     * @param playerTurn - the player turn from file
     * @param playerData - the players' data from file
     * @param keyData - the keys' data from file
     */
    private SaveFile(int playerTurn, ArrayList<Player> playerData, ArrayList<Key> keyData) {
        this.playerTurn = playerTurn;
        this.playerData = playerData;
        this.keyData = keyData;
    }

    /**
     * Gets the current player turn.
     * 
     * @author Ramanan
     * @return an int - the counter for the current player turn
     */
    public int getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Gets the players on the board.
     * 
     * @author Ramanan
     * @return an array list of players - the players on the board
     */
    public ArrayList<Player> getPlayerData() {
        return playerData;
    }

    /**
     * Gets the keys on the board.
     * 
     * @author Ramanan
     * @return an array list of keys - the keys on the board
     */
    public ArrayList<Key> getKeyData() {
        return keyData;
    }

    /**
     * Loads this instance to a previous state.
     * This instance's attributes are set to the attributes from a previous session.
     * 
     * @author Ramanan
     * @param filename - the saved file to load from 
     */
    public SaveFile load(String fileName) {
        return readFromFile(fileName);
    }

    /**
     * Writes the current state of the instance into a file.
     * 
     * @author Ramanan
     * @param filename - the file to save into 
     */
    private void writeToFile(String fileName) {
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
        String writeString = playerTurn + "\n";
        for (Key key : keyData) {
            writeString = writeString + key;
        }
        for (Player player : playerData) {
            writeString = writeString + player;
        }
        bufferedWriter.close();
    }

    /**
     * Reads from a save file and creates a save file instance.
     * 
     * @author Ramanan
     * @param fileName - the saved file to load from
     * @return a save file - the saved file from a previous session
     */
    private SaveFile readFromFile(String fileName) {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferReader = new BufferedReader(fileReader);
        String fileString = null;
        int line = 1;

        int fileTurn = 0;
        ArrayList<Key> fileKey = new ArrayList(5);
        ArrayList<Player> filePlayer = new ArrayList(4);
        while(bufferReader.readLine() != null) {
            fileString = bufferReader.readLine();
            if (line == 1) {
                fileTurn = Integer.parseInt(fileString); 
            }
            else if (line < 6) {
                fileKey.add(new Key(fileString));
            }
            else if (line < 10) {
                filePlayer.add(new Player(fileString));
            }
            line++;
        }
        bufferReader.close();
        return new SaveFile(fileTurn, filePlayer, fileKey);
    }
}

