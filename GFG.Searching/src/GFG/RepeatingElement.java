package GFG;

public class RepeatingElement{
    public static  int repeatingElement1(int [] arr){   //MyCode
        int [] temp= new int[arr.length];
       for(int i=0;i<arr.length;i++){
           temp[arr[i]]++;
       }
        for(int i=0;i<arr.length;i++){
            if(temp[i]>1){
                return i;
            }
        }
        return -1;
    }

    public static int repeatingElement2(int [] arr){  //GFG Super Naive
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public static int repeatingElement3(int [] arr){   //GFG efficient code
        int slow = arr[0], fast = arr[0];

        do{
            slow = arr[slow];
            fast = arr[arr[fast]];

        }while(slow != fast);

        slow = arr[0];

        while(slow != fast)
        {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }


    public static void main(String [] args){
       int [] arr1={0,2,1,3,2,2};
       int [] arr2={1,2,3,0,3,4,5};
       int [] arr3={0,0};

       System.out.println(repeatingElement1(arr1));
        System.out.println(repeatingElement1(arr2));
        System.out.println(repeatingElement1(arr3));

        System.out.println(repeatingElement2(arr1));
        System.out.println(repeatingElement2(arr2));
        System.out.println(repeatingElement2(arr3));


        int arr4[] = {1, 3, 2, 4, 6, 5, 7, 3};

        System.out.println(repeatingElement3(arr4));

    }
}
