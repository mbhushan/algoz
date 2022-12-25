public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(vp.isPalindrome(s));

    }
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() <= 1) {
            return true;
        }
        int front = 0;
        int back = s.length()-1;
        while (front < back) {
            char f = s.charAt(front);
            char b = s.charAt(back);
            if (!Character.isLetterOrDigit(f)) {
                ++front;
                continue;
            }
            if (!Character.isLetterOrDigit(b)) {
                --back;
                continue;
            }
            if (Character.toLowerCase(f) != Character.toLowerCase(b)) {
                return false;
            }
            ++front;
            --back;

        }
        return true;
    }


}
