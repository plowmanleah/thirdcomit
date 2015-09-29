import java.io.*;
import java.util.*;
 *
 * @author plowmanleah
 */
public class pw_check_main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        pw_checkNode tn = new pw_checkNode();
        
        File file = new File("dictionary.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNext())
        {
            String word = scan.next();
            tn.addWord(word);
        }
        
        //String test = "that";
        String filename = "my_dictionary.txt";
         File inputFile = new File(filename);
        PrintWriter pwriter = new PrintWriter(new FileWriter(filename,true));
        Scanner in = new Scanner(System.in);
        String passWord = in.next();
        String pwStart = "-g";
        String wait;
        if(passWord.contains(pwStart)){
            wait = in.next();
            tn.testPw(wait);
            pwriter.print(wait);
            pwriter.close();
        }
        
        
        
    }
    
}
