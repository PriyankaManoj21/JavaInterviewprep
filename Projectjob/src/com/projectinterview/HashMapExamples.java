package com.projectinterview;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HashMapExamples {
	public static void main(String args[]) {
		
		frequencyOfCharacters();
		frequencyCheckusingstream();

	}

	static void frequencyOfCharacters() {
		String s = "happpy";
		HashMap<String, Integer> letters = new HashMap<String, Integer>();
		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {

			String key = Character.toString(arr[i]);
			if (letters.containsKey(key)) {
				letters.put(key, letters.get(key) + 1);

			} else {
				letters.put(key, 1);
			}

		}

		System.out.println("LETTERS " + letters);
		String higheroc = Character.toString(s.charAt(0));
		for (String ch : letters.keySet()) {

			System.out.println("LETTERS " + ch);
			if (letters.get(ch) > letters.get(higheroc)) {
				higheroc = ch;

			}

		}

		System.out.println("higheroc " + higheroc);
	}
	
	
	
	
	
	public static void frequencyCheckusingstream() {
		
		String test = "arrya";
		Map<Character, Long> map = test.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println("map " +map);
		
		
	}
	
	
	
}
