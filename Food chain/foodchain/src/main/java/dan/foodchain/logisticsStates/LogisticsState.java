package dan.foodchain.logisticsStates;

import dan.foodchain.fooditem.FoodItem;

public interface LogisticsState {

    void next(FoodItem foodItem);
    void prev(FoodItem foodItem);
    void printStatus();

}
