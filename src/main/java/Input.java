import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Input {
    String textFile;
    BufferedReader br;

    public void scanText(){
        try {
            br = new BufferedReader(new FileReader(textFile));
            String lines;
            while ((lines = br.readLine()) != null){
                this.textFile += lines+"\n";
            }
        }catch (IOException e){

        }
    }
}
