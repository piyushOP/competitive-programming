package PrimeNumbers;
import java.io.*;
import java.util.*;

// Segmented_Sieve works for large numbers as it is working in segments.

public class Segmented_Seive{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        
        segmentedSeive(n);
    }

    private static void segmentedSeive(int n) {
        int limit = (int) (Math.floor(Math.sqrt(n)) + 1); // Firstly, perform simple Sieve for limited range that is sqrt of n;

        ArrayList<Integer> prime = new ArrayList<>();
        simpleSeive(limit, prime); // performing simple Sieve.

        int low = limit; // break in segments
        int high = 2*limit;  // break in segments

        while(low < n){ // Do this while low is less than n that means some segment is remaining.
            if(high >= n) high = n; // if high go out of range only happen when we are solving last segment.

            boolean [] mark = new boolean [limit+1];
            Arrays.fill(mark, true);
            
            for(int i=0;i<prime.size();i++){

                int initialLow = (int)(Math.floor(low/prime.get(i)) * prime.get(i));
                if(initialLow < low) initialLow += prime.get(i);

                for(int j=initialLow;j<high;j+=prime.get(i)){
                    mark[j - low] = false;
                }
            }

            for(int i=low;i<high;i++){
                if(mark[i-low]){
                    System.out.print(i+" ");
                }
            }

            low += limit; // update for next segment
            high += limit; // update for next segment
        }
        System.out.println();
    }

    public static void simpleSeive(int n, ArrayList<Integer> prime){
        boolean[] mark = new boolean[n+1];

        Arrays.fill(mark, true);

        for(int i=2;i*i<n;i++){
            if(mark[i]){
                for(int j=i*i;j<n;j+=i){
                    mark[j] = false;
                }
            }
        }

        for(int i=2;i<n;i++){
            if(mark[i]){
                System.out.print(i+" ");
                prime.add(i);
            }
        }
    }
}
