package dan.foodchain.logisticsStates;

import dan.foodchain.fooditem.FoodItem;

public class BoxedState implements LogisticsState {
    @Override
    public void next(FoodItem foodItem) {
        foodItem.setLogisticsState(new DeliveredState());
    }

    @Override
    public void prev(FoodItem foodItem) {
        foodItem.setLogisticsState(new OrderedState());
    }

    @Override
    public void printStatus() {
        System.out.println("Food item boxed and ready for delivering.");
    }
}
