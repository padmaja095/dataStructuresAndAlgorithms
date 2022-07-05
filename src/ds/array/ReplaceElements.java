package ds.array;

public class ReplaceElements {
    public static void main(String args[]) {
        int arr[] = {17,18,5,4,6,1 };
        ReplaceElements fmp = new ReplaceElements();
        printArray(fmp.replaceElements(arr));
    }

    private int[] replaceElements(int[] arr) {

        int n=arr.length;
        int maxValue=arr[n-1];
        arr[n-1]=-1;
        for(int i=arr.length-2;i>=0;i--)
        {
            int temp=maxValue;
            maxValue=arr[i]>maxValue?arr[i]:maxValue;
            arr[i]=temp;            

        }
        return arr;
    }
    static void printArray(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

    }
}
