package Number_Theory;
import java.util.*;

/*
    ax + by = gcd(a,b);
    find x and y ?
    ==> gcd(a,b) = gcd(b,a%b);
    put a = b & b = a%b - int equation.
    Here, a%b = a - (a/b) * b;
    x = y;
    y = x - (a/b) * y;   

    base case is always x = 1 & y = 0.
*/

public class extendedEuclid {
    static int x = 0;
    static int y = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        exEuclid(a,b);
        System.out.println("x : "+x);
        System.out.println("y : "+y);
        sc.close();
    }

    private static void exEuclid(int a, int b) {
        if(b==0){
            x = 1;
            y = 0;
            return;
        }

        exEuclid(b, a%b);
        int cX = y;
        int cY = x - (a/b) * y;

        x = cX;
        y = cY;
    }
}
