import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Errors {

    private List<ArrayList<String>> lines;
    String emptyColumnLog = "";
    String firstColumnsLog = "";
    String ratingErrorLog = "";


    public Errors(List lines){
        this.lines = lines;
    }

    public void emptyColumnError(String line){
        this.emptyColumnLog += "Maleformed input @ line: [" + line + "] --ignoring line\n";
    }

    public void firstColumnsError(Integer column, String line, Exception e){

        List<String> firstThreeColumns = new ArrayList<>();
        firstThreeColumns.add("DW");
        firstThreeColumns.add("LW");
        firstThreeColumns.add("WW");
            this.firstColumnsLog += "Number parsing error for " + firstThreeColumns.get(column) + " @ line: [" +
                    line + "] -- ignoring\n" +  e.toString()+ "\n";


    }
/////////////have to give him a number
    public void ratingError(String line, Exception e){
            this.ratingErrorLog += "Parse exception for Bewertung @line : " + " @ line: [" + line + "] -- ignoring\n" +  e.toString();
    }

    public void writeLog(String log) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("logfile.txt", true));
            writer.write(log);
//            System.out.println("Should have written text");
        } catch (IOException e) {
            System.out.println("!!No content written into file!!");
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
