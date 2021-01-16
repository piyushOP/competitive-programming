package PrimeNumbers;
import java.io.*;
import java.util.*;

public class SieveofEratosthenes {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        printPrime(n);
    }

    private static void printPrime(int n){
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime,true);
        for(int i=2;i*i<=n;i++){
            if(prime[i]==true){
                for(int j = i*i ; j<=n ; j+=i){
                    prime[j] = false;
                }
            }
        }

        for(int i=2;i<=n;i++){
            if(prime[i]){
                System.out.print(i+" ");
            }
        }
    }
}
