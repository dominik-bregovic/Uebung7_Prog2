import java.io.*;
import java.util.*;

public class AnalyzeFile {
    private String textFile = "";
    private String text = "";
    private BufferedReader br;
    private List<String> lines = new ArrayList<>();
    private List<String> columnValue = new ArrayList<>();
    private List<Integer> column = new ArrayList<>();

    public void checkList(){
        checkColumns();
        checkAmountOfColumns(3);


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
                this.lines.add(lines);
            }
        }catch (IOException e){
            System.err.println("scan error");
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
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(0) == ';')
                    writeLog("Maleformed input @ line: " + line + " --ignoring line\n");
                if (line.charAt(j) == ';' && line.charAt(j + 1) == ';')
                    writeLog("Maleformed input @ line: " + line + " --ignoring line\n");
            }
    }

    public void checkAmountOfColumns(Integer amountOfColumns){
        columnValues(amountOfColumns);
        System.out.println(columnValue);
        checkColumnValues();
    }

    public void columnValues(Integer amountOfColumns){
        Integer countColumn = 0;
        String value = "";

        for (int i = 0; i < this.lines.size();i++) {
            for (int j = 0; j < this.lines.get(i).length(); j++) {

                if (countColumn < amountOfColumns) {

                    if (lines.get(i).charAt(j) != ';') {
                        value += lines.get(i).charAt(j);
                    } else {
                        this.columnValue.add(value);
                        this.column.add(countColumn);
                        countColumn++;
                        value = "";
                    }

                }else {
                    countColumn = 0;
                    break;
                }

            }
        }
    }

    public void checkColumnValues(){
        for (int i = 0; i < this.columnValue.size(); i++) {
            if (this.columnValue.get(i).equals("")) {
                parsingError(this.column.get(i), this.lines.get(i/3));
            }
        }
    }


    public void parsingError(Integer column, String line){

        List<String> firstThreeColumns = new ArrayList<>();
        firstThreeColumns.add("DW");
        firstThreeColumns.add("LW");
        firstThreeColumns.add("WW");
        try {
            Integer validValue = Integer.valueOf(";");
        }catch (NumberFormatException e){
            writeLog("Number parsing error for " + firstThreeColumns.get(column) + " @ line: " +
                    line + e.getMessage() + "\n");
        }

    }

    public String getTextFile() {
        return textFile;
    }

    public List<String> getLines() {
        return lines;
    }

}
