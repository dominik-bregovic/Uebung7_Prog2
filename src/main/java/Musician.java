import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Musician implements Comparable<Musician>{

    private String name;
    private Integer amountOfTracks;
    private HashMap<String, String> InterpretTracks = new HashMap<>();
    private HashMap<String, String> InterpretRating = new HashMap<>();

    public Musician(String name, Integer amountOfTracks){
        this.name = name;
        this.amountOfTracks = amountOfTracks;
      //  this.InterpretTracks.put(name, track);
       // this.InterpretRating.put(name, rating);

    }

    public String ToString(){
        return name+":"+ amountOfTracks;
    }

    @Override
    public int compareTo(Musician o) {
        return o.amountOfTracks.compareTo(this.amountOfTracks);
    }
}
