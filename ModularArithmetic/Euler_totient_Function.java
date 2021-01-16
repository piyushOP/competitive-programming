package ModularArithmetic;
import java.io.*;

/* Euler’s Totient function Φ(n) for an input n is the count of numbers in {1, 2, 3, …, n} 
    that are relatively prime to n, i.e., the numbers whose GCD (Greatest Common Divisor) with 
    n is 1.

*/

public class Euler_totient_Function {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        System.out.println("Φ of "+n+" is : "+phi(n));

    }

    private static int phi(int n) {
        int count = 1;
        for(int i=2 ; i<=n;i++){
            if(gcd(i,n)==1){
                count++;
            }
        }
        return count;
    }

    private static int gcd(int a, int b) {
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
}