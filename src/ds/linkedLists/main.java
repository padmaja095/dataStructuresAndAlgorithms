package ds.linkedLists;

public class main {
    //In Java, all primitives like int, char, etc are similar to C/C++, 
    //but all non-primitives (or objects of any class) are always references.
    // So it gets tricky when we pass object references to methods.
    // Java creates a copy of references and pass it to method, but they still point to same memory reference.
    // Mean if set some other reference to object passed inside method, the object from calling method as well its reference will remain unaffected. 
    //The changes are not reflected back if we change the object itself to refer some other location or object
        // swap() doesn't swap i and j
        public static void swap(Integer i, Integer j)
        {
           Integer temp = new Integer(i);
           i = j;
           System.out.println(i);
           j = temp;
           System.out.println(j);
        }
        public static void main(String[] args)
        {
           Integer i = new Integer(10);
           Integer j = new Integer(20);
           swap(i, j);
           System.out.println("i = " + i + ", j = " + j);
        
     }
    
}
