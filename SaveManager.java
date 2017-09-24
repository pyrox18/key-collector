/**
 * A class used to manage saved states.
 * 
 * @author Ramanan R Muralitharan (1141128291)
 */
public class SaveManager {

    /**
     * The current save file
     */
    private SaveFile currentSave;

    public SaveManager() {
        currentSave = new SaveFile();
    }

    /**
     * Saves the current state of the game
     * 
     * @author Ramanan
     * @param  fileName - the name of the file to save into
     */
    public void save(String fileName) {
        currentSave = new SaveFile(fileName);
    }

    public void load() {
        Board.getInstance().initializeBoard(currentSave.getPlayerTurn(), currentSave.getPlayerData(), currentSave.getKeyData());
    }
    
    /**
     * Loads the board's state to a previous state.
     * 
     * @author Ramanan
     * @param  fileName - the saved file to load from
     */
    public void load(String fileName) {
        SaveFile newSave = currentSave.load(fileName);
        Board.getInstance().initializeBoard(newSave.getPlayerTurn(), newSave.getPlayerData(), newSave.getKeyData());
    }

}