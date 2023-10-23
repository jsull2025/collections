
/**
 * Write a description of class squareroot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class squareroot
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class squareroot
     */
    public squareroot()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double sampleMethod(double sq)
    {
        // put your code here
        double d = sq/2;
        int iterations = 0;
        while (!(d*d <= sq + 0.0000001 && d*d >= sq - 0.0000001)) {
            if (d*d > sq) {
                d = d/2;
            } else {
                d += d/2;
            }
            iterations++;
        }
        
        
        System.out.println(iterations);
        return d;
    }
    public double sampleMethod2(double sq)
    {
        // put your code here
        double d = sq/2;
        double min = 0;
        double max = sq;
        int iterations = 0;
        while (!(d*d <= sq + 0.0000000000001 && d*d >= sq - 0.0000000000001)) {
            if (d*d > sq) {
                max = d;
                d = (min + d)/2;
            } else {
                min = d;
                d = (max + d)/2;
                
            }
            iterations++;
        }
        
        
        System.out.println(iterations);
        return d;
    }

    
    
    
}
