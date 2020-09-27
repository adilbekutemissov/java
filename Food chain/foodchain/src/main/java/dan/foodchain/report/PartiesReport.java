package dan.foodchain.report;

import com.lowagie.text.Paragraph;
import dan.foodchain.fooditem.FoodItem;
import dan.foodchain.main.Main;
import dan.foodchain.strategy.Strategy;

/**
 * @author utemiadi
 */
public class PartiesReport extends Strategy {

    public void changeToNextState(Strategy state, FoodItem foodItem) {
        try {
            Paragraph price, daysToExpire, temperature, count, states;
            Main.partiesreportdocument.add(new Paragraph("\nFoodItem\r\n"+foodItem.getClass().getSimpleName().toLowerCase()));
            if (foodItem.getStrategy() != null) {
                states = new Paragraph("\nState:\r\n" + foodItem.getStrategy().getClass().getSimpleName().toLowerCase());
                Main.partiesreportdocument.add(states);
            }
            if (state.priceState != foodItem.getPrice()) {
                double priceDifference = foodItem.getPrice()-state.priceState;
                price = new Paragraph("\nPrice:\r\n" + (String.format("%.2f", priceDifference)));
                Main.partiesreportdocument.add(price);
            }
            if (state.expirationDateState != foodItem.getExpirationDate()) {
                daysToExpire = new Paragraph("\nDays to expire:\r\n" + foodItem.getExpirationDate());
                Main.partiesreportdocument.add(daysToExpire);
            }
            if (state.temperatureState != foodItem.getTemperature()) {
                int temperatureDifference = foodItem.getTemperature()-state.temperatureState;
                temperature = new Paragraph("\nTemperature:\r\n" + temperatureDifference);
                Main.partiesreportdocument.add(temperature);
            }
            if (state.countState != foodItem.getCount()) {
                int countDifference = foodItem.getCount() - state.countState;
                count = new Paragraph("\nCount:\r\n" + countDifference);
                Main.partiesreportdocument.add(count);
            }
            Main.partiesreportdocument.newPage();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
