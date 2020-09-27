package dan.foodchain.strategy;

import dan.foodchain.fooditem.FoodItem;

import java.time.LocalDate;

/**
 *
 * @author shukanaz
 */
public abstract class Strategy {

    public double priceState;
    public int countState;
    public LocalDate expirationDateState;
    public int temperatureState;
    
    public abstract void changeToNextState(Strategy strategy, FoodItem foodItem);

}
