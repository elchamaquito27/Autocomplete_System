This code was ran in Visual Studio Code.

***Autocomplete System***

This Autocomplete System is a simple console application that provides autocomplete suggestions based on a prefix entered by the user. It uses a trie data structure to store and retrieve words efficiently.

**Features:**

-Provides autocomplete suggestions for a given prefix.
-Case-insensitive.
-Allows users to exit the application by typing 'exit'.
-Populates the trie with words from a provided dictionary file.

**Setup:**

To run this project:

1. Clone the project to your local machine.

2. Ensure you have a Java Runtime Environment (JRE) installed. This project was developed using Java SE Development Kit (JDK) 8.

3. Navigate to the root directory of the project.

4. Compile the .java files using the Java compiler (javac):
Copy code:
javac Trie.java TrieNode.java AutocompleteSystem.java

5. Run the application with Java

**Usage:**

Once the application is running:

1. Enter a prefix to get autocomplete suggestions.

2. The application will display a list of words that start with the provided prefix.

3. To quit the application, type 'exit'.