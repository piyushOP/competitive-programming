package Game_Theory;

/*
    Max always want to make max number
    Min always want to make min number

    if both play optimally then which number they choose from array.
    Max always play first.
*/

public class MinMax_Algo {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,2,9,12,5,23,23};
        int height = log2(arr.length);
        System.out.println(minMax(0,0,true,arr,height)); //(depth,nodeIndex,MaxTurn,arr,height)
    }

    private static int minMax(int depth, int nodeIndex, boolean isMax, int[] arr, int height) {
        
        if(depth == height){
            return arr[nodeIndex];
        }

        if(isMax){
            return Math.max(minMax(depth+1,2*nodeIndex,false,arr,height),minMax(depth+1,2*nodeIndex+1,false,arr,height)); // taking Max from both the childs.
        }else{
            return Math.min(minMax(depth+1,2*nodeIndex,true,arr,height),minMax(depth+1,2*nodeIndex+1,true,arr,height)); // taking Min from both the childs.
        }
    }

    private static int log2(int length) {
        return (length==1) ? 0 : 1 + log2(length/2);
    }
}
