package dan.foodchain.request;

import org.junit.Test;

import static org.junit.Assert.*;

public class TsInCorrectThreeWordRequest {
    @Test
    public void TsValidateRequest() {
        RequestController.validateCommand("test test test");
        assertFalse(RequestValidation.checkIfThreeWordRequestIsValid(RequestController.arrayWithPartsOfCommand));
    }
}
