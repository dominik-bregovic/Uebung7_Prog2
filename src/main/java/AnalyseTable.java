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
    List<Integer> countUniqueInterpretInList = new ArrayList<>();

    public AnalyseTable(ReadTable readtable){
        this.table = readtable;
        this.categories = this.table.getCategories();
        generateSeperateInterpretList();
        uniqueInterpretList = sortingListToUniqueElements(seperatedInterpret);
        countUniques();

    }

    public void generateSeperateInterpretList(){
        String[] seperatedInterpet;

        for (int i = 0; i < categories.get(4).size(); i++) {
            seperatedInterpet = categories.get(4).get(i).split(",");

            for (int j = 0; j < seperatedInterpet.length; j++) {
                this.seperatedInterpret.add(seperatedInterpet[j].trim());
            }
        }
        //wordCounter();
    }

    public List<String> sortingListToUniqueElements(List toSort){
        HashSet<String> Set = new HashSet<>();
        Set.addAll(toSort);
        List<String> uniqueElements = new ArrayList<>(Set);
        Collections.sort(uniqueElements);
        return uniqueElements;
    }

    public void countUniques(){
        Integer counter = 0;
        for (int i = 0; i < uniqueInterpretList.size(); i++) {
            for (int j = 0; j < seperatedInterpret.size(); j++) {
                if (uniqueInterpretList.get(i).contains(seperatedInterpret.get(j))) {
                    counter++;
                }
            }
            countUniqueInterpretInList.add(counter);
            counter = 0;
        }
    }

    public void wordCounter(){
        Integer count = 0;

        for (int i = 0; i < seperatedInterpret.size(); i++) {
            count = Collections.frequency(seperatedInterpret, seperatedInterpret.get(i));
            this.countedInterprets.add(seperatedInterpret.get(i)+":"+count);
        }
    }


    public List<ArrayList<String>> getCategories() {
        return categories;
    }

    public List<String> getUniqueInterpretList() {
        return uniqueInterpretList;
    }

    public List<Integer> getCountUniqueInterpretInList() {
        return countUniqueInterpretInList;
    }
}
