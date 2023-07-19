import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class AutocompleteSystem {
    private Trie trie;
    private Scanner scanner;

    public AutocompleteSystem(String filename) {
        this.trie = new Trie();
        this.scanner = new Scanner(System.in);
        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String word = fileScanner.nextLine().toLowerCase();
                if (word.matches("^[a-z]*$")) {  // Only insert words composed of lower-case alphabets
                    trie.insert(word);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the dictionary file.");
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            System.out.println("Enter a prefix (or type 'exit' to quit): ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting program.");
                break;
            }

            List<String> completions = trie.getWordsForPrefix(input);
            if (completions.isEmpty()) {
                System.out.println("No completions found.");
            } else {
                System.out.println("Completions: ");
                for (String completion : completions) {
                    System.out.println(completion);
                }
            }
        }
    }

    public static void main(String[] args) {
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem("dictionary.txt");
        autocompleteSystem.run();
    }
}
