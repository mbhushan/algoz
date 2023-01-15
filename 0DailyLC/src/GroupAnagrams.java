import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String [] strings = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>>  res = ga.groupAnagrams(strings);

        for (List<String> r: res) {
            System.out.println(r);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) return null;
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String st: strs) {
            char [] ch = st.toCharArray();
            Arrays.sort(ch);
            String sortedST = new String(ch);
            List<String> list = map.getOrDefault(sortedST, new ArrayList<String>());
            list.add(st);
            map.put(sortedST, list);
        }

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }

}
