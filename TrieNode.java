public class Trienode
{
  private HashMap<Character, TrieNode> children;
  private Character letter;
  private boolean isWord;

  public Trienode(Character letter)
  {
    this.letter = letter;
    children = new HashMap<>();
  }
}

public class Trie
{
  private Trienode root;

  public Trie()
  {
    root = new TrieNode(null);
  }

  public void createTrie() throws Exception
  {
    Scanner scan = new Scanner(Collins Scrabble Words(2015).txt);
    while(scan.hasNext())
    {
      this.insert(scan.next());
    }
  }

  private void insert(String word)
  {
    TrieNode current = root;
    int length = word.length();

    for (int i = 0; i < length; i++)
    {
        Character char = word.charAt(i).toLowerCase();

    }
  }
}
