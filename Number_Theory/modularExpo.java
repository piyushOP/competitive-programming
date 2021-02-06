package Number_Theory;
import java.io.*;

// Given three numbers x, y and p, compute (x^y) % p. 

public class modularExpo {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a  = Integer.parseInt(br.readLine());
        int n  = Integer.parseInt(br.readLine());
        int mod = Integer.parseInt(br.readLine());
        System.out.println(exponentMod(a,n,mod));

    }

    public static int exponentMod(int a,int n, int mod)  
    {  
          
    // Base cases  
        if (a == 0)  
            return 0;  
        if (n == 0)  
            return 1;  
        
        // If B is even  
        long y;  
        if (n % 2 == 0) 
        {  
            y = exponentMod(a*a, n / 2, mod);  
            y = y % mod; 
        }  
        // If B is odd n
        else 
        {  
            
            y = (a * exponentMod(a, n - 1,mod) % mod) % mod;  
        }  
        
        return (int)((y + mod) % mod);  
    }

    private static long pow(long a, long n, long mod) {
        long res = 1;
        a %= mod;
        while(n > 0){
          if(n % 2 !=0){
            res = (res*a) % mod;
          }
    
          n >>= 1;
          a = (a*a) % mod;
        }
    
        return res;
      }
}
