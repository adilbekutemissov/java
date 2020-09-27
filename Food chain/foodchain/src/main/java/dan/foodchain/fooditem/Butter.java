
package dan.foodchain.fooditem;

/**
 *
 * @author shukanaz
 */
public class Butter extends FoodItem {

    public Butter(int gram) {
        setPrice(50);
        setTemperature(5);
        setCount(gram);
        setExpirationDate(getExpirationDate().plusDays(30));
    }
}
