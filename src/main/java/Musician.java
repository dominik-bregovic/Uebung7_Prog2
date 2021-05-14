public class Musician implements Comparable<Musician>{

    private String name;
    private Integer tracks;

    public Musician(String name, Integer tracks){
        this.name = name;
        this.tracks = tracks;
    }

    public String ToString(){
        return name+":"+tracks;
    }

    @Override
    public int compareTo(Musician o) {
        return o.tracks.compareTo(this.tracks);
    }
}
