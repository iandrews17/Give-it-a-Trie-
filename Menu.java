import java.io.*;
import java.util.*;

public class Menu extends Trie {

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.createTrie();
    Scanner scan = new Scanner(System.in);
    System.out.println("What letter(s) are in your rack? (separate with spaces)");

    String rack = scan.nextLine();
    rack.trim();
    System.out.println("What letter(s) will your word start with? (not separated with spaces)");
    String start = scan.nextLine();
    trie.checkForScores(start, rack);

    scan.close();
  }
}
