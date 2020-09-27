package dan.foodchain.party;

import dan.foodchain.configuration.Configuration;
import dan.foodchain.fooditem.*;

/**
 * @author shukanaz
 */
public class Grower extends Party {
    private static Grower instance = null;

    public Grower(Party connectedParty) {
        super(connectedParty);
    }

    public static Grower getInstance(Party connectedParty) {
        if(instance == null) {
            instance = new Grower(connectedParty);
        }
        return instance;
    }

    public static void growNewFood(String amountOfFood, String typeOfFood) {
        Grower grower = Configuration.getGrower();
        int amount = 0;
        try {
            amount = Integer.parseInt(amountOfFood);
        } catch (NumberFormatException e) {
        }
        switch (typeOfFood) {
            case "butter":
                grower.addFood(new Butter(amount), "butter");
                break;
            case "cheese":
                grower.addFood(new Cheese(amount), "cheese");
                break;
            case "eggs":
                grower.addFood(new Eggs(amount), "eggs");
                break;
            case "pork":
                grower.addFood(new Meat(MeatType.PORK, amount), "pork");
                break;
            case "chicken":
                grower.addFood(new Meat(MeatType.CHICKEN, amount), "chicken");
                break;
            case "beef":
                grower.addFood(new Meat(MeatType.BEEF, amount), "beef");
                break;
            case "milk":
                grower.addFood(new Milk(amount), "milk");
                break;
        }
    }
    
}
