package ModularArithmetic;
import java.io.*;

/* 
    We are given two arrays num[0..k-1] and rem[0..k-1]. In num[0..k-1], every pair is coprime 
    (gcd for every pair is 1). We need to find minimum positive number x such that:

     x % num[0]    =  rem[0], 
     x % num[1]    =  rem[1], 
     .......................
     x % num[k-1]  =  rem[k-1] 

    Basically, we are given k numbers which are pairwise coprime, and given remainders of 
    these numbers when an unknown number x is divided by them. We need to find the minimum 
    possible value of x that produces given remainders.

*/

public class Chinese_remainder_theorem {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k  = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        String[] str1 = br.readLine().split(" ");
        int num[] = new int[k];
        int rem[] = new int[k];
        for(int i=0;i<k;i++){
            num[i] = Integer.parseInt(str[i]);
            rem[i] = Integer.parseInt(str1[i]);
        }
        System.out.println(minX(num,rem,k));
    }

    private static int minX(int num[],int rem[],int k) {
        int x = 1;
        while(true){
            int j;
            for(j=0;j<k;j++){
                if(x % num[j] != rem[j]){
                    break;
                }
            }
            if(j==k){
                return x;
            }
            x++;

            if(x > 1e9) return -1;
        }
    }
}
