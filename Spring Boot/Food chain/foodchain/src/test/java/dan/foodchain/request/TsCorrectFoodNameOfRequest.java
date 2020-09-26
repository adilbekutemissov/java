package dan.foodchain.request;

import com.lowagie.text.DocumentException;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class TsCorrectFoodNameOfRequest {

    @Test
    public void TsCorrectFoodNameOfRequest() throws FileNotFoundException, DocumentException {
        RequestController.validateCommand("test test butter test test");
        assertTrue(RequestValidation.checkIfFoodIsValid(RequestController.arrayWithPartsOfCommand[2]));
    }

}
