import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String [] args) {
        UniqueEmailAddress obj = new UniqueEmailAddress();
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};
        System.out.println(obj.numUniqueEmails(emails));

        String[] emails2 = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        System.out.println(obj.numUniqueEmails(emails2));
    }

    public int numUniqueEmails(String[] emails) {
        // 1. sanity checks
        // 2. parse email - split by @ char in left and right substring
        // 3. read left substring from left to right ignoring . char and stopping at either + char
        // or end of string.  store the result in leftbuf
        // 4. concatanate leftbuf and right substring  and put it in hashmap with k as string
        // and val as count;
        // 5. once we have finished processing all emails then hashmap size is the unique count of
        // unique email addresses.
        if (emails == null || emails.length < 1) return 0;

        Set<String> set = new HashSet<>();
        for (String email: emails) {
            String[] tokens = email.split("@");
            if (tokens.length != 2) {
                //log error
                continue;
            }
            StringBuffer sb = new StringBuffer();
            for (char ch: tokens[0].toCharArray()) {
                if (ch == '.') continue;
                if (ch == '+') break;
                sb.append(ch);
            }
            set.add(sb.toString() + "@" + tokens[1]);
        }

        return set.size();
    }
}
