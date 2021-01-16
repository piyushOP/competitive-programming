package Game_Theory;
import java.util.*;
/*
    Q.) piles are there and you can pick upto 3 stones.
    ans = zor of(grundy(pile1) ^ grundy(pile2)......^ grundy(n-1))
*/

public class sprague_grundy_theorem {
    public static void main(String[] args) {
        int piles[] = new int[]{1,2,4};
        int stoneLimit = 3;
        Arrays.sort(piles); //To find the maximum no. whose grundy will find for dp;
        int grunDP[] = new int[piles[piles.length-1]+1];

        for(int i=0;i<grunDP.length;i++){
            if(i <= stoneLimit){
                grunDP[i] = i;
            }else{
                grunDP[i] = grunDP[i - (stoneLimit+1)];
            }
        }

        int zor = piles[0];
        for(int i=1;i<piles.length;i++){
            zor ^= grunDP[piles[i]];
        }

        if(zor == 0){
            System.out.println("p2 win");
        }else{
            System.out.println("p1 win");
        }
    }    
}
