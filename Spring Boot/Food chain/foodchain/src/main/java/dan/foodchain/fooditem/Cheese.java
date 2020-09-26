
package dan.foodchain.fooditem;

/**
 *
 * @author shukanaz
 */
public class Cheese extends FoodItem {

    public Cheese(int gram) {
        setPrice(70);
        setTemperature(5);
        setCount(gram);
        setExpirationDate(getExpirationDate().plusDays(15));
    }
}
