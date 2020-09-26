package dan.foodchain.request;

import com.lowagie.text.DocumentException;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class TsInCorrectFoodNameOfRequest {

    @Test
    public void TsInCorrectFoodNameOfRequest() throws FileNotFoundException, DocumentException {
        RequestController.validateCommand("send 10 test from");
        assertFalse(RequestValidation.checkIfFoodIsValid(RequestController.arrayWithPartsOfCommand[2]));
    }

}
