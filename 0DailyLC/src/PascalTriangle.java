import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        System.out.println(pt.generate(6));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allrows = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i=1; i<= numRows; i++) {
            row.add(0, 1);
            for (int j=1; j<row.size()-1; j++) {
                row.set(j, row.get(j)+row.get(j+1));
            }
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;

    }
}
