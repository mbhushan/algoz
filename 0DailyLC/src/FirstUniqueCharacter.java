public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String [] S = {
          "leetcode",
          "loveleetcode",
                "aabb"
        };
        FirstUniqueCharacter fu = new FirstUniqueCharacter();

        for (String s: S) {
            System.out.println(fu.firstUniqChar(s));
        }
    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() < 1) {
            return -1;
        }
        int [] C = new int[26];
        for (char ch: s.toCharArray()) {
            ++C[ch - 'a'];
        }
        int i=0;
        for (char ch: s.toCharArray()) {
            if (C[ch-'a'] == 1) {
                return i;
            }
            ++i;
        }
        return -1;
    }
}
