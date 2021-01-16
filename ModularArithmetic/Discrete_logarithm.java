package ModularArithmetic;
import java.io.*;

/* 
    Given three integers a, b and m. Find an integer k such that a^k==b(mod m) 
    where a and m are relatively prime. If it is not possible for any k to satisfy 
    this relation, print -1.

*/

public class Discrete_logarithm {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a  = Integer.parseInt(br.readLine());
        int b  = Integer.parseInt(br.readLine());
        int m  = Integer.parseInt(br.readLine());
        System.out.println(discreteLogarithm(a, b, m));
    }

    static int powmod(int x, int y, int p)  
    {  
    int res = 1; // Initialize result  
  
    x = x % p; // Update x if it is more than or equal to p  
  
    while (y > 0)  
    {  
        // If y is odd, multiply x with result  
        if (y % 2==1){
            res = (res*x) % p;  
        }
        // y must be even now  
        y = y/2; 
        x = (x*x) % p;  
    }  
    return res;  
    }
    
    // Function to calculate k for given a, b, m  
static int discreteLogarithm(int a, int b, int m) {  
  
    int n = (int) (Math.sqrt (m) + 1);  
  
    int[] value=new int[m];  
  
    // Store all values of a^(n*i) of LHS  
    for (int i = n; i >= 1; --i) { 
        value[ powmod (a, i * n, m) ] = i;  
    }

    for (int j = 0; j < n; ++j)  
    {  
        // Calculate (a ^ j) * b and check  
        // for collision  
        int cur = (powmod (a, j, m) * b) % m;  
  
        // If collision occurs i.e., LHS = RHS  
        if (value[cur]>0)  
        {  
            int ans = value[cur] * n - j;  
            // Check whether ans lies below m or not  
            if (ans < m)  
                return ans;  
        }  
    }  
    return -1;  
    }  
}