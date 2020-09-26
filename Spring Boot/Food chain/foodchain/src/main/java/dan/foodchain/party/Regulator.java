package dan.foodchain.party;

import dan.foodchain.fooditem.FoodItem;

/**
 *
 * @author shukanaz
 */
public class Regulator {
    
    public static boolean checkIfPartyHasEnoughMoney(Party partyToSendTo, FoodItem food) {
        return partyToSendTo.getBudget() >= food.returnPriceOfRequestedAmountOfFood();
    }
    
    public static boolean checkIfPartyHasRequestedFood(Party party, String typeofFood, int amountOfFood) {
        return party.checkIfPartyHasFood(typeofFood, amountOfFood);
    }
    
}
