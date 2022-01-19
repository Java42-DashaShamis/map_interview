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
		/* V.R. This checking isn't enough. 
		 *  What will be if word (or anagram) is empty or null?
		 *  In both of cases exception will stop your application
		 */
		if(word.length()!=anagram.length()) {
			return false;
		}
		/* V.R. Why TreeMap is selected? HashMap does the same (in our case) but
		 * its complexity (O[1]) is better.
		 * Anyway it is better to write
		 * Map<Character, Integer> map = new HashMap<>();
		 * 
		 */
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for(int i = 0; i < word.length(); i++) {
			Integer count = map.getOrDefault(word.toLowerCase().charAt(i), 0);
			map.put(word.toLowerCase().charAt(i), count + 1);
		}
		for(int i = 0; i < anagram.length(); i++) {
			Integer count = map.getOrDefault(anagram.toLowerCase().charAt(i), 0);
			/* V.R. It is the good place to check the count here
			 *  if(count==0) return false;
			 */
			map.put(anagram.toLowerCase().charAt(i), count - 1);
		}
		/* V.R.
		 * If to check count inside the previous loop then the following is redundant
		 */
		for(Integer i: map.values()) {
			/* V.R. 
			 *  i may be negative (in your implementation) and existing checking
			 *  isn't enough
			 */
			if(i!=0) {
				return false;
			}
		}
		
		return true;
	}

}