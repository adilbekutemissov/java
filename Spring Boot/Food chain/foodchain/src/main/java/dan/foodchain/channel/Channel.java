package dan.foodchain.channel;

import dan.foodchain.blockchain.Block;
import dan.foodchain.blockchain.Transaction;
import dan.foodchain.error.Error;
import dan.foodchain.fooditem.FoodItem;
import dan.foodchain.party.Party;
import dan.foodchain.party.Regulator;
import dan.foodchain.report.TransactionReport;
import dan.foodchain.request.RequestAnalyzer;
import dan.foodchain.request.RequestController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shukanaz
 */
public abstract class Channel {
    private static String command;
    private static List<Party> parties = new ArrayList<>();

    public void addObserver(Party party) {
        this.parties.add(party);
    }
 
    public void removeObserver(Party party) {
        this.parties.remove(party);
    }
 
    public static void setCommand(String command) {
        Channel.command = command;
        Channel.parties.forEach((party) -> {
            party.updatePartyCommand(Channel.command);
        });
    }
    
    public static void handleCommand(String command) {
        String[] arrayWithCommands = command.split(" ");
        int amount = Integer.parseInt(arrayWithCommands[1]);
        String nameOfFoodToSend = arrayWithCommands[2];
        String nameOfPartyToSendFrom = arrayWithCommands[4];
        Boolean partyCanSendFood = false;
        Boolean partyCanSendMoney = false;
        
        Party partyToSendFrom = RequestAnalyzer.returnPartyFromName(nameOfPartyToSendFrom, parties);
        if(Regulator.checkIfPartyHasRequestedFood(partyToSendFrom, nameOfFoodToSend, amount)) {
            partyCanSendFood = true;
        } else {
            Error.foodAmountError();
            return;
        }

        Party partyToGetFood = RequestAnalyzer.returnPartyWhichShouldGetFood(command, Channel.parties);
        FoodItem foodToSend = RequestAnalyzer.returnRequestedFood(partyToSendFrom, nameOfFoodToSend, amount);
        if(Regulator.checkIfPartyHasEnoughMoney(partyToGetFood, foodToSend)) {
            partyCanSendMoney = true;
        } else {
             Error.moneyAmountError();
             return;
        }
        
        if(partyCanSendFood && partyCanSendMoney) {
            partyToSendFrom.sendFood(foodToSend, nameOfFoodToSend);
            foodToSend.nextState();
            partyToGetFood.addFood(foodToSend, nameOfFoodToSend);

            partyToSendFrom.addMoneyToPartyBudget(foodToSend.returnPriceOfRequestedAmountOfFood());
            partyToGetFood.getMoneyFromPartyBudget(foodToSend.returnPriceOfRequestedAmountOfFood());

            Transaction transaction = new Transaction(partyToSendFrom, partyToGetFood, foodToSend);
            Block block = new Block(transaction, partyToSendFrom.getPartyBlockchain().getLastHash());
            partyToGetFood.add(block);
            partyToGetFood.printBlockChain();
            TransactionReport transactionReport = new TransactionReport();
            transactionReport.transaction(partyToSendFrom, partyToGetFood, foodToSend.getCount() * foodToSend.getPrice(), foodToSend, partyToSendFrom.getPartyBlockchain().getLastHash());
        }
        
        String nameOfPartyWhichShouldGetFood = partyToGetFood.getClass().getSimpleName().toLowerCase();
        if(!nameOfPartyWhichShouldGetFood.equals(arrayWithCommands[6].toLowerCase())) {
            command = command.replace(arrayWithCommands[4], nameOfPartyWhichShouldGetFood);
            RequestController.validateCommand(command);
        }
    }
}
