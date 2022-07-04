package ds.array;

public class FindMajorityElement {
    // Find The majority element in the array i.e., more than arr.length/2 times.
    // Boyer-Moore algorithm to solve in O(n) times
    public static void main(String args[]) {
        int arr[] = { 1, 8, 7, 2, 2, 2, 2 };
        FindMajorityElement fmp = new FindMajorityElement();
        int majorityElement = fmp.findMajorityElement(arr);
        System.out.println(majorityElement);

    }

    public int findMajorityElement(int arr[]) {
        int cnt = 0;
        int m = -1;
        for (int i = 0; i < arr.length; i++) {
            if (cnt == 0) {
                m = arr[i];
                cnt++;
            } else {
                if (m == arr[i]) {
                    cnt++;

                } else {
                    cnt--;
                }

            }
        }
        int majorityCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (m == arr[i]) {
                majorityCount++;
            }
        }
        return majorityCount > arr.length / 2 ? m : 0;
    }
}
