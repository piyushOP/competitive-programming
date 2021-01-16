package Game_Theory;

/* Piles game : 
    p1 and p2 are playing optimally and we want to predict the winner,
    for that find NIM SUM which is equal to cummulative zor(^) of all piles and if zor is 0 then 
    p1 lose otherwise p1 wins.
    cummulative zor(^) = arr[i]^arr[i+1]^arr[i+1]........^arr[n-1];
*/
public class gameOfNim {
    public static void main(String[] args){
        int arr[] = new int[]{2,1,4};

        int zor = arr[0];
        for(int i=1;i<arr.length;i++){
            zor ^= arr[i];
        }

        if(zor==0){
            System.out.println("p2 win");
        }else{
            System.out.println("p1 wins");
        }


    }
}
