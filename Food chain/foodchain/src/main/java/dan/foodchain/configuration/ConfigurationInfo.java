package dan.foodchain.configuration;

import dan.foodchain.party.Party;

/**
 *
 * @author shukanaz
 */
public class ConfigurationInfo {
    
    private static Party getPartyFromName(String nameOfParty) {
        nameOfParty = nameOfParty.toLowerCase();
        switch(nameOfParty) {
            case "grower":
                return Configuration.getGrower();
            case "foodsupplier":
                return Configuration.getFoodSupplier();
            case "logistics":
                return Configuration.getLogistics();
            case "processors":
                return Configuration.getProcessors();
            case "retailer":
                return Configuration.getRetailer();
            case "customer":
                return Configuration.getCustomer();
            default:
                return null;
        }
    }
    
    private static String printAllObjectsInList(Party party, String typeOfFood) {
        String foodString = "";
        for(int i = 0; i < party.getListOfFood(typeOfFood).size(); i++) {
            foodString += (party.getListOfFood(typeOfFood).get(i).getCount() + "; ");
        }
        return foodString;
    }
    
    public static void printInfoAboutParty(String nameOfParty) {
        Party party = getPartyFromName(nameOfParty);
        System.out.println("\n----- INFO ABOUT OBJECTS: -----");
        System.out.println("Butter objects: " + printAllObjectsInList(party, "butter"));
        System.out.println("Cheese objects: " + printAllObjectsInList(party, "cheese"));
        System.out.println("Eggs objects: " + printAllObjectsInList(party,"eggs"));
        System.out.println("Pork objects: " + printAllObjectsInList(party,"pork"));
        System.out.println("Chicken objects: " + printAllObjectsInList(party,"chicken"));
        System.out.println("Beef objects: " + printAllObjectsInList(party,"beef"));
        System.out.println("Milk objects: " + printAllObjectsInList(party,"milk"));
        System.out.println("Party budget: " + party.getBudget());
        System.out.println("----- END -----\n");
    }
    
}
