

public class IdentifyingWood {
	
	public String check(String s, String t) {
        int lastMatch = 0;
        for (int i = 0; i < t.length(); i++) {
            for (int j = lastMatch; j < s.length(); j++) {
                if(s.charAt(j) == t.charAt(i)){
                    lastMatch = j+1;
                    if(i == t.length()-1) return "Yep, it's wood.";
                    break;
                }
            }
        }
        return "Nope.";
	}
}
