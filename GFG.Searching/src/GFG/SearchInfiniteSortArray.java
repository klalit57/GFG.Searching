package GFG;

public class SearchInfiniteSortArray {
    public static int searchInInfinite1(int [] arr, int x){  // GFG Naive
         int i=0;
         while(true){
             if(arr[i]==x){
                 return i;
             }
             if(arr[i]>x){
                 return -1;
             }
             i++;
         }
    }

    public static int searchInInfinite2(int [] arr, int x){  // MyCode
        int i=1;
        int high=0;
        int low=0;
        if(arr[0]==x){
            return 0;
        }
        while(true){
            if(arr[i]==x){
                return i;
            }
            else if(arr[i]<x){
                low=i;
                i =i* 2;
            }else {
                high=i;
                break;
            }
        }
        return binarySearch(arr,x,low+1,high-1);
    }

    public static int binarySearch(int [] arr, int x , int low , int high){  //GFG
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

    public static int searchInInfinite3(int [] arr, int x){  // GFG Efficient
        if(arr[0]==x){
            return 0;
        }
        int i=1;
        while(arr[i]<x){
                i =i* 2;
            }
        if(arr[i]==x){
            return i;
        }
        return binarySearch(arr,x,(i/2)+1,i-1);
    }

    public static void main(String [] args){
        int [] arr= {10,15,20,20,40,40,50,80,90,100,110,120};

        System.out.println(searchInInfinite2(arr,80));

        System.out.println(searchInInfinite3(arr,80));
    }
}
