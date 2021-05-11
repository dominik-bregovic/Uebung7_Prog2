import java.io.*;
import java.util.*;

public class AnalyzeFile {
    private String textFile = "";
    private String text = "";
    private BufferedReader br;
    private List<String> lines = new ArrayList<>();
    private List<String> columnValue = new ArrayList<>();
    private List<Integer> column = new ArrayList<>();
    private Errors error = new Errors(lines);

    public AnalyzeFile(int columns){
        scanList();
        checkList(columns);
    }

    public void checkList(int columns){
        this.error.emptyColumn();
        checkAmountOfColumns(columns);

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

    public void checkAmountOfColumns(Integer amountOfColumns){
        columnValues(amountOfColumns);
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
                this.error.parsingError(this.column.get(i), this.lines.get(i/3));
            }
        }
    }

}
