public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> charList = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            charList.addLast(word.charAt(i));
        }
        return charList;
    }

    /**
    public boolean isPalindrome(String word) {
        String reverse = "";
        for (int i = word.length(); i > 0; i--) {
            reverse += word.charAt(i-1);
        }
        return reverse.equals(word);
    }
     */

    public boolean isPalindrome(String word) {
        Deque charList = wordToDeque(word);
        return isPalindromeHelper(charList);
    }

    private boolean isPalindromeHelper(Deque charList) {
        if (charList.size() == 0 || charList.size() == 1) {
            return true;
        }
        if (charList.removeFirst() == charList.removeLast()) {
            return isPalindromeHelper(charList);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque charList = wordToDeque(word);
        return isPalindromeHelper2(charList, cc);
    }

    private boolean isPalindromeHelper2(Deque charList, CharacterComparator cc) {
        if (charList.size() == 0 || charList.size() == 1) {
            return true;
        }

        if (cc.equalChars((char) charList.removeFirst(), (char) charList.removeLast())) {
            return isPalindromeHelper2(charList, cc);
        } else {
            return false;
        }
    }
}
