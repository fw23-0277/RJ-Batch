package com.masai.school;

public class Plaindrome {
	public static String  palindrome(String str) {
		
		int i = 0, j = str.length() - 1;

		while (i <= j) {
			if (str.charAt(i) != str.charAt(j)) {
				return "No";
			}
			i++;
			j--;
		}
		
		return "Yes";
	}

	public static void main(String[] args) {
		String str = "NAMAN";
		System.out.print(palindrome(str));
		
	}
}
