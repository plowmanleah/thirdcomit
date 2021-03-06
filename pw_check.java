import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.lang.*;
        
/**
 *
 * @author plowmanleah
 */
public class pw_checkNode
{

    private TrieNode root;
    
    public pw_checkNode() {
        root = new TrieNode();
    }
 
    public void addWord(String word)
    {
        HashMap<Character, TrieNode> child = root.child;
        if(word.length() > 5)
        {
            return;
        }
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
        int countWord = 0;
        for(int i = 0; i < word.length(); i++)
        {
            
            char subChar = word.charAt(i);
            if(child.containsKey(subChar))
            {
                trieNode = child.get(subChar);
                child = trieNode.child;
                countWord++;
                
            }
            
            else
            {
                checkForSymbol(word);
                return null;
            }
        }
        if(countWord > 0){
            System.out.println("Unusable word");
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
    
    public boolean testPw(String word)
    {
        if(word.length() > 5)
        {
            System.out.println("Password choice is too long.");
            return false;
        }
        char character;
        int countInt = 0;
        int countLetter = 0;
        for(int i = 0; i < word.length(); i++)
        {
            character = word.charAt(i);
            if(Character.isLetter(character))
            {
                findbegLetter(word);
                countLetter++;
                return true;
            }
            if(Character.isDigit(character))
            {
                countInt++;
            }
        }
        if(countInt == 0 || countInt > 2)
        {
            System.out.println("Your password must contain 1-2 numbers");
        }
        if(countLetter > 0 && countLetter < 3){
            
        }
        
        
        return false;
    }
    
    public int checkForSymbol(String word)
    {
        if(word == null)
        {
            return 0;
        }
        int counter = 0;
        String symbols = "!@$%&*";
        char[] charWord = word.toCharArray();
        for(int i = 0; i <charWord.length; i++)
        {
            if(symbols.indexOf(String.valueOf(i)) >= 0)
            {
                counter++;
            }
            
        }
        if(counter == 0)
        {
            System.out.println("Must contain special characer (!,@,$,%,&,*)");
        }
        if(counter >2)
        {
            System.out.println("Your password contains too many special characters");
        }
        return counter;
    }
    
    private class TrieNode
    {
        
    
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
