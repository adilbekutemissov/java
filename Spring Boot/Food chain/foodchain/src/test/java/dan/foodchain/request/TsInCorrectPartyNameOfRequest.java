package dan.foodchain.request;

import com.lowagie.text.DocumentException;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class TsInCorrectPartyNameOfRequest {

    @Test
    public void TsCorrectPartyNameOfRequest() throws FileNotFoundException, DocumentException {
        RequestController.validateCommand("send 10 butter from test to test");
        assertFalse(RequestValidation.validateCorrectnessOfParties(RequestController.arrayWithPartsOfCommand[4], RequestController.arrayWithPartsOfCommand[6]));
    }

}
