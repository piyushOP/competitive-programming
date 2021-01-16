package Game_Theory;
/*
    Mex--> Minimum excludent set.
    Mex{0,1,3} - smallest non-negative value not present in set, in this Mex is 2.
    Mex{1,2,3} = Mex is 0;

    Grundy of n = suppose i will go upto n-1 & n-2,
    so the grundy of (n) = Mex(grundy(n-1),grundy(n-2))

    Q.) grundy of(n) and go upto 3.
*/
public class grundyNum{
    public static void main(String[] args) {
        int n = 3;
        System.out.println(grundy(n));
    }

    public static int grundy(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 3;
        }else{
            return (n%4);
        }
    }
}
