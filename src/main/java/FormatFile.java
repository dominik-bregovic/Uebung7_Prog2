import java.util.*;

public class FormatFile implements Comparable<FormatFile>{

    private List<String> analizedWords;
    private List<String> seperatedInterpret;
    private List<String> countedInterprets = new ArrayList<>();

    public FormatFile(List wordList){
        this.analizedWords = wordList;
        formating();
        printList(countedInterprets);
    }

    public void formating(){
        separateInterprets();
        wordCounter();
        countedInterprets = sortingListToUniqueElements(countedInterprets);
    }


    public void separateInterprets(){
        List<String> seperated = new ArrayList<>();
        String[] seperatedInterpet;

        for (int i = 10; i < analizedWords.size(); i += 6) {
            seperatedInterpet = analizedWords.get(i).split(",");

            for (int j = 0; j < seperatedInterpet.length; j++) {
                seperated.add(seperatedInterpet[j].trim());
            }
        }
        this.seperatedInterpret = seperated;
    }

    public List<String> sortingListToUniqueElements(List toSort){
        HashSet<String> Set = new HashSet<>();
        Set.addAll(toSort);
        List<String> uniqueElements = new ArrayList<>(Set);
        Collections.sort(uniqueElements);
        return uniqueElements;
    }


    public void wordCounter(){
        Integer count = 0;

        for (int i = 0; i < seperatedInterpret.size(); i++) {
            count = Collections.frequency(seperatedInterpret, seperatedInterpret.get(i));
            this.countedInterprets.add(String.valueOf(seperatedInterpret.get(i))+":"+count);
        }
    }


//    public void searchForInterpret(){
//        for (int i = 10; i < analizedWords.size(); i += 6) {
//            seperatedInterpret.add(analizedWords.get(i));
//        }
//    }



    public void printList(List toPrint){
        System.out.println(toPrint);
    }

    @Override
    public int compareTo(FormatFile file) {
        return 0;
    }


    public List<String> getCountedInterprets() {
        return countedInterprets;
    }

}
