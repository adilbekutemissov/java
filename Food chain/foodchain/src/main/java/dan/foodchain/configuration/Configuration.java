package dan.foodchain.configuration;

import dan.foodchain.channel.*;
import dan.foodchain.party.*;

/**
 * @author shukanaz
 */
public class Configuration {
    private static Grower grower = Grower.getInstance(null);
    private static FoodSupplier foodSupplier = FoodSupplier.getInstance(grower);
    private static Processors processors = Processors.getInstance(foodSupplier);
    private static Logistics logistics = Logistics.getInstance(processors);
    private static Retailer retailer = Retailer.getInstance(logistics);
    private static Customer customer = Customer.getInstance(retailer);

    public void setConfiguration() {
        getGrower().setBudget(0);
        getFoodSupplier().setBudget(10000);
        getProcessors().setBudget(10000);
        getLogistics().setBudget(10000);
        getRetailer().setBudget(10000);
        getCustomer().setBudget(10000);

        ButterChannel butterObservable = new ButterChannel();
        butterObservable.addObserver(getGrower());
        butterObservable.addObserver(getFoodSupplier());
        butterObservable.addObserver(getProcessors());
        butterObservable.addObserver(getLogistics());
        butterObservable.addObserver(getRetailer());
        butterObservable.addObserver(getCustomer());
        
        CheeseChannel cheeseObservable = new CheeseChannel();
        cheeseObservable.addObserver(getGrower());
        cheeseObservable.addObserver(getFoodSupplier());
        cheeseObservable.addObserver(getProcessors());
        cheeseObservable.addObserver(getLogistics());
        cheeseObservable.addObserver(getRetailer());
        cheeseObservable.addObserver(getCustomer());

        EggsChannel eggsObservable = new EggsChannel();
        eggsObservable.addObserver(getGrower());
        eggsObservable.addObserver(getFoodSupplier());
        eggsObservable.addObserver(getProcessors());
        eggsObservable.addObserver(getLogistics());
        eggsObservable.addObserver(getRetailer());
        eggsObservable.addObserver(getCustomer());
        
        MeatChannel meatObservable = new MeatChannel();
        meatObservable.addObserver(getGrower());
        meatObservable.addObserver(getFoodSupplier());
        meatObservable.addObserver(getProcessors());
        meatObservable.addObserver(getLogistics());
        meatObservable.addObserver(getRetailer());
        meatObservable.addObserver(getCustomer());
        
        MilkChannel milkObservable = new MilkChannel();
        milkObservable.addObserver(getGrower());
        milkObservable.addObserver(getFoodSupplier());
        milkObservable.addObserver(getProcessors());
        milkObservable.addObserver(getLogistics());
        milkObservable.addObserver(getRetailer());
        milkObservable.addObserver(getCustomer());
    }

    /**
     * @return the grower
     */
    public static Grower getGrower() {
        return grower;
    }

    /**
     * @return the foodSupplier
     */
    public static FoodSupplier getFoodSupplier() {
        return foodSupplier;
    }

    /**
     * @return the processors
     */
    public static Processors getProcessors() {
        return processors;
    }

    /**
     * @return the logistics
     */
    public static Logistics getLogistics() {
        return logistics;
    }

    /**
     * @return the retailer
     */
    public static Retailer getRetailer() {
        return retailer;
    }

    /**
     * @return the customer
     */
    public static Customer getCustomer() {
        return customer;
    }
    
}
