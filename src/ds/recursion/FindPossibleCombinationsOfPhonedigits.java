package ds.recursion;
import java.util.ArrayList;
public class FindPossibleCombinationsOfPhonedigits {
    // Java implementation of the approach



	// String array to store keypad characters
	static final String codes[]
		= { " ", "abc", "def",
			"ghi", "jkl", "mno",
			"pqr", "stu", "vwx",
			"yz" };

	// Function that returns an Arraylist
	// which contains all the generated words
	public static ArrayList<String> printKeyWords(String str)
	{

		// If str is empty
		if (str.length() == 0) {
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");

			// Return an Arraylist containing
			// empty string
			return baseRes;
		}

		// First character of str
		char ch = str.charAt(0);

		// Rest of the characters of str
		String restStr = str.substring(1);

		ArrayList<String> prevRes = printKeyWords(restStr);
        System.out.println("prevRev"+prevRes.size());
		ArrayList<String> Res = new ArrayList<>();

		String code = codes[ch - '0'];

		for (String val : prevRes) {

            System.out.println(val);
			for (int i = 0; i < code.length(); i++) {
                System.out.println(code.charAt(i)+"val:"+val);
				Res.add(code.charAt(i) + val);
                System.out.println(Res.size());
			}
		}
		return Res;
	}

	// Driver code
	public static void main(String[] args)
	{
		String str = "236";

		// Print all the possible words
		System.out.println(printKeyWords(str));
	}
}

    

