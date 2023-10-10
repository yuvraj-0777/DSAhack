import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerNumber {
	
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
