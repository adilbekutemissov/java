package dan.foodchain.error;

/**
 *
 * @author shukanaz
 */
public class Error {
    public static void validateError() {
        System.out.println("Something wrong! Please try again");
    }
    
    public static void partiesError() {
        System.out.println("You can't do requests between those parties! Please try again");
    }
    
    public static void requestLengthError() {
        System.out.println("You request has wrong length! Please try again");
    }
    
    public static void foodAmountError() {
        System.out.println("Party has not enough food!");
    }
    
    public static void moneyAmountError() {
        System.out.println("Party has not enough money!");
    }
}
