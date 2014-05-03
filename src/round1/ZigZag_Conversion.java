package round1;

public class ZigZag_Conversion {

	public static void main(String[] args) {
		String str = "a";
		System.out.println(new ZigZag_Conversion().convert(str, 1));
	}

	public String convert(String s, int nRows) {
		if(nRows == 1)
			return s;
		int len = s.length();
		char chs[] = new char[len];
		int gap = nRows * 2 - 2;
		for (int i = 0, count = 0; i < nRows; i++) {
			for (int j = i; j < len; j += gap) {
				chs[count++] = s.charAt(j);
				if (j % gap == 0 || j % gap == nRows - 1)
					continue;
				int base = j / gap * gap;
				int pos = j % gap;
				if (base + gap - pos < len) {
					chs[count++] = s.charAt(base + gap - pos);
				}
			}

		}
		return new String(chs);
	}
}
