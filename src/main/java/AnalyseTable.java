import java.util.*;

public class AnalyseTable {
    ReadTable table;
    List<ArrayList<String>> categories;
    List<String> separatedInterpret = new ArrayList<>();
    List<String> uniqueInterpretList;
    List<Integer> countTrackToInterpret = new ArrayList<>();


    public AnalyseTable(ReadTable readtable){
        this.table = readtable;
        this.categories = this.table.getCategories();
        generateSeperateInterpretList();
        uniqueInterpretList = sortingListToUniqueElements(separatedInterpret);
        countTrackToInterperts();

    }


    /**
     * sorting all interprets to an individual index into the separatedInterpret-list
     */
    public void generateSeperateInterpretList(){
        String[] seperatedInterpet;

        for (int i = 0; i < categories.get(4).size(); i++) {
            seperatedInterpet = categories.get(4).get(i).split(",");

            for (int j = 0; j < seperatedInterpet.length; j++) {
                this.separatedInterpret.add(seperatedInterpet[j].trim());
            }
        }

    }

    /**
     * converting a list into a set in order to get unique elements
     * @param toSort the list to sort
     * @return       the list with unique elements
     */
    public List<String> sortingListToUniqueElements(List toSort){
        HashSet<String> Set = new HashSet<>();
        Set.addAll(toSort);
        List<String> uniqueElements = new ArrayList<>(Set);
        return uniqueElements;
    }

    /**
     * counting how often the individual interpret appeared in the music2021.csv
     * creating a relation between the indexes of the appearances and the interpret
     */
    public void countTrackToInterperts(){
        Integer counter = 0;
        for (int i = 0; i < uniqueInterpretList.size(); i++) {
            for (int j = 0; j < separatedInterpret.size(); j++) {
                if (uniqueInterpretList.get(i).contains(separatedInterpret.get(j))) {
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
