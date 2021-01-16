package ModularArithmetic;
import java.io.*;

/* 
    Given a natural number, calculate sum of all its proper divisors. 
    A proper divisor of a natural number is the divisor that is strictly less than the number.
    For example, number 20 has 5 proper divisors: 1, 2, 4, 5, 10, and 
    the divisor sum is: 1 + 2 + 4 + 5 + 10 = 22.

*/

public class Sum_of_Divisors{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        System.out.println(divisorSum(n));


    }

    private static int divisorSum(int num) {
        int ans = 0;

        // find all divisors which divides 'num'
        for(int i = 2;i*i<=num;i++){

            // if 'i' is divisor of 'num' 
            if(num % i==0){

                // If both divisor are same then add only once,otherwise add both of them
                // Ex :- num = 36 and 2 divides 36 at 18,so 2 and 18 both are divisors but they
                // are not same so we add both of them. 6 divides 36 at 6 but here both divisors
                // are same so we add this only once.
                if(i == (num/i)){
                    ans += i;
                }else{
                    ans += i + (num/i);
                }
            }
        }

        // Add 1 to the result as 1 is also a divisor.  
        return ans + 1;
    }
}
