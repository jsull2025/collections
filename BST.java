
/**
 * Write a description of class BST here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BST<E>
{
    // instance variables - replace the example below with your own
    private Tree<E> root;
    private int size;

    /**
     * Constructor for objects of class BST
     */
    public BST()
    {
        root = null;
        size = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void insert(E elem)
    {
        root.insert(elem);
    }
}
