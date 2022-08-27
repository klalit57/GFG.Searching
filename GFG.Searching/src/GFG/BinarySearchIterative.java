package GFG;

public class BinarySearchIterative {
    public static int binarySearch1(int [] arr, int x ){  //MyCode
        int s=0;
        int e=arr.length-1;
        int curr=(s+e+1)/2;
        if(x<arr[s] || x>arr[e]){
            return -1;
        }
        while(x!=arr[curr]){
         if(x<arr[curr]){
             e=curr;
             curr=(s+e+1)/2;
         }
            if(x>arr[curr]){
                s=curr;
                curr=(s+e+1)/2;
            }
            if(x==arr[curr]){
                return curr;
            }
        }
        return curr;
    }

    public static int binarySearch2(int [] arr, int x ){  //GFG
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(x==arr[mid]){
                return mid;
            }
            else if(x<arr[mid]){
                high=mid-1;
              }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    public static void main(String [] args){
        int [] arr= {10,20,30,40,50,60,70};

        System.out.println(binarySearch2(arr ,10));
        System.out.println(binarySearch2(arr ,70));
    }
}
