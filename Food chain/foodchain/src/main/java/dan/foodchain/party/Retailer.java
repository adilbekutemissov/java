package dan.foodchain.party;

/**
 * @author shukanaz
 */
public class Retailer extends Party {
    private static Retailer instance = null;

    public Retailer(Party connectedParty) {
        super(connectedParty);
    }

    public static Retailer getInstance(Party connectedParty) {
        if(instance == null) {
            instance = new Retailer(connectedParty);
        }
        return instance;
    }

}