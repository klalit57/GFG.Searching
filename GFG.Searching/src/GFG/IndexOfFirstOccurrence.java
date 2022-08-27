package GFG;

public class IndexOfFirstOccurrence {
    public static int indexOfFirstOccurrence1(int [] arr, int x ){  //Naive
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOfFirstOccurrence2(int [] arr, int x, int low, int high){  //My Code recursive
        if(low>high){
            return -1;
        }
        int mid= (low+high)/2;
        if(x==arr[mid]){
            while(mid!=0 && arr[mid]==arr[mid-1]){
                mid-=1;
            }
            return mid;
        }
        else if(x<arr[mid]){
            return indexOfFirstOccurrence2(arr,x,low,mid-1);
        }else{
            return indexOfFirstOccurrence2(arr,x,mid+1,high);
        }
    }

    public static int indexOfFirstOccurrence3(int [] arr, int x ){  //MyCode Iterative
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(x==arr[mid]){
                while(mid!=0 && arr[mid]==arr[mid-1]){
                    mid-=1;
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


    public static int indexOfFirstOccurrence4(int [] arr, int x, int low, int high) {  //GFG recursive
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (x > arr[mid]) {
            return indexOfFirstOccurrence4(arr, x, mid + 1, high);
        }
        else if (x < arr[mid]) {
            return indexOfFirstOccurrence4(arr, x, low, mid - 1);
        }
        else {
            if (mid == 0 || arr[mid - 1] != arr[mid]) {
                return mid;
            }
            else {
                return indexOfFirstOccurrence4(arr, x, low, mid - 1);
            }
        }
    }


    public static int indexOfFirstOccurrence5(int [] arr, int x ) {  //GFG Iterative
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x > arr[mid]) {
                low=mid + 1;
            } else if (x < arr[mid]) {
                high=mid - 1;
            } else {
                if (mid == 0 || arr[mid - 1] != arr[mid]) {
                    return mid;
                } else {
                    high=mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String [] args){
        int [] arr= {10,10,10,40,40,60};
        System.out.println(indexOfFirstOccurrence1(arr ,10));
        System.out.println(indexOfFirstOccurrence1(arr ,40));

        System.out.println(indexOfFirstOccurrence2(arr ,10,0,arr.length-1));
        System.out.println(indexOfFirstOccurrence2(arr ,40,0,arr.length-1));

        System.out.println(indexOfFirstOccurrence3(arr ,10));
        System.out.println(indexOfFirstOccurrence3(arr ,40));

        System.out.println(indexOfFirstOccurrence4(arr ,10,0,arr.length-1));
        System.out.println(indexOfFirstOccurrence4(arr ,40,0,arr.length-1));

        System.out.println(indexOfFirstOccurrence5(arr ,10));
        System.out.println(indexOfFirstOccurrence5(arr ,40));
    }
}


