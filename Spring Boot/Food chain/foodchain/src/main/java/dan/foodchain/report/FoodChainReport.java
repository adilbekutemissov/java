package dan.foodchain.report;

import com.lowagie.text.Paragraph;
import dan.foodchain.fooditem.FoodItem;
import dan.foodchain.main.Main;
import dan.foodchain.strategy.Strategy;

/**
 * @author utemiadi
 */
public class FoodChainReport extends Strategy {

    @Override
    public void changeToNextState(Strategy strategy, FoodItem foodItem) {
        try {
            Paragraph price, daysToExpire, temperature, count, states;
            Main.foodchainreportdocument.add(new Paragraph("\nFoodItem\r\n"+foodItem.getClass().getSimpleName().toLowerCase()));
            if (foodItem.getStrategy() != null) {
                states = new Paragraph("\nState:\r\n" + foodItem.getStrategy().getClass().getSimpleName().toLowerCase());
                Main.foodchainreportdocument.add(states);
            }
            if (strategy.priceState != foodItem.getPrice()) {
                price = new Paragraph("\nPrice:\r\n" + (String.format("%.2f", foodItem.getPrice())));
                Main.foodchainreportdocument.add(price);
            }
            if (strategy.expirationDateState != foodItem.getExpirationDate()) {
                daysToExpire = new Paragraph("\nDays to expire:\r\n" + foodItem.getExpirationDate());
                Main.foodchainreportdocument.add(daysToExpire);
            }
            if (strategy.temperatureState != foodItem.getTemperature()) {
                temperature = new Paragraph("\nTemperature:\r\n" + foodItem.getTemperature());
                Main.foodchainreportdocument.add(temperature);
            }
            if (strategy.countState != foodItem.getCount()) {
                count = new Paragraph("\nCount:\r\n" + foodItem.getCount());
                Main.foodchainreportdocument.add(count);
            }
            Main.foodchainreportdocument.newPage();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
