package dan.foodchain.strategy;

import dan.foodchain.fooditem.FoodItem;
import dan.foodchain.report.FoodChainReport;
import dan.foodchain.report.PartiesReport;

/**
 *
 * @author shukanaz
 */
public class LogisticsStrategy extends Strategy {

    @Override
    public void changeToNextState(Strategy strategy, FoodItem foodItem) {
        priceState = foodItem.getPrice();
        countState = foodItem.getCount();
        expirationDateState = foodItem.getExpirationDate();
        temperatureState = foodItem.getTemperature();

        foodItem.setPrice(foodItem.getPrice() * 1.02);
        foodItem.setExpirationDate(foodItem.getExpirationDate().minusDays(1));

        FoodChainReport foodChainReport = new FoodChainReport();
        PartiesReport partiesReport = new PartiesReport();
        foodChainReport.changeToNextState(strategy, foodItem);
        partiesReport.changeToNextState(strategy, foodItem);

        foodItem.setStrategy(new CustomerStrategy());

        foodChainReport = new FoodChainReport();
        foodChainReport.changeToNextState(strategy, foodItem);
    }

}