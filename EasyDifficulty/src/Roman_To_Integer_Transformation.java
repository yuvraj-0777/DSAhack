import java.util.HashMap;
import java.util.Map;

/* Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol Value
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. */
public class Roman_To_Integer_Transformation {
	
	@SuppressWarnings("serial")
	private static Map<Character, Integer> romanLetterToInt  = new HashMap<Character, Integer>() {{
	    put('I', 1);
	    put('V', 5);
	    put('X', 10);
	    put('L', 50);
	    put('C', 100);
	    put('D', 500);
	    put('M', 1000);
	}};

	public static int transformRomanToInt( String roman ) {
		int length = roman.length();
		int num = romanLetterToInt.get(roman.charAt(length-1)).intValue();
        for (int i = length-2; i>=0; i--) {
            if (romanLetterToInt.get(roman.charAt(i)) >= romanLetterToInt.get(roman.charAt(i + 1))) {
                num += romanLetterToInt.get(roman.charAt(i));
            } else {
                num -= romanLetterToInt.get(roman.charAt(i));
            }
        }
        return num;
	}
	
	public static void main(String[] Args) {
		String iv = "IV";
		System.out.println("The roman number IV is the " + transformRomanToInt(iv) );
		
		String cii = "CII";
		System.out.println("The roman number CII is the " + transformRomanToInt(cii) );
		
		String cdix = "CDIX";
		System.out.println("The roman number CDIX is the " + transformRomanToInt(cdix) );

	}
}
