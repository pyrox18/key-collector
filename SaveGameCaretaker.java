/**
 * A class used to manage saved states.
 * 
 * @author Ramanan R Muralitharan (1141128291)
 */
public class SaveGameCaretaker {

    /**
     * The save file
     */
    private Object obj;
    // TODO : Remove the use of Object

    /**
     * Saves the current state of the game
     * 
     * @author Ramanan
     * @param saveGame - the SaveGameOriginator that needs to be overwritten
     */
    public void save(SaveGameOriginator saveGame) {
        this.obj = saveGame.save();
    }

    /**
     * Loads the game to a previous state
     * 
     * @author Ramanan
     * @param saveGame - the SaveGameOriginator that needs to be loaded from
     */
    public void load(SaveGameOriginator saveGame) {
        saveGame.load(saveGame);
    }
    // TODO : change the parameters passed
}