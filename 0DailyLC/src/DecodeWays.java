public class DecodeWays {
    public String alph = "abcdefghijklmnoqrstuvwxyz";
    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
          String S = "1234";
        // String S = "226";
        System.out.println(dw.numDecodings(S));
        System.out.println(dw.numDecodings("11106"));
    }
    public int numDecodings(String s) {
        return ways(s.toCharArray(), 0);
    }

    private int ways(char [] s, int index) {
        if (index == s.length || index == s.length-1) return 1;
        if (s[index] == '0') return 0;

        int ans = ways(s, index+1);
        int n = (s[index]-'0')*10 + (s[index+1]-'0');
        if (n >= 1 && n <= 26) {
            ans += ways(s, index+2);
        }
        return ans;
    }



}
