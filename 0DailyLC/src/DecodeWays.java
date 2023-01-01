public class DecodeWays {
    public String alph = "abcdefghijklmnoqrstuvwxyz";
    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
          String S = "1234";
        // String S = "226";
        System.out.println(dw.numDecodings(S));
        System.out.println(dw.numDecodings("11106"));
    }
    public int numDecodingsDP(String s) {
        int [] T = new int[s.length()+1];
        T[0] = 1;
        T[1] = s.charAt(0) == '0' ? 0: 1;
        for (int i=2; i<=s.length(); i++) {
            int x = s.charAt(i-2) - '0';
            int y = x*10 + (s.charAt(i-1) - '0');
            if (x >= 1 && x <= 9)
                T[i] += T[i-1];
            if (y >= 10 && y <= 26)
                T[i] += T[i-2];
        }
        return T[s.length()];
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
