package dan.foodchain.party;

import dan.foodchain.blockchain.Block;
import dan.foodchain.blockchain.BlockChain;
import dan.foodchain.fooditem.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Party {
    private final HashMap<String, List> mapOfFood = new HashMap<String, List>();
    private final List<Butter> butter = new ArrayList<>();
    private final List<Cheese> cheese = new ArrayList<>();
    private final List<Eggs> eggs = new ArrayList<>();
    private final List<Meat> pork = new ArrayList<>();
    private final List<Meat> chicken = new ArrayList<>();
    private final List<Meat> beef = new ArrayList<>();
    private final List<Milk> milk = new ArrayList<>();
    private Double budget;
    private String command;

    /**
     * @return the budget
     */
    public Double getBudget() {
        return budget;
    }

    /**
     * @param budget to set
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }
    
    public void addMoneyToPartyBudget(Double amount) {
        setBudget(getBudget() + amount);
    }
    
    public void getMoneyFromPartyBudget(Double amount) {
        setBudget(getBudget() - amount);
    }
    
    /**
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * @param command to set
     */
    public void setCommand(String command) {
        this.command = command;
    }
    
    public void updatePartyCommand(String command) {
        setCommand(command);
    }
    
    public boolean checkIfRecievedCommandRelatesToThisParty(String command) {
        String nameOfPartyInCommand = command.split(" ")[4].toLowerCase();
        String nameOfCurrentParty = getClass().getSimpleName().toLowerCase();
        return nameOfCurrentParty.equals(nameOfPartyInCommand);
    }
    
    public static String returnNameOfPartyWhichShouldGetFood(String partyName) {
        switch(partyName) {
            case "grower":
                return "foodsupplier";
            case "foodsupplier":
                return "processors";
            case "processors":
                return "retailer";
            case "retailer":
                return "logistics";
            case "logistics":
                return "customer";
            default:
                return "";
        }
    }
    
    public void sendFood(FoodItem food, String foodType) {
        mapOfFood.get(foodType).remove(food);
    }
    
    public void addFood(FoodItem food, String foodType) {
        mapOfFood.get(foodType).add(food);
    }
    
    public List<FoodItem> getListOfFood(String food) {
        return mapOfFood.get(food);
    }

    public boolean checkIfPartyHasFood(String typeOfFood, int amountOfFood) {
        for (int i = 0; i < mapOfFood.get(typeOfFood).size(); i++) {
            FoodItem food = (FoodItem) mapOfFood.get(typeOfFood).get(i);
            if (food.getCount() == amountOfFood) {
                return true;
            }
        }
        return false;
    }

    protected BlockChain blockChain;
    private ArrayList<Party> parties;

    public Party(Party connectedParty) {
        mapOfFood.put("butter", butter);
        mapOfFood.put("cheese", cheese);
        mapOfFood.put("eggs", eggs);
        mapOfFood.put("pork", pork);
        mapOfFood.put("chicken", chicken);
        mapOfFood.put("beef", beef);
        mapOfFood.put("milk", milk);
        blockChain = new BlockChain();

        if (connectedParty != null) {
            registerToNetwork(connectedParty);
            try {
                getBlockChain(connectedParty);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Party.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            parties = new ArrayList<>();
        }
    }

    public BlockChain getPartyBlockchain() {
        return blockChain;
    }

    public void add(Block block) {
        try {
            this.blockChain.add(block);
        } catch (IllegalArgumentException e) {
            if (this.parties.size() > 0) {
                try {
                    getBlockChain(this.parties.get(0));
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(Party.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void mine(Block block) {
        this.blockChain.add(block);
        this.parties.forEach((node) -> {
            node.add(block);
        });
    }

    private void registerToNetwork(Party connectedParty) {
        this.parties = connectedParty.getParties();
        this.parties.add(connectedParty);
        this.parties.forEach((party) -> {
            party.register(this);
        });
    }

    private void getBlockChain(Party connectedParty) throws CloneNotSupportedException {
        this.blockChain = (BlockChain) connectedParty.blockChain.clone();
    }

    public ArrayList<Party> getParties() {
        return (ArrayList<Party>) this.parties.clone();
    }

    public void register(Party party) {
        this.parties.add(party);
    }

    public void printBlockChain() {
        System.out.println("\n------ Block chain of [" + this.getClass().getSimpleName() + "] ------");

        this.blockChain.getBlocks().forEach(block -> {
            System.out.println(block.transaction.getString());
        });

        System.out.println("------ END ------\n");
    }

}
