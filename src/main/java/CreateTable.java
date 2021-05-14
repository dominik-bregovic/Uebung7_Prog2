import java.util.*;

public class CreateTable {
    AnalyseTable analysed;
    List<ArrayList<String>> categories;
    List<String> interpretList;
    List<Integer> tracksPerInterpret;
    List<String> track;
    List<String> rating;
    List<Musician> musicians = new ArrayList<>();
    LinkedHashMap<String, String> trackInterprets = new LinkedHashMap<>();
    LinkedHashMap<String, String> trackRating = new LinkedHashMap<>();

    public CreateTable(AnalyseTable alanyse){
        this.analysed = alanyse;
        getRessources();
        createMusicans();
        Collections.sort(musicians);
        for (int i = 0; i < musicians.size(); i++) {
            System.out.println( musicians.get(i).ToString());
        }

    }

    public void getRessources(){
        this.categories = this.analysed.getCategories();
        this. interpretList = this.analysed.getUniqueInterpretList();
        this.tracksPerInterpret = this.analysed.getCountTrackToInterpret();
        this.track = this.categories.get(3);
        this.rating = this.categories.get(5);

    }


    public void createMusicans(){
        for (int i = 0; i < this.interpretList.size(); i++) {
            this.musicians.add(new Musician(this.interpretList.get(i), this.tracksPerInterpret.get(i)));
        }
    }

    //trying to connect relationships////////////////////////
    public void gerateHashMaps(String line){
        for (int i = 1; i < track.size(); i++) {
            trackInterprets.put(track.get(i), rating.get(i)); ///track to Interprets
            trackRating.put(track.get(i), categories.get(4).get(i));///track to Ratings
        }
    }

}
