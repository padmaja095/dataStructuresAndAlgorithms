package ds.array;

public class SortedTripletsInArray {
    public static void main(String[] args) {
        int arr[] = { 48, 43, 60, 2, 75 };
        SortedTripletsInArray ms = new SortedTripletsInArray();
        System.out.println(ms.sortedTripletsInArray(arr));
    }

    private boolean sortedTripletsInArray(int[] arr) {
        int min = arr[0];
        int secondMin = Integer.MAX_VALUE;
        if (arr.length < 3) {
            return false;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= min && secondMin == 2147483647) {
                min = arr[i];
            } else if (arr[i] <= secondMin && arr[i] > min) {
                secondMin = arr[i];
            } else if (arr[i] > secondMin) {
                return true;
            }
        }
        return false;
    }
}
