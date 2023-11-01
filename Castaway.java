
/**
 * Write a description of class Castaway here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Castaway implements Comparable<Castaway>
{
    private String f;
    private String l;
    private int s;
    private String g;
    /**
     * Constructor for objects of class Castaway
     */
    public Castaway(String last, String first, int score, String gender)
    {
        l = last;
        f = first;
        s = score;
        g = gender;
    }

    public int compareTo(Castaway other) {
        if (l.compareTo(other.l) == 0) {
            return f.compareTo(other.f);
        } else {
            return l.compareTo(other.l);   
        }
    }
    
    public boolean equals(Castaway other) {
        return compareTo(other) == 0;
    }
    
    public String toString() {
        return f + " " + l;
    }
    
}
