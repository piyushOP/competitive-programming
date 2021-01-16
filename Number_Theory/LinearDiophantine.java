package Number_Theory;
import java.io.*;

/*
    Linear Diophantine is used to find if :-
    ax + by = c
    This equation statisfy or Not........... 
*/

public class LinearDiophantine {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a  = Integer.parseInt(br.readLine());
        int b  = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        System.out.println(c % gcd(a,b) == 0);
    }

    private static int gcd(int a, int b) {
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
}