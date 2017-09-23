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

    /**
     * Saves the current state of the game
     * 
     * @author Ramanan
     * @param  fileName - the name of the file to save into
     */
    public void save(String fileName) {
        currentSave = new SaveFile(fileName);
    }

    /**
     * Loads the game to a previous state.
     * 
     * @author Ramanan
     * @param saveGame - the SaveGameOriginator that needs to be loaded from
     */
    public void load(String fileName) {
        SaveFile newSave = currentSave.load(fileName);
    }
}