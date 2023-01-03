public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(10));
    }

    public int countPrimes(int n) {
        boolean [] notPrime = new boolean[n];
        int count = 0;
        for (int i=2; i<n; i++) {
            if (!notPrime[i]) {
                ++count;
                for (int j=2; j*i < n; j++) {
                    notPrime[j*i] = true;
                }
            }
        }
        return count;
    }
}
