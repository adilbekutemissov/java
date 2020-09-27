
package dan.foodchain.fooditem;

/**
 *
 * @author shukanaz
 */
public class Milk extends FoodItem {

    public Milk(int gram) {
        setPrice(30);
        setTemperature(5);
        setCount(gram);
        setExpirationDate(getExpirationDate().plusDays(10));
    }
}
