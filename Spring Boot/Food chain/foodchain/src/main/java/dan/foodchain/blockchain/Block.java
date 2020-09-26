package dan.foodchain.blockchain;

import java.util.Date;

public class Block implements Cloneable {
    public String hash;
    public String previousHash;
    public Transaction transaction;
    public long timeStamp;

    public Block(Transaction transaction, String previousHash) {
        this.transaction = transaction;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();

        this.hash = Generator.generateHash(
                this.previousHash
                        + this.timeStamp
                        + this.transaction.toString());
    }

    public static Block getFirstBlock() {
        Transaction transaction = new Transaction(null, null,null);
        Block block = new Block(transaction, "");
        block.timeStamp = 0;
        block.hash = Generator.generateHash(
                block.previousHash
                        + block.timeStamp
                        + block.transaction.toString());
        return block;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
