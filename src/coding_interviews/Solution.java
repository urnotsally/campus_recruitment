package coding_interviews;


public class Solution {

    public static boolean Find(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            if(array[0].length==0){
                return false;
            }
            if(target<array[i][0]){
                return false;
            }
            if(target>array[i][array[0].length-1]){
                continue;
            }
            if(BinarySearch(array[i],target)){
                return true;
            }
        }
        return false;
    }

    static boolean BinarySearch(int[] num ,int n){
        int left=0,right=num.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(num[mid]==n){
                return true;
            }else if(n<num[mid]){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int a=7;
        Find(a,array);
    }
}
