import java.util.*;

public class AnalyseTable {
    ReadTable table;
    List<ArrayList<String>> categories;
    List<String> seperatedInterpret = new ArrayList<>();
    List<String> uniqueInterpretList;
    List<Integer> countTrackToInterpret = new ArrayList<>();


    public AnalyseTable(ReadTable readtable){
        this.table = readtable;
        this.categories = this.table.getCategories();
        generateSeperateInterpretList();
        uniqueInterpretList = sortingListToUniqueElements(seperatedInterpret);
        countTrackToInterperts();

    }

    public void generateSeperateInterpretList(){
        String[] seperatedInterpet;

        for (int i = 0; i < categories.get(4).size(); i++) {
            seperatedInterpet = categories.get(4).get(i).split(",");

            for (int j = 0; j < seperatedInterpet.length; j++) {
                this.seperatedInterpret.add(seperatedInterpet[j].trim());
            }
        }

    }

    public List<String> sortingListToUniqueElements(List toSort){
        HashSet<String> Set = new HashSet<>();
        Set.addAll(toSort);
        List<String> uniqueElements = new ArrayList<>(Set);
        Collections.sort(uniqueElements);
        return uniqueElements;
    }

    public void countTrackToInterperts(){
        Integer counter = 0;
        for (int i = 0; i < uniqueInterpretList.size(); i++) {
            for (int j = 0; j < seperatedInterpret.size(); j++) {
                if (uniqueInterpretList.get(i).contains(seperatedInterpret.get(j))) {
                    counter++;
                }
            }
            countTrackToInterpret.add(counter);
            counter = 0;
        }
    }

    public List<ArrayList<String>> getCategories() {
        return categories;
    }

    public List<String> getUniqueInterpretList() {
        return uniqueInterpretList;
    }

    public List<Integer> getCountTrackToInterpret() {
        return countTrackToInterpret;
    }
}
