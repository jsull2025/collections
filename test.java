
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    // instance variables - replace the example below with your own
    

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void sampleMethod()
    {   
        MyLinkedList list = new MyLinkedList();
        // put your code here
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.addHead(2);
        list.addHead(10);
        list.addTail(5);
        System.out.println(list.getHead());
        System.out.println(list.toString());
        System.out.println(list.removeHead());
        System.out.println(list.removeHead());
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        
    }
}
