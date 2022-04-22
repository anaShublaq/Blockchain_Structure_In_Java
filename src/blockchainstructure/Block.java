package blockchainstructure;

import java.util.Date;
import java.util.List;

public class Block {

    private String hash;
    private int index;
    private String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;

    public Block() {
    }

    public Block(int index, String data, String previousHash) {
        this.index = index;
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateBlockHash();
    }

    public Block getBlock(List list, int i) {
        Block block = (Block) list.get(i);
        return block;
    }

    public final String calculateBlockHash() {
        String calculatedhash = crypt.sha256(getIndex() + getPreviousHash() + getData() + getTimeStamp() + getNonce());
        return calculatedhash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public int getIndex() {
        return index;
    }

}
