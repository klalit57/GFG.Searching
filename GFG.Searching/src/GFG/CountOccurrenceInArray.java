package GFG;

public class CountOccurrenceInArray {
    public static int countOccurrence1(int [] arr,int x){ //MyCode Naive
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                count++;
            }
        }
        return count;
    }
    public static int countOccurrence(int [] arr,int x){
        int first=firstOccurrence(arr,x);
        if(first==-1){
            return 0;
        }
        return (lastOccurrence(arr,x)-first+1);
    }

    public static int firstOccurrence(int [] arr,int x){ //MyCode iterative

        int low=0;
        int high=0;
        if(low>high){
            return -1;
        }
        while(low<high){
            int mid=(low+high)/2;
            if(x<arr[mid]){
                high=mid-1;
            }
            else if(arr[mid]<x){
                low=mid+1;
            }
            else{
                if(mid==0 || arr[mid]!=arr[mid-1]){
                  return mid;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return -1;
    }

    public static int lastOccurrence(int [] arr, int x ) {  //GFG Iterative
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x > arr[mid]) {
                low=mid + 1;
            } else if (x < arr[mid]) {
                high=mid - 1;
            } else {
                if (mid == arr.length-1 || arr[mid + 1] != arr[mid]) {
                    return mid;
                } else {
                    low=mid + 1;
                }
            }
        }
        return -1;
    }
    public static void main(String [] args){
        int [] arr= {10,20,20,20,30,30};

        System.out.println(countOccurrence1(arr,5));
    }
}
