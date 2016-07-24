import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
 
public class Main {
    static int[] primes = new int[] {
        2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,
        101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,
        211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,
        307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,
        401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,
        503,509,521,523,541,547,557,563,569,571,577,587,593,599,
        601,607,613,617,619,631,641,643,647,653,659,661,673,677,683,691,701,709};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            int k = Integer.parseInt(br.readLine());
            int kk = k;
            int lim = (int)Math.sqrt(k);
            int divisors = 1;
            for (int p=0; primes[p]<=lim; p++) {
                int pk = 1;
                while (k%primes[p]==0) {
                    pk++;
                    k/=primes[p];
                }
                if (pk != 1) {
                    divisors *= pk;
                }
            }
            if (k>1) {
                divisors *= 2;
            }
           System.out.println("Divisors--" + divisors);
            int value;
            truncated = false;
            divisors -= 2;
            if (divisors%2==0) {
                value = modpow(kk, divisors/2, 10000);
            } else {
                value = modpow(lim, divisors, 10000);
            }
            if (truncated) {
                value += 10000;
                out.println(Integer.toString(value).substring(1));
            } else {
                out.println(value);
            }
        }
        out.close();
    }
 
    static boolean truncated;
    static int modpow(long base, int exponent, int modulus) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent&1) == 1) {
                result = result*base;
                if (result>=modulus) {
                    truncated = true;
                    result = result%modulus;
                }
            }
            exponent >>= 1;
            if (exponent != 0) {
                base = base*base;
                if (base>=modulus) {
                    truncated = true;
                    base = base%modulus;
                }
            }
        }
        return (int)result;
    }
 
}