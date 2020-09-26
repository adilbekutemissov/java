package dan.foodchain.report;

import com.lowagie.text.Paragraph;
import dan.foodchain.fooditem.FoodItem;
import dan.foodchain.main.Main;
import dan.foodchain.party.Party;

/**
 * @author utemiadi
 */
public class TransactionReport {

    public void transaction(Party partyFrom, Party partyTo, double price, FoodItem foodItem, String hash) {
        try {
            Paragraph partFrom, partto, pric, food, hashes;

            food = new Paragraph("\nFoodItem:\r\n" + foodItem.getClass().getSimpleName().toLowerCase());
            Main.transactionreportdocument.add(food);
            partFrom = new Paragraph("\nParty from:\r\n" + partyFrom.getClass().getSimpleName().toLowerCase());
            Main.transactionreportdocument.add(partFrom);
            partto = new Paragraph("\nParty to:\r\n" + partyTo.getClass().getSimpleName().toLowerCase());
            Main.transactionreportdocument.add(partto);
            pric = new Paragraph("\nPrice:\r\n" + price);
            Main.transactionreportdocument.add(pric);
            hashes = new Paragraph("\nHash:\r\n" + hash);
            Main.transactionreportdocument.add(hashes);

            Main.transactionreportdocument.newPage();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
