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
