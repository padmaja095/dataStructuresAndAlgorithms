package ds.linkedLists;

public class main {
        //pass by value or reference
        //mutable or immutable
        //java is strictly pass by value.
        // primitive types like int,char,float are stored in stack and are passed by value as parameters
        // and they point to differnt memory locations in stack. so changing the primitive values in differnt method, doesnot affect the original.
        //In case of objects like wrappers like Integer or arraylist,Stack. Java doesnot pass objects but it passed object references.
        // normally obects are stored in heap.when passing them in parameters, new memory is created but they point to same locations. 
        //so on changing one value of object it reflects in orginal method.
        // This particluar example, Integer though it is object , why after going to swap method it doesnot changes in original method,
        // because Integer,String are immutable -> meaning once the value is set it cannot be changed.
        //but if objects like arraylist, Stack, StringBuilder are mutable classes -> so changing them in another method will reflect in original method as well.
        
        public static void swap(Integer i, Integer j)
        {
          // Integer temp=Integer.valueOf(i);
           // = new Integer(i);
          i=i.valueOf(1+1);
           System.out.println(i);
           j =j+1;
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
