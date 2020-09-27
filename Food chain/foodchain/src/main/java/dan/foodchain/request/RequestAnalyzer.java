package dan.foodchain.request;

import dan.foodchain.channel.Channel;
import dan.foodchain.fooditem.FoodItem;
import dan.foodchain.party.Party;
import dan.foodchain.party.Regulator;
import java.util.List;

/**
 *
 * @author shukanaz
 */
public class RequestAnalyzer {
    
    public static Party returnPartyFromName(String nameOfParty, List<Party> parties) {
        Party party = null;
        for(Party p: parties) {
            if(p.getClass().getSimpleName().toLowerCase()
                    .equals(nameOfParty.toLowerCase())) {
                party = p;
            }
        }
        return party;
    }
    
    public static Party returnPartyWhichShouldGetFood(String command, List<Party> parties) {
        String nameOfPartyWhichShouldSendFood = command.split(" ")[4];
        String nameOfPartyWhichShouldGetFood = Party
                .returnNameOfPartyWhichShouldGetFood(nameOfPartyWhichShouldSendFood);
        Party partyToGetFood = null;
        for(Party party: parties) {
            if(party.getClass().getSimpleName().toLowerCase()
                    .equals(nameOfPartyWhichShouldGetFood.toLowerCase())) {
                partyToGetFood = party;
            }
        }
        return partyToGetFood;
    }
    
    public static FoodItem returnRequestedFood(Party party, String typeOfFood, int amountOfFood) {
        FoodItem food = null;
        for(int i = 0; i < party.getListOfFood(typeOfFood).size(); i++) {
            food = party.getListOfFood(typeOfFood).get(i);
            if(food.getCount() == amountOfFood) {
                return food;
            }
        }
        return food;
    }
    
    
}
