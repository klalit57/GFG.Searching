public class BinarySearchRecursive {
    public static int binarySearchRecursive1(int [] arr, int x, int low, int high){  //My Code & GFG
       if(low>high){
           return -1;
       }
        int mid= (low+high)/2;
       if(x==arr[mid]){
            return mid;
        }
        else if(x<arr[mid]){
           return binarySearchRecursive1(arr,x,low,mid-1);
        }else{
           return binarySearchRecursive1(arr,x,mid+1,high);
        }
    }
    public static void main(String [] args){
        int [] arr= {10,20,30,40,50,60,70};

        System.out.println(binarySearchRecursive1(arr ,30,0,arr.length-1));
        System.out.println(binarySearchRecursive1(arr ,80,0,arr.length-1));
    }
}
