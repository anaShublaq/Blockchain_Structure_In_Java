package blockchainstructure;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BlockUtils extends Block {

    List<Block> blockchain = new ArrayList<>();

    BlockUtils() {
    }

    public BlockUtils(int index, String data, String previousHash) throws IOException {
        super(index, data, previousHash);
    }

    public final List<Block> getBlockChain() {
        return blockchain;
    }

    public Block getLastBlock() {
        return blockchain.get(blockchain.size() - 1);
    }

    public void createGenesisBlock() throws FileNotFoundException, IOException {
        getBlockChain().add(new Block(0, "This is a Genesis Block !!", "0"));
    }

    public void addBlock(String data) throws IOException {
        if (blockchain.isEmpty()) {
            createGenesisBlock();
        }
        Block newBlock = new Block(getLastBlock().getIndex() + 1, data, getLastBlock().getHash());
        blockchain.add(newBlock);
    }

    public void blocksExplorer() throws IOException {
        for (int i = 0; i < blockchain.size(); i++) {
            System.out.println("\n+------------------------------------------------------------------------------------+\n"
                    + "|  Block name: " + blockchain.get(i).getIndex() + "\n"
                    + "|  Block Hash: " + blockchain.get(i).getHash() + "\n"
                    + "|  Block previousHash: " + blockchain.get(i).getPreviousHash() + "\n"
                    + "|  Block Data: { " + blockchain.get(i).getData() + " }\n"
                    + "|  Block nonce: " + blockchain.get(i).getNonce() + "\n"
                    + "|  Block TimeStamp: " + blockchain.get(i).getTimeStamp() + "\n"
                    + "+-------------------------------------------------------------------------------------+\n");
        }
    }

    public boolean isChainValid() {
        for (int i = blockchain.size() - 1; i > 0; i--) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);
            if (!currentBlock.getHash().equals(currentBlock.calculateBlockHash())) {
                return false;
            }
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }

}
