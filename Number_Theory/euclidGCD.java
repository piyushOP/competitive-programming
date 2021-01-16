package Number_Theory;

import java.io.*;

class euclidGCD{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        

        System.out.println(gcd(a,b));

    }

    private static int  gcd(int a, int b) {
        if(b==0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }
}