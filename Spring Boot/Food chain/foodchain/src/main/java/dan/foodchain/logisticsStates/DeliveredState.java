package dan.foodchain.logisticsStates;

import dan.foodchain.fooditem.FoodItem;

public class DeliveredState implements LogisticsState {

    @Override
    public void next(FoodItem foodItem) {
        System.out.println("Food item was already delivered.");
    }

    @Override
    public void prev(FoodItem foodItem) {
        foodItem.setLogisticsState(new BoxedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Food item was delivered.");
    }
}
