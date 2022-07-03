package ds.recursion;

import ds.MergeSort;

public class isPowerOfTwo {

	public static void main(String[] args) {
		isPowerOfTwo ms = new isPowerOfTwo();
		boolean boo=ms.isPowerOfTwo(14);
		boolean s =false;
		//cghdg
System.out.println(boo);
	}
	 Boolean  isPowerOfTwo(int n) {
	        if(n==0) return false;
	        while(n%2==0) n/=2;
	        return n==1;
	    }

}
