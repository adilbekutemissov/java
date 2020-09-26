package dan.foodchain.request;

import com.lowagie.text.DocumentException;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class TsNotValidateRequest {

    @Test
    public void TsNotValidateRequest() throws FileNotFoundException, DocumentException {
        RequestController.validateCommand("test test test test test test test");
        assertFalse(RequestValidation.checkIfCommandIsValid(RequestController.arrayWithPartsOfCommand));

    }

}
