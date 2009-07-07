package jshopper;

public abstract class Utility {
	public static String stringToHTML(String str) {
		String tstr = "";
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
				case '<':
					tstr += "&lt;";
					break;
				case '>':
					tstr += "&gt;";
					break;
				case '"':
					tstr += "&quot;";
					break;
				case '&':
					tstr += "&amp;";
					break;
				default:
					if (c > 0x7f)
						tstr += "&#"+(int)c+";";
					else
						tstr += c;
			}
		}
		
		return tstr.toString();
	}
	
	public static String getTmpPath() {
		String filepath = System.getProperty("java.io.tmpdir") +
						  System.getProperty("file.separator");
		return filepath;
	}
}
