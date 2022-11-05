package ds.stacks;

public class StockSpanProblem {
    public static void main(String args[])
    {
        int price[] = { 100, 80, 60, 70, 60, 75,85 }; 
        int n = price.length;
        int stock[]= new int[n]; 
        calculateSpan(price, n, stock); 
        printSpan(stock, n); 
     
    }

    private static void printSpan(int[] stock, int n) {
        for (int i = 0; i < n; i++) 
           System.out.println(stock[i]); 
    }

    private static void calculateSpan(int[] arr, int n, int[] stock) {
        stock[0] = 1; 
 
        //find stock values for rest 
        for (int i = 1; i < n; i++) { 
            int c = 1; 
            while ((i - c) >= 0 && arr[i] > arr[i - c]) { 
                c += stock[i - c]; 
            } 
            System.out.println("c: "+c);
            stock[i] = c; 
        } 
    }
    
}
