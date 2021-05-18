import java.util.ArrayList;
import java.util.List;

public class Musician implements Comparable<Musician>{
    private static int countMusicians= 0;
    private int nr;
    private String name;
    private Integer amountOfTracks;
    private Double averageRating;
    private List<ArrayList<Double>> ratings;


    public Musician(String name, Integer amountOfTracks, List ratingsPerInterpret){
        this.name = name;
        this.amountOfTracks = amountOfTracks;
        this.ratings = ratingsPerInterpret;
        this.nr = countMusicians++;
        averageRatings();
    }

    public String ToString(){

        return this.name+";"+
                this.amountOfTracks + ";"  +
                String.format("%.2f", averageRating).replace(".",",")
                + ";" + formatRatings();
    }


    /**
     * counting all specific ratings together and divide them by the amount of ratings
     */
    public void averageRatings(){
        double avg = 0;
        for (int i = 0; i < this.ratings.get(this.nr).size(); i++) {
            avg += this.ratings.get(this.nr).get(i);
        }
        this.averageRating = (avg/amountOfTracks);
        roundAverageRatings();
    }

    /**
     * have to round the avarageRating
     * we are multiplying by 1000 to get a more accurate result
     */
    public void roundAverageRatings(){
        int numb;
        double numb2;
        numb2 = this.averageRating *1000;
        numb = (int)numb2;
        this.averageRating = (double)numb/1000;
    }

    /**
     * formating the specific ratings in order to get the desired output to the console
     */
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


    public Double getAverageRating() {
        return averageRating;
    }


}
