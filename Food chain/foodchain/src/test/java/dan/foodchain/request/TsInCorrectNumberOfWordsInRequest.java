package dan.foodchain.request;

import com.lowagie.text.DocumentException;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class TsInCorrectNumberOfWordsInRequest {

    @Test
    public void TsInCorrectNumberOfWordsInRequest() throws FileNotFoundException, DocumentException {
        RequestController.validateCommand("test");
        assertNotEquals(RequestController.arrayWithPartsOfCommand.length, 2);
        RequestController.validateCommand("test test");
        assertNotEquals(RequestController.arrayWithPartsOfCommand.length, 3);
        RequestController.validateCommand("test test test test test test");
        assertNotEquals(RequestController.arrayWithPartsOfCommand.length, 7);
    }

}