package ModularArithmetic;
import java.io.*;
import java.util.*;

/* 
    Given a positive integer n, we have to find the total number of divisors for n.
    ----------------------------------------------------------------------------------------
    Input : n = 25
    Output : 3
    Divisors are 1, 5 and 25.
    -----------------------------------------------------------------------------------------
    Input : n = 24
    Output : 8
    Divisors are 1, 2, 3, 4, 6, 8
    12 and 24.
    -----------------------------------------------------------------------------------------
*/

public class No_of_Divisors {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        System.out.println(divisors(n));
    }

    private static int divisors(int n) {

        // sieve method for prime calculation
        boolean prime[] = new boolean[n+1];
        Arrays.fill(prime,true);
        for(int i=2;i*i<=n;i++){
            if(prime[i]==true){
                for(int j=i*i;j<=n;j+=i){
                    prime[j] = false;
                }
            }
        }

        // Traversing through all prime numbers 
        int ans = 1;
        for(int i=2;i<=n;i++){
            if(prime[i]==true){

     // calculate number of divisor with formula total div = (p1+1) * (p2+1) *.....* (pn+1) 
                int count = 0;
                if(n%i==0){
                    while(n%i==0){
                        n = n/i;
                        count++;
                    }
                    ans = ans * (count + 1);
                }
            }
        }

        return ans;
    }
}
