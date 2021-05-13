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


    public ReadTable(){
        fillCategoriesInList();
        scanList();
        writeLogs();

        for (int i = 0; i < categories.size(); i++) {
            System.out.println(categories.get(i));
        }
        System.out.println(categories.get(4).get(1));
        System.out.println(errors.firstColumnsLog);
        System.out.println(errors.emptyColumnLog);
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
            br = new BufferedReader(new FileReader("src/main/resources/music2021.csv"));
            while ((lines = br.readLine()) != null){
                checkIfEmptyIntegration(lines);
                firstColumnsCheckIntegration(lines,countLine);
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
       // errors.writeLog(errors.ratingErrorLog);
    }


    public void checkIfEmptyIntegration(String line){
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

    public void firstColumnsCheckIntegration(String lines, Integer ignoreFirstLine){
        if (ignoreFirstLine != 1)
        firstColumnsCheck(lines += ";");
    }


    public void firstColumnsCheck(String line) {
        String[] values = line.trim().split(";");
        Integer number;
        try {
            for (int i = 0; i < 3; i++) {
                this.column = i;
                number = Integer.parseInt(values[i]);
            }
        }catch (IllegalArgumentException e){
            errors.firstColumnsError( this.column,line, e);
        }

    }

    public void initializeTable(String line){
        line += ";";
        String[] values = line.trim().split(";");
        dw.add(values[0]);
        lw.add(values[1]);
        ww.add(values[2]);
        titel.add(values[3]);
        interpret.add(values[4]);/////just spilt again
        bewertung.add(values[5]);
    }

//    public void trimValues(String[] values){
//        for (int i = 0; i < values.length; i++) {
//            for (int j = 0; j < values[i].length(); j++) {
//
//            }
//            if (values[i].charAt() ==) {
//            }
//        }
//    }
//public void separateInterprets(){
//    ArrayList<String> seperated = new ArrayList<>();
//    String[] seperatedInterpet;
//
//    for (int i = 10; i < analizedWords.size(); i += 6) {
//        seperatedInterpet = analizedWords.get(i).split(",");
//
//        for (int j = 0; j < seperatedInterpet.length; j++) {
//            seperated.add(seperatedInterpet[j].trim());
//        }
//    }
//    this.seperatedInterpret = seperated;
//}



}
