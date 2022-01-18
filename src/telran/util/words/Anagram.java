package telran.util.words;

import java.util.TreeMap;

public class Anagram {
/**
 * 
 * @param word
 * @param anagram
 * @return true if anagram contains a word comprising of only all letters from a given word (case insensitive)
 * implementation requirements: O[N], using only one map and two passing's over (one is over word and other is over anagram)
 */
	public static boolean isAnagram(String word, String anagram) {
		if(word.length()!=anagram.length()) {
			return false;
		}
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for(int i = 0; i < word.length(); i++) {
			Integer count = map.getOrDefault(word.toLowerCase().charAt(i), 0);
			map.put(word.toLowerCase().charAt(i), count + 1);
		}
		for(int i = 0; i < anagram.length(); i++) {
			Integer count = map.getOrDefault(anagram.toLowerCase().charAt(i), 0);
			map.put(anagram.toLowerCase().charAt(i), count - 1);
		}
		for(Integer i: map.values()) {
			if(i!=0) {
				return false;
			}
		}
		
		return true;
	}

}