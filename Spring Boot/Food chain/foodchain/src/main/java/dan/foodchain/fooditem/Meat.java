
package dan.foodchain.fooditem;

/**
 *
 * @author shukanaz
 */
public class Meat extends FoodItem {

    public Meat(MeatType type, int gram) {
        setPrice(100);
        setTemperature(0);
        setType(type);
        setCount(gram);
        setExpirationDate(getExpirationDate().plusDays(40));
    }

    private MeatType type;

    /**
     * @return the type
     */
    public MeatType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(MeatType type) {
        this.type = type;
    }
    
}
