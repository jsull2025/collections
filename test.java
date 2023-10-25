
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
        list.addTail(6);
        list.addTail(7);
        list.add(2, 13);
        list.set(2, 5);
        list.set(1, 3);
        list.set(3, 4);
        list.insertSorted(4);
        System.out.println(list.getHead());
        System.out.println(list.toString());
        System.out.println(list.remove(0));
        System.out.println(list.remove(2));
        System.out.println(list.remove(0));
        System.out.println(list.toString());
        list.insertSorted(15);
        list.insertSorted(8);
        list.remove(new Integer(8));
        System.out.println(list.toString());
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        
    }
   
}
