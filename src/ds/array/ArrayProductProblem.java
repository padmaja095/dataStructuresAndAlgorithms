package ds.array;

public class ArrayProductProblem {
    //Q: find the arry product of all element excelt the respective index element value 
    //eg.{1,2,3,4} output{23,12,8,6}
    public static void main(String[] args)
    {
    int arr[] = { 1,2,3,4};
    ArrayProductProblem ms = new ArrayProductProblem();
    printArray(ms.sortedTripletsInArray(arr));
    }

    private int[] sortedTripletsInArray(int[] arr) {

        return null;
    }
    static void printArray(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
		
	}
}
