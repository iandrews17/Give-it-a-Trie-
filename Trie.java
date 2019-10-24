import java.lang.*;
import java.util.*;
import java.io.*;

class TrieNode {
  public TrieNode[] children;
  public char letter;
  public boolean isWord;

  public TrieNode(char letter) {
    this.letter = letter;
    children = new TrieNode[26];
    this.isWord = false;
  }
}

public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode(' ');
  }

  public void createTrie() {
    try {
      Scanner scan = new Scanner(new File("Scrabble.txt"));
      while (scan.hasNext()) {
        String word = scan.next();
        this.insert(word);
      }
      scan.close();
    }

    catch (Exception exc) {
      System.out.println("The file could not be found or could not be opened");
    }
  }

  // Inserts a word into the Trie. If the path does not currently exist we create
  // the
  // path (new nodes).
  public void insert(String word) {
    TrieNode current = root;
    int length = word.length();
    char letter;
    for (int i = 0; i < length; i++) {
      letter = word.charAt(i);
      int index = (int) letter - 'A';
      if (current.children[index] == null) {
        current.children[index] = new TrieNode(letter);
      }

      current = current.children[index];
    }

    current.isWord = true;
  }

  public void printTrie() {
    printTrie(root, "");
  }

  private void printTrie(TrieNode node, String word) {
    if (node == null) {
      return;
    }

    word += node.letter;
    if (node.isWord) {
      System.out.println(word);
    }

    for (int i = 0; i < 26; i++) {
      if (node.children[i] != null) {
        printTrie(node.children[i], word);
      }
    }
  }

  public void checkForScores(String start, String rack) {
    String buildWord = "";
    String bestWord = start;
    StringBuilder builder = new StringBuilder(rack);
    TrieNode starting = startsWith(start);
    if (starting == null) {
      System.out.println("No words that begin with " + start + " were found");
    } else {
      bestWord = checkForScores(builder, buildWord, bestWord, starting);
      System.out.println("Your best word is " + bestWord + " for " + addLettersTogether(bestWord) + " points");
    }
  }

  private TrieNode startsWith(String start) {
    TrieNode current = root;
    int length = start.length();
    for (int i = 0; i < length; i++) {
      if (current.children[start.charAt(i) - 'A'] != null) {
        current = current.children[start.charAt(i) - 'A'];
      } else {
        return null;
      }
    }

    return current;
  }

  private String checkForScores(StringBuilder rack, String buildWord, String bestWord,
      TrieNode currentNode) {
    if (currentNode == null) {
      return "";
    }
    if (currentNode.letter != ' ') {
      buildWord += currentNode.letter;
    }

    if (currentNode.isWord) {

      String tempWord = buildWord;
      // System.out.println();
      // System.out.println("Best word is: " + bestWord);
      // System.out.println("Temp word is: " + tempWord);
      // System.out.println(currentNode.letter);
      // System.out.println(rack);
      bestWord = (addLettersTogether(tempWord) > addLettersTogether(bestWord) ? tempWord : bestWord);

    }
    if (rack.length() == 0) {
      return bestWord;
    }
    for (int i = 0; i < currentNode.children.length; i++) {
      if (currentNode.children[i] != null) {
        int index = rack.toString().indexOf((char) ('A' + i));
        if (index > -1) {
          String tempWord = checkForScores(rack.deleteCharAt(index), buildWord, bestWord,
              currentNode.children[i]);
          bestWord = (addLettersTogether(tempWord) > addLettersTogether(bestWord) ? tempWord : bestWord);
          rack.append((char) ('A' + i));
        }
      }
    }

    return bestWord;
  }

  public int addLettersTogether(StringBuilder word) {
    int[] points = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
    int length = word.length();
    int total = 0;

    for (int i = 0; i < length; i++) {
      total += points[word.charAt(i) - 'A'];
    }

    return total;
  }

  public int addLettersTogether(String word) {
    int[] points = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
    int length = word.length();
    int total = 0;

    for (int i = 0; i < length; i++) {
      total += points[word.charAt(i) - 'A'];
    }

    return total;
  }

}
