import java.util.*;

public class CreateTable {
    AnalyseTable analysed;
    List<ArrayList<String>> categories;
    List<String> interpretList;
    List<Integer> tracksPerInterpret;
    List<Musician> musicians = new ArrayList<>();
    LinkedHashMap<String, Integer> interpretTracks = new LinkedHashMap<>();

    public CreateTable(AnalyseTable alanyse){
        this.analysed = alanyse;
        getRessources();
        initializeMap();
        createMusicans();
        System.out.println(interpretTracks);
        Collections.sort(musicians);
        for (int i = 0; i < musicians.size(); i++) {
            System.out.println( musicians.get(i).ToString());
        }

    }

    public void getRessources(){
        this.categories = this.analysed.getCategories();
        this. interpretList = this.analysed.getUniqueInterpretList();
        this.tracksPerInterpret = this.analysed.getCountUniqueInterpretInList();
    }

    public void initializeMap(){
        for (int i = 0; i < interpretList.size(); i++) {
            this.interpretTracks.put(this.interpretList.get(i), this.tracksPerInterpret.get(i));
        }
    }

    public void createMusicans(){
        for (int i = 0; i < this.interpretList.size(); i++) {
            this.musicians.add(new Musician(this.interpretList.get(i), this.tracksPerInterpret.get(i)));
        }
    }

}
