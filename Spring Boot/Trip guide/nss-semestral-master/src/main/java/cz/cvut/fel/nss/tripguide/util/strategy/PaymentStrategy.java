package cz.cvut.fel.nss.tripguide.util.strategy;

/**
 * interface for payment strategies
 * **/
public interface PaymentStrategy {
    /**
     * do payment
     * @param amount total amount of order
     * **/
    String pay(int amount);
}
