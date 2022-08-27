package GFG;
import java.util.ArrayList;

public class PeakElement {
    public static ArrayList<Integer> peakElement1(int [] arr){  //MyCode
        ArrayList<Integer> list = new ArrayList<>();
        if(arr.length==1){
            list.add(arr[0]);
            return list;
        }
        for(int i=0;i<arr.length;i++){
            if(i==0 || i==arr.length-1) {
                if ((i == 0 && arr[i] > arr[i+1]) || (i == arr.length - 1 && arr[i] > arr[i-1])) {
                    list.add(arr[i]);
                }
            }
            else if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
              list.add(arr[i]);
            }
        }
        return list;
    }
    public static void printArrayList(ArrayList<Integer> list){
        for(int i=0;i< list.size();i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

    public static int peakElement2(int [] arr){  //GFG Naive
        int n=arr.length;
        if (n==1){
            return arr[0];
        }
        if(arr[0]>=arr[1]){
            return arr[0];
        }
        if(arr[n-1]>arr[n-2]){
            return arr[n-1];
        }
        for(int i=1;i<n-1;i++){
            if(arr[i]>=arr[i+1]  && arr[i]>=arr[i-1] ){
                return arr[i];
            }
        }
        return -1;
    }

    public static int peakElement3(int [] arr){  //GFG Efficient
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
              if((mid==0 || arr[mid-1]<=arr[mid]) && (mid==n-1 || arr[mid+1]<=arr[mid])){
                  return arr[mid];
              }
              if(mid>0 && arr[mid-1]>=arr[mid]){
                  high=mid-1;
              }else{
                  low=mid+1;
              }
        }
        return -1;
    }

    public static void main(String [] args){
    int [] arr= {80,70,90};

    printArrayList(peakElement1(arr));


        System.out.println(peakElement2(arr));

        System.out.println(peakElement3(arr));
    }
}
