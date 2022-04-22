package blockchainstructure;

import java.io.IOException;

public class simpleChain {

    public static void main(String[] args) throws IOException {

        BlockUtils blockChain = new BlockUtils();

        blockChain.addBlock("Hi !!");
        blockChain.addBlock("My Name is Anas !!");

        blockChain.blocksExplorer();
        System.out.println(blockChain.isChainValid());
    }

}
