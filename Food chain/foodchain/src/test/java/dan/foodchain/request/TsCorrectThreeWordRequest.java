package dan.foodchain.request;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TsCorrectThreeWordRequest {
    @Test
    public void TsValidateRequest() {
        RequestController.validateCommand("grow 10 milk");
        assertTrue(RequestValidation.checkIfThreeWordRequestIsValid(RequestController.arrayWithPartsOfCommand));
    }
}
