package Range_Queries;

public class Segment_Tree {
   int leftMost, rightMost;
   Segment_Tree lChild, rChild;
   int sum;
   int min;
   int max;
   int smax;

   public Segment_Tree(int leftMost, int rightMost, int arr[]) {
      this.leftMost = leftMost;
      this.rightMost = rightMost;

      if (leftMost == rightMost) {
         sum = arr[leftMost];
         min = arr[leftMost];
         max = arr[leftMost];
         smax = Integer.MIN_VALUE;
      } else {

         int mid = (leftMost + rightMost) / 2;
         lChild = new Segment_Tree(leftMost, mid, arr);
         rChild = new Segment_Tree(mid+1, rightMost, arr);
         reCal();
      }
   }

   public void reCal(){
      if(leftMost == rightMost) return;

      sum = lChild.sum + rChild.sum;
      min = Math.min(lChild.min, rChild.min);
      max = Math.max(lChild.max, rChild.max);
      smax = Math.min(Math.max(lChild.smax, rChild.max), Math.max(lChild.max, rChild.smax));
   }

   public void update(int index, int value){
      if(leftMost == rightMost){
         sum = value;
         min = value;
         max = value;
         smax = Integer.MIN_VALUE;
         return;
      } 

      if(index <= lChild.rightMost){
         lChild.update(index, value);
      }else{
         rChild.update(index, value);
      }

      reCal();

   }

   public int rangeSum(int l, int r){
      if(l>rightMost || r<leftMost){
         return 0;
      }

      if(l<=leftMost && r>= rightMost){
         return sum;
      }

      return lChild.rangeSum(l, r) + rChild.rangeSum(l, r);
   }

   public int rangeMin(int l, int r){
      if(l>rightMost || r<leftMost){
         return Integer.MAX_VALUE;
      }

      if(l<=leftMost && r>=rightMost){
         return min;
      }

      return Math.min(lChild.rangeMin(l, r), rChild.rangeMin(l, r));
   }

   public int rangeMax(int l, int r){
      if(l>rightMost || r<leftMost){
         return Integer.MIN_VALUE;
      }

      if(l<=leftMost && r>=rightMost){
         return max;
      }

      return Math.max(lChild.rangeMax(l, r), rChild.rangeMax(l, r));
   }

   public int pairSum(int l, int r){
      if(l>rightMost || r<leftMost){
         return Integer.MIN_VALUE;
      }

      if(l<=leftMost && r>=rightMost){
         return max + smax;
      }

      return Math.max(lChild.pairSum(l, r), rChild.pairSum(l, r));
   }

   public static void main (String[] args){
      int arr[] = {1,2,4,5,8,2,3,0,9,10};
      Segment_Tree tree = new Segment_Tree(0, arr.length-1, arr);

      System.out.println(tree.rangeSum(3, 7));
      System.out.println(tree.rangeMin(0, 9));
      System.out.println(tree.pairSum(4, 6));
            
   }
}
