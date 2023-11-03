
/**
 * Implements a new Castaway class that makes a castaway with
 * the data of the name, score, and gender of the person. 
 *
 * @author jiun
 * @version 11/3/2023
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

    /**
     * Comparing based on last name and first name
     * 
     * @return negative integer, zero, or a positive integer as this 
     * object is less than, equal to, greater than the specified object
     */
    public int compareTo(Castaway other) {
        if (l.compareTo(other.l) == 0) {
            return f.compareTo(other.f);
        } else {
            return l.compareTo(other.l);   
        }
    }
    
    /**
     * Returns whether last name and first name are equal
     * 
     * @return true if equal or false if not equal
     */
    public boolean equals(Castaway other) {
        return compareTo(other) == 0;
    }
    
    /**
     * Returns first and last name of person
     * 
     * @return first and last name as string
     */
    public String toString() {
        return f + " " + l;
    }
    
}
