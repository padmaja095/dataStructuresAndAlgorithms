package ds.array;

public class ArrayProductProblem {
    // Q: find the arry product of all element excelt the respective index element
    // value
    // eg.{1,2,3,4} output{23,12,8,6}
    // approach 1: For every index calculate the left product and saveit as L and
    // for have a loop for finding the full right product and multiply both of them
    // -> O(n^2)
    // approach 2: have left and right seperate array.left array will have product
    // of left side products of that index. for the given example L={1,1,2,6} and
    // same to right array R={24,12,4,1} and find the product of these two to get
    // ouput array. -> time is O(n) and space is O(n)
    // approach 3: to make space O(1) we can leverage the given output array .
    // calculate the left array L=O={1,1,2,6} and then have a loop from the right
    // side and multiply the value with right side of index with varaible R as
    // product of previous right side product.
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        ArrayProductProblem ms = new ArrayProductProblem();
        // printArray(ms.arrayProductProblemFirstApproach(arr));
        // printArray(ms.arrayProductProblemSecondApproach(arr));
        printArray(ms.arrayProductProblemThirdApproach(arr));
    }

    private int[] arrayProductProblemSecondApproach(int[] arr) {
        int[] leftProduct = new int[arr.length];
        int[] rightProduct = new int[arr.length];
        int[] output = new int[arr.length];
        // {1,1,2,6}
        leftProduct[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * arr[i - 1];
        }
        // [24,12,4,1]
        rightProduct[arr.length - 1] = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * arr[i + 1];
        }
        for (int i = 0; i < arr.length; i++) {
            output[i] = leftProduct[i] * rightProduct[i];
        }
        return output;
    }

    private int[] arrayProductProblemThirdApproach(int[] arr) {
        int[] output = new int[arr.length];
        // {1,1,2,6}
        output[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            output[i] = output[i - 1] * arr[i - 1];
        }
        int rightProduct = 1;
        for (int i = arr.length - 1; i >= 0; i--) {

            output[i] = rightProduct * output[i];
            rightProduct = rightProduct * arr[i];
        }
        return output;
    }

    private int[] arrayProductProblemFirstApproach(int[] arr) {

        int L = 1;
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                L = L * arr[i - 1];
            }
            int R = 1;
            for (int j = i + 1; j < arr.length; j++) {
                R = R * arr[j];
            }
            output[i] = L * R;

        }
        return output;
    }

    static void printArray(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

    }
}
