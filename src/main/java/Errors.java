import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Errors {
    private List<String> lines = new ArrayList<>();


    public Errors(List lines){
        this.lines = lines;
    }

    public void emptyColumnError(){
        for (String line : this.lines)
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(0) == ';')
                    writeLog("Maleformed input @ line: [" + line + "] --ignoring line\n");
                if (line.charAt(j) == ';' && line.charAt(j + 1) == ';')
                    writeLog("Maleformed input @ line: [" + line + "] --ignoring line\n");
            }
    }

    public void firstColumnsError(Integer column, String line){

        List<String> firstThreeColumns = new ArrayList<>();
        firstThreeColumns.add("DW");
        firstThreeColumns.add("LW");
        firstThreeColumns.add("WW");
        try {
            Integer validValue = Integer.valueOf(";");
        }catch (NumberFormatException e){
            writeLog("Number parsing error for " + firstThreeColumns.get(column) + " @ line: [" +
                    line + "] -- ignoring\n" +  e.toString()+ "\n");
        }

    }

    public void ratingError(String line){
        try {
            Integer validValue = Integer.valueOf(";");
        }catch (NumberFormatException e){
            writeLog("Parse exception for Bewertung @line : " + " @ line: [" + line + "] -- ignoring\n" +  e.toString());
        }

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
}
