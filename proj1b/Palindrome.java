public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> palindromeDeque = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            palindromeDeque.addLast(word.charAt(i));
        }
        return palindromeDeque;
    }

    public boolean isPalindrome(String word) {
        return isPalindromeHelper(wordToDeque(word));
    }

    public boolean isPalindromeHelper(Deque<Character> p) {
        if (p.size() <= 1) {
            return true;
        }
        if (p.removeLast() != p.removeFirst()) {
            return false;
        } else {
            return isPalindromeHelper(p);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        CharacterComparator offByOne = new OffByOne();
        return isPalindromeHelper(wordToDeque(word), offByOne);
    }

    public boolean isPalindromeHelper(Deque<Character> p,
                                      CharacterComparator cc) {
        if (p.size() <= 1) {
            return true;
        }
        if (!cc.equalChars(p.removeFirst(), p.removeLast())) {
            return false;
        } else {
            return isPalindromeHelper(p, cc);
        }
    }

}
