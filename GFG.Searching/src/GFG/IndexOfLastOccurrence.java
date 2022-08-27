package GFG;

public class IndexOfLastOccurrence {
    public static int indexOfLastOccurrence1(int [] arr, int x ){  //Naive
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==x) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOfLastOccurrence2(int [] arr, int x, int low, int high){  //My Code recursive
        if(low>high){
            return -1;
        }
        int mid= (low+high)/2;
        if(x==arr[mid]){
            while(mid!=arr.length-1 && arr[mid]==arr[mid+1]){
                mid+=1;
            }
            return mid;
        }
        else if(x<arr[mid]){
            return indexOfLastOccurrence2(arr,x,low,mid-1);
        }else{
            return indexOfLastOccurrence2(arr,x,mid+1,high);
        }
    }

    public static int indexOfLastOccurrence3(int [] arr, int x ){  //MyCode Iterative
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(x==arr[mid]){
                while(mid!=arr.length-1 && arr[mid]==arr[mid+1]){
                    mid+=1;
                }
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


    public static int indexOfLastOccurrence4(int [] arr, int x, int low, int high) {  //GFG recursive
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (x > arr[mid]) {
            return indexOfLastOccurrence4(arr, x, mid + 1, high);
        }
        else if (x < arr[mid]) {
            return indexOfLastOccurrence4(arr, x, low, mid - 1);
        }
        else {
            if (mid == arr.length-1 || arr[mid + 1] != arr[mid]) {
                return mid;
            }
            else {
                return indexOfLastOccurrence4(arr, x, mid+1, high);
            }
        }
    }

    public static int indexOfLastOccurrence5(int [] arr, int x ) {  //GFG Iterative
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
        int [] arr= {10,15,20,20,40,40};
        System.out.println(indexOfLastOccurrence1(arr ,10));
        System.out.println(indexOfLastOccurrence1(arr ,40));
        System.out.println(indexOfLastOccurrence1(arr ,70));

        System.out.println(indexOfLastOccurrence2(arr ,10,0,arr.length-1));
        System.out.println(indexOfLastOccurrence2(arr ,40,0,arr.length-1));
        System.out.println(indexOfLastOccurrence2(arr ,70,0,arr.length-1));

        System.out.println(indexOfLastOccurrence3(arr ,10));
        System.out.println(indexOfLastOccurrence3(arr ,40));
        System.out.println(indexOfLastOccurrence3(arr ,70));

       System.out.println(indexOfLastOccurrence4(arr ,10,0,arr.length-1));
        System.out.println(indexOfLastOccurrence4(arr ,40,0,arr.length-1));
        System.out.println(indexOfLastOccurrence4(arr ,70,0,arr.length-1));

       System.out.println(indexOfLastOccurrence5(arr ,10));
        System.out.println(indexOfLastOccurrence5(arr ,40));
        System.out.println(indexOfLastOccurrence5(arr ,70));
    }
}



