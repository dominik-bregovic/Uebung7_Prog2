import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private String textFile = "";
    private String text = "";
    private BufferedReader br;
    private List<String> lines = new ArrayList<>();

    public int checkList(){

        return 0;

    }

    public void writeLog(String log){
        try{
            FileWriter fw = new FileWriter("logfile.txt",true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(log);
//            System.out.println("Should have written text");
            writer.close();
        }catch(IOException e){
            System.out.println("!!No content written into file!!");
        }
    }


    public void scanList(){
        try {
            br = new BufferedReader(new FileReader("music2021.csv"));
            String lines;
            while ((lines = br.readLine()) != null){
                this.lines.add(lines+"\n");
            }
        }catch (IOException e){
            System.err.println("scann error");
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkColumns(){
        for (String line : this.lines)
            for (int j = 0; j < line.length(); j++)
                if (line.charAt(j) == ';' && line.charAt(j + 1) == ';')
                    writeLog("Maleformed input @ line: " + line + " --ignoring line");

    }


    public String getTextFile() {
        return textFile;
    }

    public List<String> getLines() {
        return lines;
    }

}
