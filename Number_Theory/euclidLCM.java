package Number_Theory;
import java.io.*;

public class euclidLCM {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        System.out.println(lcm(a,b));
    }

    private static int lcm(int a, int b) {
        
        return a / gcd(a,b) * b; // LCM = a / gcd of (a,b) then * b;
        
    }

    private static int gcd(int a, int b) {
        if(b==0){
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
}
