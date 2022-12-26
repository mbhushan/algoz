public class Myatoi {
    public static void main(String[] args) {
        Myatoi mi = new Myatoi();
        String[] Sarr = {
                "4193 with words",
                "   -42"
        };
        for (String s : Sarr) {
            System.out.println(mi.myAtoi(s));
        }
    }

    public int myAtoi(String s) {
        if (s.isEmpty())
            return 0;
        int i = 0;
        int sign = 1;
        int result = 0;
        while ((i < s.length()) && Character.isWhitespace(s.charAt(i)))
            ++i;

        if (i == s.length())
            return 0;
        sign = (s.charAt(i) == '-') ? -1 : 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-')
            ++i;

        while ((i < s.length()) && Character.isDigit(s.charAt(i))) {
            int digit = Character.getNumericValue(s.charAt(i));
            //check if total will be overflow after 10 times and add digit
            if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE / 10 == result
                    && Integer.MAX_VALUE % 10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + digit;

            ++i;
        }
        return result * sign;

    }
}
