import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz();
        List<String> list = fb.fizzBuzz(15);
        System.out.println(list);
    }
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        String fiz = "fizz";
        String buz = "buzz";
        for (int i=1; i<=n; i++) {
            int fizz = i%3 == 0? 1: 0;
            int buzz = i%5 == 0? 2: 0;
            switch (fizz+buzz) {
                case 1:
                    list.add(fiz);
                    break;
                case 2:
                    list.add(buz);
                    break;
                case 3:
                    list.add(fiz + buz);
                    break;
                default:
                    list.add(String.valueOf(i));
                    break;
            }
        }
        return list;
    }
}
