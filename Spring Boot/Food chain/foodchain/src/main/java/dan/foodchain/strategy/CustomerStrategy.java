package dan.foodchain.strategy;

import dan.foodchain.fooditem.FoodItem;

/**
 *
 * @author shukanaz
 */
public class CustomerStrategy extends Strategy {

    @Override
    public void changeToNextState(Strategy strategy, FoodItem foodItem) {
        System.out.println("I got it!\n Process finished!");
    }

}