import java.util.*;

public class FormatFile {

    private List<String> analizedWords;
    private List<String> seperatedInterpret;
    //private List<String> uniqueInterprets = new ArrayList<>();
    private List<String> countedInterprets = new ArrayList<>();

    public FormatFile(List wordList){
        this.analizedWords = wordList;
        formating();
   ///////////////////////
        printList(sortingListToUniqueElements(seperatedInterpret));
        printList(countedInterprets);


    }

    public void formating(){
        seperatedInterpret = separateInterprets();
        /////////////////
        wordCounter(sortingListToUniqueElements(seperatedInterpret));
    }


    public void searchForInterpret(){
        for (int i = 10; i < analizedWords.size(); i += 6) {
            seperatedInterpret.add(analizedWords.get(i));
        }
    }

    public List<String> separateInterprets(){
        List<String> seperated = new ArrayList<>();
        String[] seperatedInterpet;

        for (int i = 10; i < analizedWords.size(); i += 6) {
            seperatedInterpet = analizedWords.get(i).split(",");

            for (int j = 0; j < seperatedInterpet.length; j++) {
                seperated.add(seperatedInterpet[j]);
            }
        }
        return seperated;
    }

    public List<String> sortingListToUniqueElements(List toSort){
        HashSet<String> Set = new HashSet<>();
        Set.addAll(toSort);
        List<String> uniqueElements = new ArrayList<>(Set);
        Collections.sort(uniqueElements);
        return uniqueElements;
    }


    public void wordCounter(List values){
        Integer count = 0;

        for (int i = 0; i < values.size(); i++) {
            count = Collections.frequency(values, values.get(i));
            this.countedInterprets.add(String.valueOf(values.get(i)));
            this.countedInterprets.add(String.valueOf(count));
        }

    }



    public void printList(List toPrint){
        System.out.println(toPrint);
    }

}
