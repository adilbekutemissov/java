package dan.foodchain.fooditem;

import dan.foodchain.logisticsStates.LogisticsState;
import dan.foodchain.strategy.GrowerStrategy;
import dan.foodchain.strategy.Strategy;
import java.time.LocalDate;

/**
 *
 * @author shukanaz
 */
public abstract class FoodItem {
    private Strategy strategy = new GrowerStrategy();
    private double price;
    private int count;
    private int temperature;
    LocalDate expirationDate = LocalDate.now();

    private LogisticsState logisticsState;

    public void nextState(){
        strategy.changeToNextState(strategy,this);
    }
    
    /**
    * @return the state
    */
    public Strategy getStrategy() {
        return strategy;
    }
    
    /**
     * @param strategy the count to set
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double returnPriceOfRequestedAmountOfFood() {
        return getCount()*getPrice();
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the temperature
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    
    /**
     * @return the expirationDate
     */
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    /**
     * @param expirationDate the price to set
     */
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LogisticsState getLogisticsState() {
        return logisticsState;
    }

    public void setLogisticsState(LogisticsState logisticsState) {
        this.logisticsState = logisticsState;
    }

    public void previousLogisticsState() {
        logisticsState.prev(this);
    }

    public void nextLogisticsState() {
        logisticsState.next(this);
    }

    public void printLogisticStatus() {
        logisticsState.printStatus();
    }
    
    public String returnTypeOfFood() {
        return getClass().getSimpleName().toLowerCase();
    }
}
