import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Musician implements Comparable<Musician>{
    private static int countMusicians= 0;
    private int nr;
    private String name;
    private Integer amountOfTracks;
    private List<ArrayList<String>> ratings;
    private HashMap<String, String> trackInterprets = new HashMap<>();
    private HashMap<String, String> InterpretRating = new HashMap<>();

    public Musician(String name, Integer amountOfTracks, List ratingsPerInterpret){
        this.name = name;
        this.amountOfTracks = amountOfTracks;;
        this.ratings = ratingsPerInterpret;
        this.nr = countMusicians++;


    }

    public String ToString(){
        return nr +": "+name+": "+ amountOfTracks+": "+ratings.get(nr) + " from musician";
    }



    @Override
    public int compareTo(Musician o) {
        return o.amountOfTracks.compareTo(this.amountOfTracks);
    }
}
