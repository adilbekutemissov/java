package dan.foodchain.request;

import com.lowagie.text.DocumentException;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class TsInCorrectCreateFoodItem {

    @Test
    public void TsInCorrectCreateFoodItem() throws FileNotFoundException, DocumentException {
        RequestController.validateCommand("test test test");
        assertFalse(RequestValidation.checkIfThreeWordRequestIsValid(RequestController.arrayWithPartsOfCommand));
    }

}
