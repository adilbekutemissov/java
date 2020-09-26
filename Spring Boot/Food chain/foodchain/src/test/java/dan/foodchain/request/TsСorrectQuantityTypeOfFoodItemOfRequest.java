package dan.foodchain.request;

import com.lowagie.text.DocumentException;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class TsСorrectQuantityTypeOfFoodItemOfRequest {

    @Test
    public void TsСorrectQuantityTypeOfFoodItemOfRequest() throws FileNotFoundException, DocumentException {
        RequestController.validateCommand("test 10 test test");
        assertTrue(RequestValidation.checkIfStringIsInteger(RequestController.arrayWithPartsOfCommand[1]));
    }

}