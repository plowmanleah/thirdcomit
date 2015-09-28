import java.io.*;
import java.util.*;
        
import java.util.regex.Pattern;
import java.lang.*;
        
/**
 *
 * @author plowmanleah
 */
public class Trie
{

    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
 
    public void addWord(String word)
    {
        HashMap<Character, TrieNode> child = root.child;
        for(int i = 0; i < word.length(); i++)
        {
            char subChar = word.charAt(i);
            
            TrieNode trieNode;
            if(child.containsKey(subChar))
            {
                trieNode = child.get(subChar);
               
            }
            else
            {
                trieNode = new TrieNode(subChar);
                child.put(subChar, trieNode);
            }
            
            child = trieNode.child;
            if(i == word.length()-1)
            {
                trieNode.isWord = true;
            }
         
        }
           for(Map.Entry<Character, TrieNode> entry: child.entrySet())
        {
            char key = entry.getKey();
            TrieNode value = entry.getValue();
            System.out.println(value);
            System.out.println(key);
        }
        
    }
    public boolean searchTrie(String word)
    {
        TrieNode trieNode = searchNodes(word);
        if(trieNode != null && trieNode.isWord)
        {
            
            return true;
        }
        else
        {
            return false;
        }
    }
  
    public TrieNode searchNodes(String word)
    {
        Map<Character, TrieNode> child = root.child;
        TrieNode trieNode = null;
        for(int i = 0; i < word.length(); i++)
        {
            char subChar = word.charAt(i);
            if(child.containsKey(subChar))
            {
                trieNode = child.get(subChar);
                child = trieNode.child;
                
            }
            
            else
            {
                return null;
            }
        }
        return trieNode;
    }
 
    public boolean findbegLetter(String word)
    {
        if(searchNodes(word) == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


public class TrieNode {
    
    public char insertChar;
    HashMap<Character, TrieNode> child = new HashMap<Character, TrieNode>();
    boolean isWord;
    
    public TrieNode()
    {
        
    }
    public TrieNode(char insertChar)
    {
        this.insertChar = insertChar;
    }
    
}
}

public class pw_checkMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Trie tn = new Trie();
        
        File file = new File("dictionary.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNext())
        {
            String word = scan.next();
            tn.addWord(word);
        }
    }
}
