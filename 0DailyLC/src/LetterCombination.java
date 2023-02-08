import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void main(String [] args) {
       LetterCombination lc = new LetterCombination();
       String digits = "23";
       List<String> result = lc.letterCombinations(digits);
       for (String s: result) {
           System.out.print(s + " ");
       }
        System.out.println();
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() < 1) return result;
        String prefix = "";
        int offset = 0;
        combination(prefix, digits, offset, result);
        return result;
    }

    private void combination(String prefix, String digits, int offset, List<String> result) {
        if (offset >= digits.length()) {
            result.add(prefix);
            return;
        }
        String letters = KEYS[digits.charAt(offset) - '0'];
        for (int i=0; i<letters.length(); i++) {
            combination(prefix+letters.charAt(i), digits, offset+1, result);
        }
    }
}
