/**
 * A class used to manage saved states.
 * Uses the memento design pattern, where this class acts as the caretaker.
 * 
 * @author  Ramanan R Muralitharan (1141128291)
 */
public class SaveManager {
    /**
     * The current save file.
     */
    private SaveFile currentSave;

    /**
     * Constructor for the SaveManager class.
     * Sets the current save to a new save file.
     */
    public SaveManager() {
        currentSave = new SaveFile();
    }

    /**
     * Saves the current state of the game.
     * 
     * @author  Ramanan
     * @param   fileName The name of the file to save into.
     */
    public void save(String fileName) {
        currentSave = new SaveFile(fileName);
    }
    
    /**
     * Loads the board's state to a previous state.
     * 
     * @author  Ramanan
     * @param   fileName - the saved file to load from
     */
    public void load(String fileName) {
        SaveFile newSave = currentSave.load(fileName);
        Board.getInstance().initializeBoard(newSave);
    }

}