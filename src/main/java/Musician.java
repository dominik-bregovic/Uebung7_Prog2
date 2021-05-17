import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Musician implements Comparable<Musician>{
    private static int countMusicians= 0;
    private int nr;
    private String name;
    private Integer amountOfTracks;
    private List<Double> average;
    private List<ArrayList<Double>> ratings;


    public Musician(String name, Integer amountOfTracks, List ratingsPerInterpret){
        this.name = name;
        this.amountOfTracks = amountOfTracks;
        this.ratings = ratingsPerInterpret;
        this.nr = countMusicians++;
        averageRatings();
        formatRatings();
    }

    public String ToString(){

        return this.name+";"+ this.amountOfTracks + ";"  + averageRatings()+ ";" + formatRatings();
    }


    public String averageRatings(){
        double avg = 0;
        for (int i = 0; i < this.ratings.get(this.nr).size(); i++) {
            avg += this.ratings.get(this.nr).get(i);
        }
        return String.format("%.2f", (avg/amountOfTracks));
    }

    public String formatRatings(){
        String ratings = "";
        for (int i = 0; i < this.ratings.get(this.nr).size(); i++) {
            if (this.ratings.get(this.nr).size()-1 == i){
                ratings += this.ratings.get(this.nr).get(i) ;
            }else{
                ratings += this.ratings.get(this.nr).get(i)+ ", " ;
            }
        }
        return ratings;
    }



    @Override
    public int compareTo(Musician o) {
        return o.amountOfTracks.compareTo(this.amountOfTracks);
    }
}
