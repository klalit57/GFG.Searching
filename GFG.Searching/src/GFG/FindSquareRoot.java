package GFG;

public class FindSquareRoot {
    public static int findRootFloor1(int x){   // gfg Naive
       int i=1;
        while(i*i<=x){
            i++;
        }
        return i-1;
    }

    public static int findRootFloor2(int x){
       int low=1;
       int high=x/2;
       int ans=-1;
       while(low<=high){
           int mid=(low+high)/2;
           int mSq=mid*mid;
           if(mSq==x){
               return mid;
           }else if(mSq>x){
               high=mid-1;
           }else{
               low=mid+1;
               ans=mid;
           }
       }
       return ans;
    }
    public static void main(String [] args){

        System.out.println(findRootFloor1(500));

        System.out.println(findRootFloor1(576));
    }

}
