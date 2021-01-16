package Number_Theory;
import java.io.*;

public class exponentPow {
    static int count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a  = Integer.parseInt(br.readLine());
        int n  = Integer.parseInt(br.readLine());
        System.out.println(betterPower(a,n));
        
        System.out.println(count);
    }

    // private static long pow(int a, int n) {
    //     count++;
    //     if(n==0){
    //         return 1;
    //     }else{            
    //         return a * pow(a,n-1);
    //     }
    // }

    private static long betterPower(int a,int n){
        count++;
        if(n==0){
            return 1;
        }else if(n%2 == 0){
            return betterPower(a*a,n/2);
        }else{
            return a * betterPower(a,n-1);
        }

    }
}