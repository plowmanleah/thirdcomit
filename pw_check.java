import java.io.*;
import java.util.*;
        

/**
 *
 * @author plowmanleah
 */
public class pw_check {

    /**
     * @param args the command line arguments
     */
    
        private Node root;
        private boolean isWord;
        
                
        private class Node
        {
            public int index;
            public Node child;
            public Node sibling;
            
            public Node(int index)
            {
                this.index = index;
                child = null;
                sibling = null;
            }
        }
        
        public pw_check(){
            this(false);
        }
    
        public pw_check(boolean isAWord)
        {
            root = new Node('r');
            this.isWord = isAWord;
        }
    
        public boolean addWord(String aWord){
            
            int i = aWord.length();
            
            addWord(root, aWord, i);
            return false;
        }
        private boolean addWord(Node root, String word, int off)
        {
            if(off == word.length())
            {
                return false;
            }
            int value = word.charAt(off);
            Node previous = null;
            Node next = root.child;
            while(next != null)
            {
                if(next.index < value)
                {
                    previous = next;
                    next = next.sibling;
                }
                else if(next.index == value)
                {
                    return addWord(next, word, off+1);
                }
                else
                {
                    break;
                }
                
            }
            Node subNode = new Node(value);
            if(previous == null)
            {
                root.child = subNode;
                subNode.sibling = next;
            }
            else
            {
                previous.sibling = subNode;
                subNode.sibling = next;
            }
            
            for(int i = off + 1; i < word.length(); i++)
            {
                subNode.child = new Node(word.charAt(i));
                subNode = subNode.child;
            }
            return true;
        
        }



   public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        pw_check pwcheck = new pw_check();
        
        File file = new File("dictionary.txt");
        Scanner scan = new Scanner(file);
        char[] width = new char[1000];
        while(scan.hasNext())
        {
            String word = scan.next();
            pwcheck.addWord(word);
            System.out.println(word.toString());
        }
}
}
        
         
    


