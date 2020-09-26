package dan.foodchain.party;

/**
 * @author shukanaz
 */
public class Logistics extends Party {
    private static Logistics instance = null;

    public Logistics(Party connectedParty) {
        super(connectedParty);
    }

    public static Logistics getInstance(Party connectedParty) {
        if(instance == null) {
            instance = new Logistics(connectedParty);
        }
        return instance;
    }

}