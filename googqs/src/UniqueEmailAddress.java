import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 https://leetcode.com/explore/interview/card/google/67/sql-2/3044/
 */
public class UniqueEmailAddress {
    public static void main(String[] args) {
        UniqueEmailAddress obj = new UniqueEmailAddress();
        String [] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println("unique emails: " + obj.numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length < 1) {
            return 0;
        }
        Map<String, Set<String>> map = new HashMap<>();
        int count = 0;
        for (String email: emails) {
            String [] tokens = email.split("@");
            String localName = getLocalName(tokens[0]);
            String domain = tokens[1];
            Set<String> names = map.getOrDefault(domain, new HashSet<>());
            names.add(localName);
            map.put(domain, names);
        }
        for (Map.Entry<String, Set<String>> entry: map.entrySet()) {
            count += entry.getValue().size();
        }
        return count;
    }

    private String getLocalName(String st) {
        StringBuffer sb = new StringBuffer();

        for (char ch: st.toCharArray()) {
            if (ch == '+') {
                break;
            } else if (ch == '.') {
                continue;
            }
            sb.append(Character.toLowerCase(ch));
        }
        return sb.toString();
    }

    public int numUniqueEmails1(String[] emails) {
        Set<String> normalized = new HashSet<>(); // used to save simplified email address, cost O(n) sapce.
        for (String email : emails) {
            String[] parts = email.split("@"); // split into local and domain parts.
            String[] local = parts[0].split("\\+"); // split local by '+'.
            normalized.add(local[0].replace(".", "") + "@" + parts[1]); // remove all '.', and concatenate '@' and domain.
        }
        return normalized.size();
    }
}
