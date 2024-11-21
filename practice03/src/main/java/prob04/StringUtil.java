package prob04;

public class StringUtil {
	static String concatenate(String[] s) {
		String ret="";
		for(int i=0; i<s.length; i++) {
			ret+=s[i];
		}
		return ret;
	}
}
