import java.util.*;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Function to insert a word
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (c < 'a' || c > 'z') continue;  // Ignore invalid characters
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    

    // Function to search a word
    private boolean search(TrieNode root, String word) {
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (root.children[index] == null) return false;
            root = root.children[index];
        }
        return root != null && root.isEndOfWord;
    }

    // Function to return words with prefix
    public List<String> getWordsForPrefix(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) return results;
            node = node.children[index];
        }
        findAllChildWords(node, results, prefix);
        return results;
    }

    // Recursive function to find all children words
    private void findAllChildWords(TrieNode node, List<String> results, String prefix) {
        if (node.isEndOfWord) results.add(prefix);
        for (char c = 'a'; c <= 'z'; c++) {
            int index = c - 'a';
            if (node.children[index] != null) {
                findAllChildWords(node.children[index], results, prefix + c);
            }
        }
    }
}
