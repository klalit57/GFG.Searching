package GFG;

public class TwoPointerApproach {
    public static void pairOfGivenSumUnsorted1(int [] arr, int sum){  //MyCode two point approach
        int first=0;
        int second=1;

            if(arr.length==1){
                return;
            }
            while(first<second){
                if(arr[first]+arr[second]==sum){
                    System.out.println("Index: "+first +" and "+second);
                    return;
                }
                if( (arr[first]+arr[second]!=sum) && (second < arr.length-1)){
                    second++;
                }
                else if( (arr[first]+arr[second]!=sum) && (second==arr.length-1) ){
                    first++;
                    second=Math.min(first+1,arr.length-1);
                }
            }
        System.out.println("No Pair found");
    }
    public static void pairOfGivenSumUnsorted2(int [] arr , int sum){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==sum){
                    System.out.println("Index: "+i+ " and "+j);
                    return;
                }
            }
        }
        System.out.println("No Pair found");
    }

    public static void pairOfGivenSumSorted1(int [] arr, int sum){  //MyCode two point approach Sorted
        int first=0;
        int second=1;

        if(arr.length==1){
            return;
        }
        while(first<second){
            if(arr[first]+arr[second]==sum){
                System.out.println("Index: "+first +" and "+second);
                return;
            }
            if( (arr[first]+arr[second]<sum) && (second < arr.length-1)){
                second++;
            }
            else if( (arr[first]+arr[second]>sum) || (second==arr.length-1) ){
                first++;
                second=Math.min(first+1,arr.length-1);
            }
        }
        System.out.println("No Pair found");
    }

    public static void pairOfGivenSumSorted2(int [] arr, int sum){  //GFG
        int first=0;
        int last=arr.length-1;

        if(arr.length==1){
            return;
        }

        while(first<last){
            if(arr[first]+arr[last]==sum){
                System.out.println("Index: "+first +" and "+last);
                return;
            }
            if( (arr[first]+arr[last] >sum)){
                last--;
            }
            else if( arr[first]+arr[last]<sum){
                first++;
            }
        }
        System.out.println("No Pair found");
    }

    public static boolean tripletOfGivenSumSorted1(int [] arr, int sum){  //GFG
        int last=arr.length-1;

        for(int i=0;i<last;i++){
            if(forTripletPair(arr,sum-arr[i],i+1,last)==true){
                return true;
            }
        }
        return false;
    }

    public static boolean forTripletPair(int [] arr, int sum,int first , int last){  //GFG

        while(first<last){
            if(arr[first]+arr[last]==sum){
                return true;
            }
            if( (arr[first]+arr[last] >sum)){
                last--;
            }
            else if( arr[first]+arr[last]<sum){
                first++;
            }
        }
        return false;
    }


    public static void main(String [] args){
        int [] arr1 = {3,5,9,2,8,10,11};
        int [] arr2 = {8,4,6};
        pairOfGivenSumUnsorted1(arr1,17);
        pairOfGivenSumUnsorted1(arr2,11);

        pairOfGivenSumUnsorted2(arr1,17);
        pairOfGivenSumUnsorted2(arr2,11);

        int [] arr3 = {2,5,8,12,30};
        int [] arr4 = {3,8,13,18};

        pairOfGivenSumSorted1(arr3,17);
        pairOfGivenSumSorted1(arr4,14);

        pairOfGivenSumSorted2(arr3,17);
        pairOfGivenSumSorted2(arr4,14);

        int [] arr5 = {2,3,4,8,9,20,40};
        int [] arr6 = {3,8,13,18};

        System.out.println(tripletOfGivenSumSorted1(arr5,32));
    }
}
