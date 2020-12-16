import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StreamReader {
    public static void main(String[] args) throws IOException {
        //FileReader reads character by character
        FileReader fr = null;
        //BufferedReader reads line by line
        BufferedReader br = null;
        //Has toCapital method whuch converts to upperCase
        Capitalizer tc = new Capitalizer();
        try {
            //set file path
            fr = new FileReader("C:\\Users\\Isuri\\Desktop\\Sample.txt");
            //adds the FileReader to BufferedReader
            br = new BufferedReader(fr);
 
            String line;
            //while loop reads each line in br
            while ((line = br.readLine()) != null) {
                //sends the read string to toCapital method
                //returns a string with capitalized text
                System.out.println(tc.toCapital(line));
            }
            
        } finally {
            //closes the FileReader and BufferedReader
            fr.close();
            br.close();
        }
    }
}
