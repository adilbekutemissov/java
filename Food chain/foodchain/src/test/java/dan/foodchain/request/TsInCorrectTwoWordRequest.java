package dan.foodchain.request;

import org.junit.Test;

import static org.junit.Assert.*;

public class TsInCorrectTwoWordRequest {
    @Test
    public void TsValidateRequest() {
        RequestController.validateCommand("test info");
        assertFalse(RequestValidation.checkIfTwoWordRequestIsValid(RequestController.arrayWithPartsOfCommand));
    }
}
