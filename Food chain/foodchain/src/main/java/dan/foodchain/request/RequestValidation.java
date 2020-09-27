package dan.foodchain.request;

/**
 *
 * @author shukanaz
 */
public class RequestValidation {
    
    public static boolean checkIfTwoWordRequestIsValid(String[] command) {
        if(!checkIfPartyIsValid(command[0].toLowerCase())) { dan.foodchain.error.Error.validateError(); return false; }
        if(!command[1].toLowerCase().equals("info")) { dan.foodchain.error.Error.validateError(); return false; }
        return true;
    }
    
    public static boolean checkIfThreeWordRequestIsValid(String[] command) {
        if(!command[0].toLowerCase().equals("grow")) { dan.foodchain.error.Error.validateError(); return false; }
        if(!checkIfStringIsInteger(command[1])) { dan.foodchain.error.Error.validateError(); return false; }
        if(!checkIfFoodIsValid(command[2].toLowerCase())) { dan.foodchain.error.Error.validateError(); return false; }
        return true;
    }
    
    public static boolean checkIfStringIsInteger(String number) {
        try { 
            Integer.parseInt(number); 
            return true;
        } catch (NumberFormatException e) { 
            return false; 
        } 
    }
    
    public static boolean checkIfFoodIsValid(String foodItem) {
        boolean validFood = false;
        String[] food = {"butter", "cheese", "eggs", "pork", "chicken", "beef", "milk"};
        for(String f: food) {
            if(foodItem.equals(f)) validFood = true;
        }
        return validFood;
    }
    
    private static boolean checkIfPartyIsValid(String partyItem) {
        boolean validParty = false;
        String[] party = {"customer", "foodsupplier", "grower",
                        "logistics", "processors", "retailer"};
        for(String p: party) {
            if(partyItem.equals(p)) validParty = true;
        }
        return validParty;
    }
    
    public static boolean validateCorrectnessOfParties(String fromParty, String toParty) {
        fromParty = fromParty.toLowerCase();
        toParty = toParty.toLowerCase();
        boolean toPartyIsCorrect = false;
        switch(fromParty){
            case "grower":
                String[] partiesAfterGrower = {"foodsupplier", "processors",
                                                "retailer", "logistics", "customer"};
                for(String p: partiesAfterGrower) {
                    if(toParty.equals(p)) toPartyIsCorrect = true;
                }
                break;
            case "foodsupplier":
                String[] partiesAfterFoodSupplier = {"processors", "retailer",
                                                "logistics", "customer"};
                for(String p: partiesAfterFoodSupplier) {
                    if(toParty.equals(p)) toPartyIsCorrect = true;
                }
                break;
            case "processors":
                String[] partiesAfterProcessors = {"retailer", "logistics", "customer"};
                for(String p: partiesAfterProcessors) {
                    if(toParty.equals(p)) toPartyIsCorrect = true;
                }
                break;
            case "retailer":
                String[] partiesAfterRetailer = {"logistics", "customer"};
                for(String p: partiesAfterRetailer) {
                    if(toParty.equals(p)) toPartyIsCorrect = true;
                }
                break;
            case "logistics":
                String[] partiesAfterLogistics = {"customer"};
                for(String p: partiesAfterLogistics) {
                    if(toParty.equals(p)) toPartyIsCorrect = true;
                }
                break;
            case "customer":
                break;
        }
        return toPartyIsCorrect;
    }
    
    public static boolean checkIfCommandIsValid(String[] command) {
        if(!command[0].toLowerCase().equals("send")) { dan.foodchain.error.Error.validateError(); return false; }
        if(!checkIfStringIsInteger(command[1])) { dan.foodchain.error.Error.validateError(); return false; }
        if(!checkIfFoodIsValid(command[2].toLowerCase())) { dan.foodchain.error.Error.validateError(); return false; }
        if(!command[3].toLowerCase().equals("from")) { dan.foodchain.error.Error.validateError(); return false; }
        if(!checkIfPartyIsValid(command[4].toLowerCase())) { dan.foodchain.error.Error.validateError(); return false; }
        if(!command[5].toLowerCase().equals("to")) { dan.foodchain.error.Error.validateError(); return false; }
        if(!checkIfPartyIsValid(command[6].toLowerCase())) { dan.foodchain.error.Error.validateError(); return false; }
        if(!validateCorrectnessOfParties(command[4], command[6])){ dan.foodchain.error.Error.partiesError(); return false; }
        return true;
    }
    
}
