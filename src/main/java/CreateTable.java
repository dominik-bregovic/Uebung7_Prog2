import java.util.*;

public class CreateTable {
    AnalyseTable analysed;
    List<ArrayList<String>> categories;
    List<String> interpretList;
    List<Integer> tracksPerInterpret;
    List<String> track;
    List<String> rating;

    List<Musician> musicians = new ArrayList<>();
    List<String> interpretWithRatings = new ArrayList<>();
    ArrayList<String> interprets = new ArrayList<>();
    ArrayList<String> ratings = new ArrayList<>();
    List<ArrayList<Double>> interpretRatings = new ArrayList<>();


    public CreateTable(AnalyseTable alanyse){
        this.analysed = alanyse;
        getRessources();
        getInterpretsAndTheirRatings();
        createMusicans();
        printMusicians();

    }

    public void getRessources(){
        this.categories = this.analysed.getCategories();
        this. interpretList = this.analysed.getUniqueInterpretList();
        this.tracksPerInterpret = this.analysed.getCountTrackToInterpret();
        this.track = this.categories.get(3);
        this.rating = this.categories.get(5);

    }

    /**
    * splitting the interprets to separate indexes in a list
    * adding every interpret his rates into a new list in order to assign every rating to an interpret
    * Collections.sort is sorting the interprets by the amount of tracks
    */
    public void getInterpretsAndTheirRatings(){
        String[] separatedInterpret;

        for (int i = 0; i < categories.get(4).size(); i++) {
            separatedInterpret = categories.get(4).get(i).split(",");

            for (int j = 0; j < separatedInterpret.length; j++) {
                this.interpretWithRatings.add(separatedInterpret[j].trim() + ":" + categories.get(5).get(i)+ ": ");
            }
        }
        sortRatingFromInterpret();
    }

    /**brief explanation:
    * -first method splitting the ratings from the interprets in order to gain two lists with related indexes (interpret to his specific rating)
    * -second make a list of rating-lists in order to receive a list of ratings with related indexes to the interpretsList
    * -to sum up, we want a list of lists of Ratings in order to relate them to every singel interpret from the interpretLists-list
    */
    public void sortRatingFromInterpret(){
        splittingInterpretAndTheirRatings();
        makeListWithInterpretIndexes();
    }

    public void splittingInterpretAndTheirRatings(){
        for (int i = 0; i < interpretWithRatings.size(); i++) {
            String[] interpretRating = interpretWithRatings.get(i).split(":");
            for (int j = 0; j < interpretRating.length-1; j += 2) {
                interprets.add(interpretRating[j]);
                ratings.add(interpretRating[j+1]);
            }
        }

    }

    /**nearer explanation:
    * comparing the interpretList (only unique elements) with the interprets-list
    * the lists rating and interprets have related indexes to each other. Every ratings-index belongs to one interprets-index
    * example:
    * (David G.)interprets index 0 --> ratings index 0 = 1.5
    * (David G.)interprets index 4 --> ratings index 4 = 2.0
    */
    public void makeListWithInterpretIndexes(){
        for (int i = 0; i < interpretList.size(); i++) {
            interpretRatings.add(new ArrayList<>());
            for (int j = 0; j < interprets.size(); j++) {
                if (interpretList.get(i).contains(interprets.get(j)) ){//here unique interpretList
                    interpretRatings.get(i).add(Double.parseDouble(ratings.get(j).replaceAll(",",".")));
                }
            }
        }
    }


    /**
     * creating instances of Musician and add the to the list
     */
    public void createMusicans(){
        for (int i = 0; i < this.interpretList.size(); i++) {
            this.musicians.add(new Musician(this.interpretList.get(i), this.tracksPerInterpret.get(i), this.interpretRatings));
        }
    }


    /**
     * sorting the musician list
     * by amount of tracks
     * by average rating
     */
    public void printMusicians(){
        sortMusician();
        Collections.sort(this.musicians);
        System.out.println("Interpret;Number of Tracks;Average Rating;Single Ratings");
        for (Musician musician : this.musicians) {
            System.out.println(musician.ToString());
        }
    }

    /**
     * adding RatingCompare in order to sort the average ratings from the musician list
     */
    public void sortMusician(){
        RartingCompare rc = new RartingCompare();
        Collections.sort(this.musicians, rc);
    }

}
