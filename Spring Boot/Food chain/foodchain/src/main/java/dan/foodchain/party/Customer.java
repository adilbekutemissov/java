package dan.foodchain.party;

public class Customer extends Party {
   private static Customer instance = null;

    public Customer(Party connectedParty) {
        super(connectedParty);
    }

    public static Customer getInstance(Party connectedParty) {
        if(instance == null) {
            instance = new Customer(connectedParty);
        }
        return instance;
    }

}