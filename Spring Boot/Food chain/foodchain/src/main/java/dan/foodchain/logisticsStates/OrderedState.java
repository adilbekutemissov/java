package dan.foodchain.logisticsStates;

import dan.foodchain.fooditem.FoodItem;

public class OrderedState implements LogisticsState {
    @Override
    public void next(FoodItem foodItem) {
        foodItem.setLogisticsState(new BoxedState());
    }

    @Override
    public void prev(FoodItem foodItem) {
        System.out.println("Food item is in it's root state");
    }

    @Override
    public void printStatus() {
        System.out.println("Food item ordered, not delivered to customer yet.");
    }
}
