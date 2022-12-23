import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        System.out.println(va.isAnagram("anagram", "nagaram"));
        System.out.println(va.isAnagram("rat", "car"));
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char [] s1 = s.toCharArray();
        char [] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        int len = s.length();
        int i=0;
        while ((i < len) && (s1[i] == t1[i])){
            ++i;
        }
        return i == len;

    }
}
