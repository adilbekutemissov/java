package dan.foodchain.request;

import com.lowagie.text.DocumentException;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class TsCorrectNumberOfWordsInRequest {

    @Test
    public void TsCorrectNumberOfWordsInRequest() throws FileNotFoundException, DocumentException {
        RequestController.validateCommand("test test");
        assertEquals(RequestController.arrayWithPartsOfCommand.length, 2);
        RequestController.validateCommand("test test test");
        assertEquals(RequestController.arrayWithPartsOfCommand.length, 3);
        RequestController.validateCommand("test test test test test test test");
        assertEquals(RequestController.arrayWithPartsOfCommand.length, 7);
    }

}