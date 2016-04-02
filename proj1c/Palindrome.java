/**
 * Created by Ayyad Shenouda on 2/4/2016.
 * Palindrome Class.  
 */

public class Palindrome {
	
	/* convert string to Deque. */
	public static Deque<Character> wordToDeque(String word) {
		Deque<Character> wordToReturn = new ArrayDeque<Character>();
		for (char ch: word.toCharArray()) {
			wordToReturn.addLast(ch);		
		}
		return wordToReturn;
	}

	/* find if the word Palindrome or not. */
	public static boolean isPalindrome(String word) {
		if (word.length() <= 1) {
			return true;
		} else if (word.charAt(0) != word.charAt(word.length() - 1)) {	
			return false;
		}
		return isPalindrome(word.substring(1, word.length() - 1));
	}

	public static boolean isPalindrome(String word, CharacterComparator cc) {
		if(word.length() <= 1) {
			return true;
		} else if (cc.equalChars(word.charAt(0), word.charAt(word.length() - 1))) {
			return isPalindrome(word.substring(1, word.length() - 1), cc);		
		}
		return false;
	}
}