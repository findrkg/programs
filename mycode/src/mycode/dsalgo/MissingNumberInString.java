package mycode.dsalgo;

public class MissingNumberInString {

	public static void main(String[] args) {
		String str = "99100102"; // max 6 digits
		System.out.println(findMissingNumber(str));
	}

	static String to_string(int n) {
		return ""+n;
	}

	static boolean expectedNextNum(String str, int expectedNextNum, int start)
	{
	    if(start + to_string(expectedNextNum).length() > str.length()){
	        return false;
	    }

	    int nextNum = Integer.parseInt(str.substring(start, to_string(expectedNextNum).length()));
	    return (nextNum == expectedNextNum);
	}

	static int findMissingNumber(String str)
	{
	    int len = str.length();
	    int i = 1;
	    int missingNum = -1;
	    boolean fail = false;

	    while(i <= len){
	        int start = i;
	        int curr = Integer.parseInt(str.substring(0, i));

//	        while(bOk){
	            if(expectedNextNum(str, curr + 1, start)){
	                start += to_string(curr + 1).length();
	                curr = curr + 1;	                
	            }
	            else if(expectedNextNum(str, curr + 2, start)){	            	
	                start += to_string(curr + 2).length();
	                missingNum = curr + 1;
	                curr = curr + 2;
	            }
	            else {
	            	fail = true;
	            	break;
	            }
//	        }
	        if(!fail){
	            return missingNum;
	        }
	        i++;
	    }
	    return -1;
	}
}
