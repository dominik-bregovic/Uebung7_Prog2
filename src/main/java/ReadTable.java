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

    Integer countLine = 1;
    Errors errors = new Errors(categories);


    /**
     * initializing a 2D-list
     * filling the lines into the 2D-list (List of Arraylists)
     * writting into logfile if an error occurs
     * @param filePath is the given filepath to our .csv (received from main-class Application)
     */
    public ReadTable(String filePath){
        fillCategoriesInList();
        scanList(filePath);
        writeLogs();
    }

    /**
     * filling all categories in
     */
    public void fillCategoriesInList(){
        categories.add(dw);
        categories.add(lw);
        categories.add(ww);
        categories.add(titel);
        categories.add(interpret);
        categories.add(bewertung);
    }


    /**
     * scaning the .csv line by line with a BufferedReader, all the errors are getting checked right here
     * @param filePath the filepath to our .csv (received from main-class Application)
     */
    public void scanList(String filePath){
        String lines = "";

        try {
            br = new BufferedReader(new FileReader(filePath));
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

    /**
     * writing all collected occurrences into the logfile
     */
    public void writeLogs(){
        errors.writeLog(errors.emptyColumnLog);
        errors.writeLog(errors.firstColumnsLog);
        errors.writeLog(errors.ratingErrorLog);
    }

    /**
     * looking for anomalies and errors in the .csv
     * @param lines from the readLine-while loop in scan()
     * @param ignoreFirstLine ignoring the categories from the first Line from the .csv
     */
    public void checkingLines(String lines, Integer ignoreFirstLine){
        lines += ";";
        if (ignoreFirstLine != 1) {
            checkIfEmpty(lines);
            firstColumnsCheck(lines);
            ratingCheck(lines);
        }
    }

    /**
     * if no parameter then errors.emptyColumnError
     * forcing and error if one "field" is empty
     * @param line from the readLine-while loop in scan()
     */
    public void checkIfEmpty(String line){
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

    /**
     * checking the first three columns
     * forcing an error if value is not an Integer
     * giving the column with the anomaly to the errors.firstColumnsError
     * @param line from the readLine-while loop in scan()
     */
    public void firstColumnsCheck(String line) {
        String[] values = line.trim().split(";");
        Integer number = null;
        Integer column = null;
        try {
            for (int i = 0; i < 3; i++) {
                column = i;
                number = Integer.parseInt(values[i]);
            }
        }catch (NumberFormatException e){
            errors.firstColumnsError( column,line, e);
        }

    }

    /**
     * checking if there is a rating in the line
     * forcing a error if empty value
     * @param line from the readLine-while loop in scan()
     */
    public void ratingCheck(String line){
        String[] values = line.split(";");
        Double rating;

        if (line.charAt(values.length) == ';' && line.charAt(values.length-1) == ';') {
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

    /**
     * adding the lines into the individual categories
     * @param line from the readLine-while loop in scan()
     */
    public void initializeTable(String line){
        line += ";";
        String[] values = line.trim().split(";");

        if (values.length == 6 && this.countLine != 1 && ignoreLine(values)){
            dw.add(values[0]);
            lw.add(values[1]);
            ww.add(values[2]);
            titel.add(values[3]);
            interpret.add(values[4]);
            bewertung.add(values[5]);
        }
    }

    /**
     * if the .csv gives us an empty value then we can prevent the line being passed into our new list
     * we are only considering empty fields (""), not spaces or not valid characters
     * @param values includes all values from the scanned line splited into an String[]
     * @return gives a boolean back the shows us if there is an empty value in the line
     */
    public boolean ignoreLine(String[] values){
        boolean hasValue = true;

        for (int i = 0; i < 3; i++) {
            if (values[i].equals(""))
                hasValue = false;
        }
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(""))
                hasValue = false;
        }
        return hasValue;
    }

    public List<ArrayList<String>> getCategories() {
        return categories;
    }


}
