
package dan.foodchain.party;

/**
 * @author shukanaz
 */
public class FoodSupplier extends Party {
    private static FoodSupplier instance = null;

    public FoodSupplier(Party connectedParty) {
        super(connectedParty);
    }

    public static FoodSupplier getInstance(Party connectedParty) {
        if(instance == null) {
            instance = new FoodSupplier(connectedParty);
        }
        return instance;
    }

}