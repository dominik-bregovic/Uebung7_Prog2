import java.util.Comparator;

public class RartingCompare implements Comparator <Musician>{

    @Override
    public int compare(Musician o1, Musician o2) {
        if (o1.getAverageRating() > o2.getAverageRating()) {
            return -1;
        }else if (o1.getAverageRating() < o2.getAverageRating()) {
            return 1;
        }else
            return 0;
    }
}
