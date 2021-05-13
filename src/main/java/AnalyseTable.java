import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class AnalyseTable {
    ReadTable table;
    List<ArrayList<String>> categories;
    List<String> seperatedInterpret = new ArrayList<>();
    List<String> countedInterprets = new ArrayList<>();
    List<String> uniqueInterpretList;

    public AnalyseTable(ReadTable readtable){
        this.table = readtable;
        this.categories = this.table.getCategories();
        tracksPerInterpret();
        uniqueInterpretList = sortingListToUniqueElements(seperatedInterpret);

        for (int i = 0; i < seperatedInterpret.size(); i++) {
            System.out.print(seperatedInterpret.get(i));
        }
        for (int i = 0; i < countedInterprets.size(); i++) {
            System.out.print(countedInterprets.get(i));
        }
        for (int i = 0; i < uniqueInterpretList.size(); i++) {
            System.out.print(uniqueInterpretList.get(i));
        }
    }

    public void tracksPerInterpret (){
        String[] seperatedInterpet;

        for (int i = 0; i < categories.get(4).size(); i++) {
            seperatedInterpet = categories.get(4).get(i).split(",");

            for (int j = 0; j < seperatedInterpet.length; j++) {
                this.seperatedInterpret.add(seperatedInterpet[j].trim());
            }
        }
        wordCounter();
    }

///////////here we could try to compare a uniqueInterprets list with the seperatedInterprets list and could get two lists with
    ///////one list of interprets and one list with how many tracks
    public void wordCounter(){
        Integer count = 0;

        for (int i = 0; i < seperatedInterpret.size(); i++) {
            count = Collections.frequency(seperatedInterpret, seperatedInterpret.get(i));
            this.countedInterprets.add(String.valueOf(seperatedInterpret.get(i))+":"+count);
        }
    }

    public List<String> sortingListToUniqueElements(List toSort){
        HashSet<String> Set = new HashSet<>();
        Set.addAll(toSort);
        List<String> uniqueElements = new ArrayList<>(Set);
        Collections.sort(uniqueElements);
        return uniqueElements;
    }
}
