import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadTable {
    BufferedReader br;
    List<ArrayList<String>> categories = new ArrayList<>();
    ArrayList<String> dw = new ArrayList<>();
    ArrayList<String> lw = new ArrayList<>();
    ArrayList<String> ww = new ArrayList<>();
    ArrayList<String> titel = new ArrayList<>();
    ArrayList<String> interpret = new ArrayList<>();
    ArrayList<String> bewertung = new ArrayList<>();
    Integer column;
    Errors errors = new Errors(categories);
    String filePath;


    public ReadTable(String filePath){
        this.filePath = filePath;
        fillCategoriesInList();
        scanList();
       // writeLogs();
    }

    public void fillCategoriesInList(){
        categories.add(dw);
        categories.add(lw);
        categories.add(ww);
        categories.add(titel);
        categories.add(interpret);
        categories.add(bewertung);
    }


    public void scanList(){
        String lines = "";
        Integer countLine = 1;
        try {
            br = new BufferedReader(new FileReader(this.filePath));
            while ((lines = br.readLine()) != null){
                checkingLines(lines, countLine);
                initializeTable(lines);
                countLine++;
            }
        }catch (IOException e){

        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeLogs(){
        errors.writeLog(errors.emptyColumnLog);
        errors.writeLog(errors.firstColumnsLog);
        errors.writeLog(errors.ratingErrorLog);
    }

    public void checkingLines(String lines, Integer ignoreFirstLine){
        if (ignoreFirstLine != 1) {
            checkIfEmpty(lines);
            firstColumnsCheck(lines += ";");
            ratingCheck(lines);
        }
    }

    public void checkIfEmpty(String line){
        line += ";";
        String err = null;
        try {
            for (int i = 1; i < line.length(); i++) {
                if (line.charAt(0) == ';') {
                    err.charAt(0);
                }
                if (line.charAt(i-1) == ';' && line.charAt(i) == ';') {
                    err.charAt(0);
                }
            }
        }catch (NullPointerException e){
            errors.emptyColumnError(line);
        }
    }

    public void firstColumnsCheck(String line) {
        String[] values = line.trim().split(";");
        Integer number;
        try {
            for (int i = 0; i < 3; i++) {
                this.column = i;
                number = Integer.parseInt(values[i]);
            }
        }catch (NumberFormatException e){
            errors.firstColumnsError( this.column,line, e);
        }

    }

    public void ratingCheck(String line){
        String[] values = line.split(";");
        Double rating;


        if (line.charAt(values.length-1) == ';' && line.charAt(values.length-2) == ';') {
            try {
                rating = Double.parseDouble(";");
            }catch (NumberFormatException e){
                errors.ratingError(line, e);
            }

        }else {
            try {
                rating = Double.parseDouble(values[values.length-1].replaceAll(",", "."));
            }catch (NumberFormatException e){
                errors.ratingError(line, e);
            }
        }
    }

    public void initializeTable(String line){
        line += ";";
        String[] values = line.trim().split(";");
        if (values.length-1 == 5){
            dw.add(values[0]);
            lw.add(values[1]);
            ww.add(values[2]);
            titel.add(values[3]);
            interpret.add(values[4]);/////just spilt again
            bewertung.add(values[5]);
        }
    }


    public List<ArrayList<String>> getCategories() {
        return categories;
    }


}
