import java.util.ArrayList;
import java.util.Random;

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
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree.isEmpty());
        System.out.println(tree.size());
        tree.insert(5);
        tree.insert(4);
        tree.insert(1);
        System.out.println(tree.getDepth());
        tree.insert(3);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(8);
        tree.insert(11);
        System.out.println(tree.getMin());
        System.out.println(tree.getMax());
        System.out.println(tree.size());
        System.out.println(tree.isEmpty());
        System.out.println(tree.toString());
        System.out.println(tree.getDepth());
        tree.printTree();
        tree.remove(5);
        tree.printTree();
        tree.remove(4);
        tree.printTree();
        tree.remove(10);
        tree.printTree();
        tree.remove(6);
        tree.printTree();
        tree.removeMax();
        tree.printTree();
        tree.removeMin();
        tree.printTree();
        tree.removeMin();
        tree.printTree();
        tree.removeMin();
        tree.printTree();
        tree.removeMin();
    }
    
      
        
        
    
    
    
   
}
