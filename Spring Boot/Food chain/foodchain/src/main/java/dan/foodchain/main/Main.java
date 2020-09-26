package dan.foodchain.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import dan.foodchain.configuration.Configuration;
import dan.foodchain.request.RequestController;

/**
 *
 * @author shukanaz
 */
public class Main {

    public static Document foodchainreportdocument;
    public static Document partiesreportdocument;
    public static Document transactionreportdocument;
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        try {
            String command;
            Scanner scanner;
            Configuration config = new Configuration();
            config.setConfiguration();
            System.out.println(ANSI_CYAN + "Welcome to our app.\n"
                    + ANSI_CYAN + "Your can use 3 types of requests:\n"
                    + ANSI_GREEN + "GROW <count> <foodName>\n"
                    + ANSI_GREEN + "SEND <count> <foodName> FROM <partyName> TO <partyName>\n"
                    + ANSI_GREEN + "<partyName> INFO\n"
                    + "To close app just write 'exit'");

            foodchainreportdocument = new Document();
            partiesreportdocument = new Document();
            transactionreportdocument = new Document();

            PdfWriter.getInstance(foodchainreportdocument, new FileOutputStream("FoodChainReport.pdf"));
            PdfWriter.getInstance(partiesreportdocument, new FileOutputStream("PartiesReport.pdf"));
            PdfWriter.getInstance(transactionreportdocument, new FileOutputStream("TransactionReport.pdf"));

            foodchainreportdocument.open();
            Phrase phraseFoodChain = new Phrase();
            Paragraph paragraphFoodChain = new Paragraph();
            phraseFoodChain.add(new Chunk("Food Chain Report", FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 16)));
            paragraphFoodChain.add(phraseFoodChain);
            paragraphFoodChain.setAlignment(Element.ALIGN_CENTER);
            foodchainreportdocument.add(paragraphFoodChain);

            partiesreportdocument.open();
            Phrase phraseParties = new Phrase();
            Paragraph paragraphParties = new Paragraph();
            phraseParties.add(new Chunk("Parties Report", FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 16)));
            paragraphParties.add(phraseParties);
            paragraphParties.setAlignment(Element.ALIGN_CENTER);
            partiesreportdocument.add(paragraphParties);

            transactionreportdocument.open();
            Phrase phraseTransaction = new Phrase();
            Paragraph paragraphTransaction = new Paragraph();
            phraseTransaction.add(new Chunk("Transaction Report", FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 16)));
            paragraphTransaction.add(phraseTransaction);
            paragraphTransaction.setAlignment(Element.ALIGN_CENTER);
            transactionreportdocument.add(paragraphTransaction);

            while (true) {
                System.out.print(ANSI_CYAN + "Please enter your request: ");
                scanner = new Scanner(System.in);
                command = scanner.nextLine();
                command = command.toLowerCase();
                if (command.equals("exit")) break;
                RequestController.validateCommand(command);
            }
        } finally {
            foodchainreportdocument.close();
            partiesreportdocument.close();
            transactionreportdocument.close();
        }
    }
    
}
