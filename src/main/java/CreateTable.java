import java.util.*;

public class CreateTable {
    AnalyseTable analysed;
    List<ArrayList<String>> categories;
    List<ArrayList<String>> interpretRatings = new ArrayList<>();
    List<String> interpretList;
    List<Integer> tracksPerInterpret;
    List<String> track;
    List<String> rating;
    List<Musician> musicians = new ArrayList<>();
    LinkedHashMap<String, String> interpretsTooRatings = new LinkedHashMap<>();
    LinkedHashMap<String, String> trackRating = new LinkedHashMap<>();
    List<String> ratingPerInperpret = new ArrayList<>();
    ArrayList<String> interprets = new ArrayList<>();
    ArrayList<String> ratings = new ArrayList<>();
    ArrayList<String> oneInterpretForRating = new ArrayList<>();
    ArrayList<String> oneRatingForInterpret;

    public CreateTable(AnalyseTable alanyse){
        this.analysed = alanyse;
        getRessources();


        getRatingFromInterpret();
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
            this.musicians.add(new Musician(this.interpretList.get(i), this.tracksPerInterpret.get(i), this.ratings));
        }
    }

    public void getRatingFromInterpret(){
        String[] seperatedInterpet;

        for (int i = 0; i < categories.get(4).size(); i++) {
            seperatedInterpet = categories.get(4).get(i).split(",");

            for (int j = 0; j < seperatedInterpet.length; j++) {
                this.ratingPerInperpret.add(seperatedInterpet[j].trim() + ":" + categories.get(5).get(i)+ ": ");
            }
        }
        Collections.sort(ratingPerInperpret);
        for (int i = 0; i < ratingPerInperpret.size(); i++) {
            System.out.println(ratingPerInperpret.get(i));
        }
        sortRatingFromInterpret();
    }

    public void sortRatingFromInterpret(){
        for (int i = 0; i < ratingPerInperpret.size(); i++) {
            String[] interpretRating = ratingPerInperpret.get(i).split(":");
            for (int j = 0; j < interpretRating.length-1; j += 2) {
                interprets.add(interpretRating[j]);
                ratings.add(interpretRating[j+1]);
            }
        }

        System.out.println(interpretList);

        for (int i = 0; i < interpretList.size(); i++) {
            interpretRatings.add(new ArrayList<>());
            for (int j = 0; j < interprets.size(); j++) {
                if (interpretList.get(i).contains(interprets.get(j)) ){//here unique interpretList
                    interpretRatings.get(i).add(ratings.get(j));
                }
            }
        }
        System.out.println(interpretRatings);
//        for (int i = 0; i < interpretRatings.size(); i++) {
//            System.out.println(oneInterpretForRating.get(i));
//        }

    }



}
