package ds.array;

public class DutchNationalFlagProblem {
    //Q: sort the array, array consists of only 0,1,2
    //approach: in O(n) we can solve this problem with one parse, by including some condition
    //idea on when ever see 0: swap it to left and see 1: traverse to next element, see 2 : swap to the right side
    public static void main(String args[]) {
        int arr[] = { 0,2,1,1,2,0,2 };
        DutchNationalFlagProblem fmp = new DutchNationalFlagProblem();
        printArray(fmp.dutchNationalFlagProblem(arr));
    }
    private int[] dutchNationalFlagProblem(int[] arr) {
        int c=0;int l=0;
        int h= arr.length-1;
        while(c<h){

            if(arr[c]==0)
            {
                swap(arr, c, l);
                l++;c++;
            }
            else if(arr[c]==1)
            {
                c++;
            }
            else if(arr[c]==2)
            {
                swap(arr, c, h);h--;
            }
        }
        return arr;
    }
    public void swap(int arr[], int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    static void printArray(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

    }
}
