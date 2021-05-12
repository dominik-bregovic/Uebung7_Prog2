import java.io.*;
import java.util.*;

public class AnalyzeFile {

    private String text = "";
    private BufferedReader br;
    private List<String> lines = new ArrayList<>();
    private List<String> columnValue = new ArrayList<>();
    private List<Integer> column = new ArrayList<>();
    private List<String> words = new ArrayList<>();
    private Errors error = new Errors(lines);

    public AnalyzeFile(){
        scanList();
        checkList(3);
        checkRating();
    }

    public void checkList(int columns){
//        this.error.emptyColumnError();
        columnValues(columns);
        checkColumnValues();
    }

    public void scanList(){
        try {
            br = new BufferedReader(new FileReader("src/main/resources/music2021.csv"));
            String lines;
            while ((lines = br.readLine()) != null){
                this.lines.add(lines);
                this.text += lines+";";

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
        formatTextToList();
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
             //   this.error.firstColumnsError(this.column.get(i), this.lines.get(i/3));
            }
        }
    }

    public void formatTextToList(){
        String[] words = text.split(";");
        this.words = Arrays.asList(words);
    }

    public void cleanList(){

        for (int i = 0; i < this.words.size(); i++) {
            if (this.words.get(i).equals("")){
                this.words.remove(i);
            }
        }
    }

    public void checkRating(){

        for (int i = 11; i < this.words.size(); i += 6) {
            if (this.words.get(i).equals("")){
                this.error.ratingError(this.lines.get((i+1)/6-1));
            }
        }
    }


    public List<String> getLines() {
        return lines;
    }

    public List<String> getWords() {
        return words;
    }


}
