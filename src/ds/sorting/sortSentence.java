package ds.sorting;

public class sortSentence {

	public static void main(String[] args) {
		//String ele="rest1";
		//int i= Integer.parseInt(Character.toString(ele.charAt(ele.length() - 1)));  
		//System.out.println(i);
		String sorted=sortSentence("a3 is2 sentence4 This1");
		System.out.println(sorted);

	}
    public static String sortSentence(String s) {
    	  String[] str = s.split(" ");
    	    String[] res = s.split(" ");
    	    int i=0;
    	    StringBuilder sb = new StringBuilder(); 
    	    
    	    for (String ele : str) 
    	    {
    		    i = Integer.parseInt(Character.toString(ele.charAt(ele.length() - 1)));  
    		    res[i - 1] = ele.substring(0, ele.length() - 1); 
    	    }
    	    
    	    for (i = 0; i < res.length - 1; i++)
    		    sb.append(res[i]).append(" ");
    	    sb.append(res[i]);
    	   
    	    return sb.toString();
    	}
        
    

}
