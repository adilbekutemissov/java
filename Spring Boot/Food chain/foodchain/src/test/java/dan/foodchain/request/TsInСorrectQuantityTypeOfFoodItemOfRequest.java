package dan.foodchain.request;

import com.lowagie.text.DocumentException;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class TsInСorrectQuantityTypeOfFoodItemOfRequest {

    @Test
    public void TsInСorrectQuantityTypeOfFoodItemOfRequest() throws FileNotFoundException, DocumentException {
        RequestController.validateCommand("send test butter from");
        assertFalse(RequestValidation.checkIfStringIsInteger(RequestController.arrayWithPartsOfCommand[1]));
    }

}