public class RevStr {
    public static void main(String[] args) {

    }

    public void reverseString(char[] s) {
        int i=0;
        int j = s.length-1;
        while (i < j) {
            ++i;
            --j;
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
        }

    }
}
