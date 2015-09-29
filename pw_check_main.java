import java.util.*;
import java.io.*;
public class pw_check_main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        pw_check tn = new pw_check();
        
        File file = new File("dictionary.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNext())
        {
            String word = scan.next();
            tn.addWord(word);
        }
        
        //String test = "that";
        
        Scanner in = new Scanner(System.in);
        String passWord = in.next();
        String pwStart = "-g";
        if(passWord.contains(pwStart)){
            String wait = in.next();
            tn.testPw(wait);
        }
        
    }
    
}
