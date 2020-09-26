package cz.cvut.fel.nss.tripguide.util.strategy;

/**
 * strategy for card payment
 * **/
public class CreditCardStrategy implements PaymentStrategy {
    /**
     * do payment by card
     * @param amount total amount of order
     * **/
    @Override
    public String pay(int amount) {
       return (amount +" paid with credit/debit card.");
    }
}
