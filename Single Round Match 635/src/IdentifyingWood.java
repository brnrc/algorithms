

public class IdentifyingWood {
	
	public String check(String s, String t) {
        int j = 0;
        for (int i = 0; i < s.length() && j < t.length(); i++) {
            if(t.charAt(j) == s.charAt(i)) j++;
        }
        return (j == t.length()) ? "Yep, it's wood." : "Nope.";
	}
}
