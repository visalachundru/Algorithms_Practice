package com.learning;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
	public static void main(String[] args) {
		String firstString = "qazwsx";
		String secondString = "wsxzaq";
		String thirdString = "qazwsx";
		String fourthString = "xzaqop";

		boolean isFirstSecondAnagram1 = isAnagram(firstString, secondString);
		boolean isThirdFourthAnagram1 = isAnagram(thirdString, fourthString);

		boolean isFirstSecondAnagram2 = isAnagramSecondWay(firstString, secondString);
		boolean isThirdFourthAnagram2 = isAnagramSecondWay(thirdString, fourthString);

		boolean isFirstSecondAnagram3 = isAnagramThirdWay(firstString, secondString);
		boolean isThirdFourthAnagram3 = isAnagramThirdWay(thirdString, fourthString);

		System.out.println("First and Second Strings using first Method: " + isFirstSecondAnagram1);
		System.out.println("Third and fourth Strings using first Method: " + isThirdFourthAnagram1);
		System.out.println("First and Second Strings using second Method: " + isFirstSecondAnagram2);
		System.out.println("Third and fourth Strings using second Method: " + isThirdFourthAnagram2);
		System.out.println("First and Second Strings using second Method: " + isFirstSecondAnagram3);
		System.out.println("Third and fourth Strings using second Method: " + isThirdFourthAnagram3);

		if (!isThirdFourthAnagram1) {
			System.out.println("Number of letters to be deleted to  make an anagram are: " + makeAnagramAndPrintDeleteCount(thirdString, fourthString));
		}

	}

	private static int makeAnagramAndPrintDeleteCount(String stringOne, String stringTwo) {
		int count1[] = new int[26];
		int count2[] = new int[26];
		// count frequency of each character in each string
		for (int i = 0; i < stringOne.length(); i++) {

			count1[stringOne.charAt(i) - 'a']++;
		}

		for (int i = 0; i < stringTwo.length(); i++) {
			count2[stringTwo.charAt(i) - 'a']++;
		}

		// traverse count arrays to find
		// number of charcters to be removed
		int result = 0;
		for (int i = 0; i < 26; i++) {
			result += Math.abs(count1[i] - count2[i]);
		}
		return result;

	}

	private static boolean isAnagram(String firstString, String secondString) {
		if (firstString.length() == secondString.length()) {
			char[] firstStringArray = firstString.toCharArray();
			char[] secondStringArray = secondString.toCharArray();
			Arrays.sort(firstStringArray);
			Arrays.sort(secondStringArray);
			firstString = new String(firstStringArray);
			secondString = new String(secondStringArray);
			if (firstString.equals(secondString)) {
				return true;
			}
		}

		return false;
	}

	private static boolean isAnagramSecondWay(String firstString, String secondString) {
		boolean status = true;
		if (firstString.length() == secondString.length()) {
			char[] firstStringArray = firstString.toCharArray();

			StringBuilder secondStringBuilder = new StringBuilder(secondString);
			for (char charcater : firstStringArray) {
				// checking to see each character is present in the second string
				int secondStringIndex = secondStringBuilder.indexOf("" + charcater);
				if (secondStringIndex >= 0) {
					// deleting the matching character from the second string
					secondStringBuilder = secondStringBuilder.deleteCharAt(secondStringIndex);
				} else {
					status = false;
					break;

				}
			}
		}

		return status;
	}

	private static boolean isAnagramThirdWay(String firstString, String secondString) {
		boolean status = true;
		if (firstString.length() == secondString.length()) {
			char[] firstStringArray = firstString.toCharArray();
			char[] secondStringArray = secondString.toCharArray();

			HashMap<Character, Integer> map = new HashMap<Character, Integer>();

			for (char charcater : firstStringArray) {
				if (map.containsKey(charcater)) {
					int currentCount = map.get(charcater);
					map.put(charcater, currentCount++);
				} else {
					map.put(charcater, 1);
				}
			}

			for (char charcater : secondStringArray) {
				if (map.containsKey(charcater)) {
					int currentCount = map.get(charcater);
					map.put(charcater, currentCount - 1);
				} else {
					map.put(charcater, 1);
				}
			}
			for (int value : map.values()) {
				if (value != 0) {
					status = false;
					break;
				}
			}
		}

		return status;
	}

}
