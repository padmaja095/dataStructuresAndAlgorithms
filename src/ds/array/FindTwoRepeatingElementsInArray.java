package ds.array;

public class FindTwoRepeatingElementsInArray {
    public static void main(String[] args) {
        int arr[] = { 2, 5, 3, 1, 2, 5, 4 };

        // Range of numbers is 2 plus size of array
        int n = arr.length - 2;

        findTwoRepeatingElementsInArray(arr, n);

    }

    private static void findTwoRepeatingElementsInArray(int[] arr, int n) {
        int XOR = arr[0];
        for (int i = 1; i < arr.length; i++) {
            XOR ^= arr[i];
        }
        for (int i = 1; i <= n; i++) {
            XOR ^= i;
        }
        int set_bit_no = XOR & ~(XOR-1);
        int x=0;int y=0;
        for (int i = 0; i < arr.length; i++)
		{
			if ((arr[i] & set_bit_no) > 0){
				/*XOR of first set in arr[] */
				x = x ^ arr[i];
            }
			else
				/*XOR of second set in arr[] */
				y = y ^ arr[i];
		}
		
		for (int i = 1; i <= n; i++)
		{
			if ((i & set_bit_no)>0)
			
				/* XOR of first set in arr[] and
				{1, 2, ...n }*/
				x = x ^ i;
			else
				/* XOR of second set in arr[] and
					{1, 2, ...n } */
				y = y ^ i;
		}
	
		System.out.println("Two Missing Numbers are ");
		System.out.println( x + " " + y);
    }
}
