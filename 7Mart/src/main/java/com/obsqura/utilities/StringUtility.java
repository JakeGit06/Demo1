package com.obsqura.utilities;

public class StringUtility {

	public String replaceString(String org_String, String string_to_replace, String replace_String) {
		String stringAfterReplace = org_String.replace(string_to_replace, replace_String);// replaces all occurrences of
																							// String_to_replace with
																							// Replace_String
		return (stringAfterReplace);
	}

	public int stringLength(String str) {
		return (str.length());
	}

	public String stringSpaceTrim(String str) {
		return (str.trim());
	}

	public boolean urlCheck(String actualUrl, String expectedUrl) {
		if (actualUrl.equals(expectedUrl)) {
			return (true);
		}
		return (false);
	}
}
