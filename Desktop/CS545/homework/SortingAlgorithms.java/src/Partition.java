import java.util.Arrays;

import java.util.*;

class Partition {

    public static int partition(int[] arr, int low, int high) {
        //return index of the pivot
        System.out.println(Arrays.toString(arr));
        int mid  = (low + high) / 2;
        int pivotElem = arr[mid];
        int indexOfLastElem = high;
        arr[mid] = arr[high];
        arr[high] = pivotElem;
        System.out.println(Arrays.toString(arr));
        // put pivot in the end
        while (low <= high) {
            while (low <= high && arr[low] < pivotElem ) {
                low++;
            }
            while (high >= low && arr[high] >= pivotElem) {
                high--;
            }
            System.out.println(Arrays.toString(arr));
            if ( low < high ) {// swap
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }

        System.out.println(high);
        System.out.println(low);
        // swap pivot with element at index low
        if (low > high){
            System.out.println("test");
            int temp = arr[low];
            arr[low] = pivotElem;
            arr[indexOfLastElem] = temp;
        }
        System.out.println(Arrays.toString(arr));
        return low;

    }





    public void main(String[] args) {

        //int [] arr = {1,3,5,6,4,5,2,1,0, 7};
        //System.out.println(partition(arr, 0, 8));
        //System.out.println(Arrays.toString(arr));

    }


}
