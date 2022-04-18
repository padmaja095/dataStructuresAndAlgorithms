package ds;

public class InsertionSort {
	public static void main(String[] args) throws Exception {
		//Initializing the array
		int array[] = new int[] { 6, 5, 3, 1, 8, 7, 2, 4 };
         //looping the array from the second element.
		 //save the value that need to be sorted as key
		 //check the element with the next element , if the element is smaller swap ad decrement the array of i.
		for (int i = 1; i < array.length; i++) {
			while ((i > 0) && (array[i - 1] > array[i])) {
				int key = array[i - 1];
				array[i - 1] = array[i];
				array[i] = key;
				i--;

			}
		}
		for (int i : array) {
			System.out.print(i + " ");
		}

	}
}
