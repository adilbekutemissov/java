//package dan.foodchain.request;
//
//import com.lowagie.text.DocumentException;
//
//import dan.foodchain.party.Grower;
//import dan.foodchain.party.Party;
//import dan.foodchain.request.RequestController;
//import dan.foodchain.request.RequestValidation;
//
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//import java.io.FileNotFoundException;
//import static java.lang.Integer.parseInt;
//
//public class TsCorrectCreateFoodItem {
//
//    @Test
//    public void TsCorrectCreateFoodItem() throws FileNotFoundException, DocumentException {
//        RequestController.validateCommand("grow 10 milk");
//
//        if (RequestValidation.checkIfThreeWordRequestIsValid(RequestController.arrayWithPartsOfCommand)) {
//            Grower.growNewFood(RequestController.arrayWithPartsOfCommand[1], RequestController.arrayWithPartsOfCommand[2]);
////            assertTrue(Party.checkIfPartyHasFood(RequestController.arrayWithPartsOfCommand[2], parseInt(RequestController.arrayWithPartsOfCommand[1])));
//        }
//
//    }
//
//}
