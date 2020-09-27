package dan.foodchain.blockchain;

import dan.foodchain.fooditem.FoodItem;
import dan.foodchain.party.Party;

import java.text.NumberFormat;

public class Transaction {
    private Party partyFrom;
    private Party partyTo;
    private double price;
    private FoodItem foodItem;
    NumberFormat nf = NumberFormat.getInstance();

    public Transaction(Party partyFrom, Party partyTo, FoodItem foodItem) {
        this.partyFrom = partyFrom;
        this.partyTo = partyTo;
        this.foodItem = foodItem;
        if(foodItem == null) {
            this.price = 0;
        } else
            this.price = foodItem.getPrice()*foodItem.getCount();
    }

    public String getString() {
        if(this.foodItem == null || this.partyFrom == null || this.partyTo == null) {
            return "Start Blockсhain block";
        } else {
            nf.setMaximumFractionDigits(2);
            return String.format(
                    "Food item [%s] was sended from [%s] to [%s], total price: " + nf.format(price) +" Kc",
                    this.foodItem.getClass().getSimpleName(),
                    this.partyFrom.getClass().getSimpleName(),
                    this.partyTo.getClass().getSimpleName());
        }
    }
}
