import java.lang.*;
import java.util.*;
import java.io.*;

class TrieNode
{
  public TrieNode [] children;
  public char letter;
  public boolean isWord;

  public TrieNode(char letter)
  {
    this.letter = letter;
    children = new TrieNode[26];
  }
}

public class Trie
{
  private TrieNode root;

  public Trie()
  {
    root = new TrieNode(' ');
  }

  public void createTrie()
  {
    try
    {
      Scanner scan = new Scanner(new File("Scrabble.txt"));
      while(scan.hasNext())
      {
        String word = scan.next();
        this.insert(word);
      }
    }

    catch(Exception exc)
    {
      System.out.println("No idea");
    }
  }

  // Inserts a word into the Trie. If the path does not currently exist we create the
  // path (new nodes).
  public void insert(String word)
  {
    TrieNode current = root;
    int length = word.length();
    char letter;
    for (int i = 0; i < length; i++)
    {
      letter = word.charAt(i);
      int index = (int) letter - 'A';
      if (current.children[index] == null)
      {
        current.children[index] = new TrieNode(letter);
      }

      current = current.children[index];
    }

    current.isWord = true;
  }

  public void printTrie()
  {
    printTrie(root, "");
  }

  private void printTrie(TrieNode node, String word)
  {
    if (node == null)
    {
      return;
    }

    word += node.letter;
    if (node.isWord)
    {
      System.out.println(word);
    }

    for (int i = 0; i < 26; i++)
    {
      if (node.children[i] != null)
      {
        printTrie(node.children[i], word);
      }
    }
  }

  public void checkForScores(String word,char [] deck, int maxLength, int currentLength)
  {
    String bestWord = "";
    boolean [] used = new boolean [deck.length];
    StringBuilder builder = new StringBuilder(word);
    String bestWord = checkForScores(builder, deck, used, maxLength, currentLength, root, bestWord);
  }

  private String checkForScores(StringBuilder word, char [] deck, boolean [] used, int maxLength, int currentLength, TrieNode node, String bestWord)
  {

    if (currentLength == maxLength && node.isWord)
    {
      word.append(node.letter);
      String newWord = word.toString();
      if (addLettersTogether(newWord) > addLettersTogether(bestWord))
      {
        bestWord = newWord;
      }

      return bestWord;
    }

    for (int i = 0; i < 26; i++)
    {
      if (node.children[i] != null)
      {
        for (int j = 0; j < deck.length; j++)
        {
          if (deck[j] ==(char) i + 'A' && used[j] == false)
          {
            used[j] = true;
            if (node != root)
            {
              word.append(node.letter);
            }
            bestWord = checkForScores(word, deck, used, maxLength, currentLength, node.children[i], bestWord);
            used[j] = false;
          }
        }
      }
    }

    return bestWord;
  }

}
