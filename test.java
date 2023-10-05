
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test<E>
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
    
    public static boolean wellFormedExpressionsMethod(String s) {
        MyStackLL list = new MyStackLL();
        String openChars = "{[(";
        String closeChars = "}])";
        
        for (int i = 0; i < s.length(); i++) {
            if (openChars.indexOf(s.substring(i, i + 1)) != -1) {
                list.push(s.substring(i, i + 1));
            } else if (list.top() == "(" && s.substring(i, i + 1) == ")") {
                list.pop();
            } else if ( list.top() == "[" && (String) s.substring(i, i + 1) == "]") {
                list.pop();
            } else if ((String) list.top() == "{" && (String) s.substring(i, i + 1) == "}") {
                list.pop();
            } else if (closeChars.indexOf(s.substring(i, i + 1)) != -1) {
                return false;
            } 
            
        }
        return list.isEmpty();
    }
}
