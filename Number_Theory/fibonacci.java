package Number_Theory;
import java.io.*;

public class fibonacci {
    static int count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());


        /*Method - 1 :-

        int a = 0;
        int b = 1;
        System.out.print(a+" "+b+" ");
        for(int i=2;i<n;i++){
            int c = a + b;
            System.out.print(c+" ");
            a = b;
            b = c;
        }

        */
        int arr[] = new int [n+1];
        System.out.println(fibo(n,arr));
        System.out.println(count);
    }

    /*
    Method - 2 :- DP - memoization
    */

    private static int fibo(int n,int arr[]) {
        if(n==0 || n==1){
            return n;
        }

        if(arr[n]!=0){
            return arr[n];
        }

        count++;
        int num =  fibo(n-1,arr) + fibo(n-2,arr);
        arr[n] = num;
        return num;
        
    }

    
}