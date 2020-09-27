package dan.foodchain.request;

import org.junit.Test;

import static org.junit.Assert.*;

public class TsCorrectTwoWordRequest {
    @Test
    public void TsValidateRequest() {
        RequestController.validateCommand("grower info");
        assertTrue(RequestValidation.checkIfTwoWordRequestIsValid(RequestController.arrayWithPartsOfCommand));
    }
}
