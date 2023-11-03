
/**
 * Write a description of class CastawayTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CastawayTest
{
    // instance variables - replace the example below with your own
    private static String[] lastName = {"",
                                    "Grumby",
                                    "Howell",
                                    "Howell",
                                    "Grant",
                                    "Hinkley",
                                    "Summers"};
    private static String[] firstName = {"Gilligan",
                                    "Jonas",
                                    "Thurston",
                                    "Lovey",
                                    "Ginger",
                                    "Roy",
                                    "Mary Ann"};
    private static int[] score = {72, 85, 82, 96, 90, 96, 88};
    private static String[] gender = {"M", "M", "M", "F", "F", "M", "F"};  

    /**
     * Constructor for objects of class CastawayTest
     */
    public CastawayTest()
    {
        
    }

    public static void sampleMethod()
    {
        MyLinkedList<Castaway> list = new MyLinkedList<Castaway>();
        for (int i = 0; i < 7; i++) {
            list.insertSorted(new Castaway(lastName[i], 
                    firstName[i], score[i], gender[i])); 
        }
        System.out.println(list.toString());
        Castaway dummy = new Castaway("Summers", "Mary Ann", 0, "");
        list.remove(dummy);
        System.out.println(list.toString());
    }
}
