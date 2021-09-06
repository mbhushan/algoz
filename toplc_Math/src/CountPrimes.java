import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 https://leetcode.com/explore/featured/card/top-interview-questions-easy/102/math/744/
 */

public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        for (int i=1; i<=20; i++) {
            int p = cp.countPrimes(i);
            System.out.println("i: " + i + "; p: " + p);
            //System.out.println("i: " + i + "; is-prime: " + cp.isPrime(i));
        }
        //System.out.println("i: " + 9 + "; is-prime: " + cp.isPrime(9));
    }

    public int countPrimes(int n) {
       boolean [] notPrime = new boolean[n];
       int count = 0;
       for (int i=2; i<n; i++) {
           if (!notPrime[i]) {
               ++count;
               for (int j=2; j*i < n; j++) {
                   notPrime[i*j] = true;
               }
           }
       }
       return count;
    }


}
