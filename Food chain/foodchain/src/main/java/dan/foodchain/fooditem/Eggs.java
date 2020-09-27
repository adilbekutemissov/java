
package dan.foodchain.fooditem;

/**
 *
 * @author shukanaz
 */
public class Eggs extends FoodItem {

    public Eggs(int gram) {
        setPrice(40);
        setTemperature(10);
        setCount(gram);
        setExpirationDate(getExpirationDate().plusDays(30));
    }
}
