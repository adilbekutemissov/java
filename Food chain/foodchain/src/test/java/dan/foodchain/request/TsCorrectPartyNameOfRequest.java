package dan.foodchain.request;

import com.lowagie.text.DocumentException;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class TsCorrectPartyNameOfRequest {

    @Test
    public void TsCorrectPartyNameOfRequest() throws FileNotFoundException, DocumentException {
        RequestController.validateCommand("test test test test grower test processors");
        assertTrue(RequestValidation.validateCorrectnessOfParties(RequestController.arrayWithPartsOfCommand[4], RequestController.arrayWithPartsOfCommand[6]));
    }

}
