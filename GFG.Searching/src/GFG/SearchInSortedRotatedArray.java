package GFG;

public class SearchInSortedRotatedArray {
    public static int searchInSortedRotatedArray1(int [] arr , int x, int d){  //Naive Linear
        int l=arr.length;
        for(int i=l-d;i<l;i++){
            if(arr[i]==x){
                return i;
            }
        }
        for(int i=0;i<l-d;i++){
            if(arr[i]==x){
                return i;
            }
        }
        return -1;
    }

    public static int searchInSortedRotatedArray2(int [] arr , int x, int d){
        int l=arr.length;
        if (arr[l/2]>=arr[l-1]) {
            int res = binarySearch(arr, x, l - d, l-1);
            if (res == -1) {
                res = binarySearch(arr, x, 0, l - d - 1);
            }
            return res;
        }else{
            int res = binarySearch(arr, x, d, l - 1);
            if (res == -1) {
                res = binarySearch(arr, x, 0, l - d - 1);
            }
            return res;
        }
    }

    public static int binarySearch(int [] arr, int x,int low, int high ){  //GFG

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

    public static int searchInSortedRotatedArray3(int [] arr , int x){   //GFG efficient
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x){
                return mid;
            }
            if(arr[low]<arr[mid]){
                if(x>=arr[low] && x<arr[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            } else{
                if(x>=arr[mid] && x<arr[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String [] args){
        int [] arr = {100,200,500,1000,2000,10,20};

        System.out.println(searchInSortedRotatedArray1(arr, 500,2));

        System.out.println(searchInSortedRotatedArray2(arr, 500,2));

        System.out.println(searchInSortedRotatedArray3(arr, 500));
    }
}
