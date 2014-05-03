package round1;

public class Implement_strStr {

	public static void main(String[] args) {
		Implement_strStr i = new Implement_strStr();
		System.out.println(i.strStr("abcd", "c"));
	}

	public String strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return null;
		int index = haystack.indexOf(needle);
		if (index == -1)
			return null;
		return haystack.substring(index);
	}
	// public String strStr(String haystack, String needle) {
	// if (haystack == null || needle == null) {
	// return null;
	// }
	// for (int i = 0; i <= haystack.length() - needle.length(); i++) {
	// boolean find = true;
	// for (int j = 0; j < needle.length(); j++) {
	// if (haystack.charAt(i + j) != needle.charAt(j)) {
	// find = false;
	// break;
	// }
	// }
	// if (find) {
	// return haystack.substring(i);
	// }
	// }
	// return null;
	// }

}
