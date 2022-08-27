package GFG;

public class LinearSearch {
    public static int linearSearch(int [] arr, int x ){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String [] args){
        int [] arr= {10,20,30,40,50,60};
        System.out.println(linearSearch(arr ,50));
        System.out.println(linearSearch(arr ,70));
    }
}
