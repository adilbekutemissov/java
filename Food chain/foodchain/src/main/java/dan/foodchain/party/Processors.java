package dan.foodchain.party;

/**
 * @author shukanaz
 */
public class Processors extends Party {
    private static Processors instance = null;

    public Processors(Party connectedParty) {
        super(connectedParty);
    }

    public static Processors getInstance(Party connectedParty) {
        if(instance == null) {
            instance = new Processors(connectedParty);
        }
        return instance;
    }

}