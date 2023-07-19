public class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26]; // For 26 English alphabet
        this.isEndOfWord = false;
    }
}
