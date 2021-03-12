import java.util.Arrays;

public class SoritngAlgorithm {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int indexOfMin = i;
            // search for min from index = i to length
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[indexOfMin] > arr[j]) {
                    indexOfMin = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[indexOfMin];
            arr[indexOfMin] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int curr;
        int j;
        for (int i = 1; i < arr.length; i++) {
            curr = arr[i];
            // Compares with elements of the sorted list, starting at i-1;
            j = i - 1;

            while (j >= 0 && curr < arr[j]) {
                arr[j + 1] = arr[j]; // shift elements to make space for curr
                j--;
            }
            arr[j + 1] = curr; // place curr
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * public static int[] merge(int[] arr1, int[] arr2) {
     * // Fill in code
     * // Assuming arr1 and arr2 are both sorted
     * // Assuming we need to copy duplicates
     * int i = 0;
     * int j = 0;
     * int k = 0;
     * int[]temp = new int[arr1.length + arr2.length];
     * while (i < arr1.length && j < arr2.length) {
     * if (arr1[i] <= arr2[j]) {
     * temp[k++] = arr1[i++];
     * } else {
     * temp[k++] = arr2[j++];
     * }
     * }
     * while (i < arr1.length) { // run out of element in arr2
     * temp[k++] = arr1[i++];
     * }
     * while (j < arr2.length) { // run out of element in arr1
     * temp[k++] = arr2[j++];
     * }
     * return temp;
     * }
     */


    public static int[] merge(int[] arr, int[] temp, int low, int high) {

        int mid = (low + high) / 2;
        // first sublist starts at low and ends at mid
        // second sublist starts at mid + 1 end at high
        int i = low;
        int j = mid + 1;
        int k = low;

        while (k <= high) {
            if (i > mid) {
                temp[k++] = arr[i++]; // same as temp[k] = arr[i]; k++; i++;
            } else if (j > high) {
                temp[k++] = arr[i++];
            }
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        return temp;
    }

    /** --- Not  covered in cs245 -----------
     * Sort a given array using shell sort and n/2, n/4, n/8 etc increments. The
     * code is modified from the code of Prof. Galles.
     *
     public static void shellSort(int[] arr) {
     if (arr == null)
     return;
     int n = arr.length;
     int increment, offset;
     for (increment = n / 2; increment > 0; increment = increment / 2)
     for (offset = 0; offset < increment; offset++)
     insertionSort(arr, offset, increment);
     }*/

    /**
     * Another version of the insertion sort that sorts a sublist of a given
     * list. Used in Shell Sort. Takes an offset (the first element of the list
     * will be at arr[offset]) and increment (the gap between the elements of
     * the list)
     * <p>
     * public static void insertionSort(int[] arr, int offset, int increment) {
     * if (arr == null)
     * return;
     * int i, j;
     * int n = arr.length;
     * for (i = offset + increment; i < n; i = i + increment) {
     * int curr = arr[i];
     * j = i - increment;
     * while (j >= 0 && arr[j] > curr) {
     * arr[j + increment] = arr[j];
     * j = j - increment;
     * }
     * arr[j + increment] = curr;
     * }
     * }
     */


    public static int[] merge2(int[] arr1, int[] arr2) {

        int[] temp = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (k <= arr1.length + arr2.length) {
            if (i > arr1.length) {// ran out of elements in the i list
                temp[k] = arr2[j];
                k++;
                j++;
            } else if (j > arr2.length) {// ran out of elements in the j list
                temp[k] = arr1[i];
                k++;
                i++;
            } else if (arr1[i] < arr2[j]) { // place arr[i] in temp, move i
                temp[k] = arr1[i];
                k++;
                i++;
            } else {
                temp[k] = arr2[j]; // place arr[j] in temp, move j
                k++;
                j++;
            }
        }
        return temp;
    }

    /** public method for mergeSort - called from outside of the class */
    //public static void mergeSort(int[] arr) {
    //int[] temp = new int[arr.length];
    //mergeSort(arr, temp, 0, arr.length - 1);
    //}

    /**
     * A private mergeSort method - takes an array, a temporary array, and the
     * indices that specify what part of the list we are working with (we need
     * to sort the part from low to high)
     *
     * @param arr
     * @param temp
     * @param low
     * @param high
     */
    private static void mergeSort(int[] arr, int[] temp, int low, int high) {
        if (low >= high)
            return;
        // divide in half
        int mid = (low + high) / 2;
        mergeSort(arr, temp, low, mid);
        //System.out.println(Arrays.toString(arr));
        mergeSort(arr, temp, mid + 1, high);
        //System.out.println(Arrays.toString(arr));


        merge(arr, temp, low, mid, high); // merge two sorted halves into one
        // sorted list
    }

    /**
     * Merge two sorted sublists together, one that goes from low to mid another
     * goes from mid+1 to high. Uses a temporary array.
     *
     * @param arr
     * @param temp
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        int k = low;
        int i = low;
        int j = mid + 1;
        while (k <= high) {
            if (i > mid) {// ran out of elements in the i sublist
                temp[k] = arr[j];
                k++;
                j++;
            } else if (j > high) {// ran out of elements in the j sublist
                temp[k] = arr[i];
                k++;
                i++;
            } else if (arr[i] < arr[j]) { // place arr[i] in temp, move i
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j]; // place arr[j] in temp, move j
                k++;
                j++;
            }
        }
        // copy the result from temp back to arr
        for (k = low; k <= high; k++)
            arr[k] = temp[k];
        System.out.println(Arrays.toString(arr));
    }

    public static void shakerSort(Comparable[] array, int lowindex, int highindex, boolean reversed) {
        if (array == null) {
            return;
        }
        int mid = (lowindex + highindex) / 2;
        if (!reversed) {
            for (int i = lowindex; i <= mid; i++) {
                for (int j = i + 1; j <= highindex; j++) {

                    if (array[j].compareTo(array[j - 1]) < 0) {
                        Comparable curr = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = curr;
                    }
                }
                for (int k = highindex - 1; k > i; k--) {
                    if (array[k - 1].compareTo(array[k]) > 0) {
                        Comparable curr = array[k];
                        array[k] = array[k - 1];
                        array[k - 1] = curr;
                    }
                }
            }
        } else {
            for (int i = lowindex; i <= mid; i++) {
                for (int j = i + 1; j <= highindex; j++) {

                    if (array[j].compareTo(array[j - 1]) > 0) {
                        Comparable curr = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = curr;
                    }
                }
                for (int k = highindex - 1; k > i; k--) {
                    if (array[k - 1].compareTo(array[k]) < 0) {
                        Comparable curr = array[k];
                        array[k] = array[k - 1];
                        array[k - 1] = curr;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static String reverse(String s) {
        if (s.length() == 0) {
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }

    public static String convertDecimalToBinary(int n, String s) {
        int num = n / 2;
        int mod = n % 2;

        if (num == 0) {
            return mod + s;
        }
        return convertDecimalToBinary(num, mod + s);
    }


    public static String sortAndFindWinner(String[] votes) {
        // FILL IN CODE
        int i = 0;
        int j = votes.length - 1;
        String temp;
        int max;

        while (i  <= j) {
            while (i <= j && votes[i].compareTo("B") < 0) {
                i++;
            }
            while (i <= j && (votes[j].compareTo("B")) >= 0) {
                j--;
            }

            if (i < j) {
                temp = votes[i];
                votes[i] = votes[j];
                votes[j] = temp;
                i++;
                j--;
            }
        }

        max = i - 1;
        j = votes.length - 1;
        while (i  <= j) {
            while (i <= j && votes[i].compareTo("C") < 0) {
                i++;
            }
            while (i <= j && (votes[j].compareTo("C")) >= 0) {
                j--;
            }

            if (i < j) {
                temp = votes[i];
                votes[i] = votes[j];
                votes[j] = temp;
                i++;
                j--;
            }
        }
        System.out.println(Arrays.toString(votes));

        if ( 1.0 * max / votes.length > 0.4) {
            return "A";
        } else if (1.0 * (i - max) / votes.length * 1.0 > 0.4) {
            return "B";
        } else {
            return "c";
        }
    }


    /**
     * Quick sort implementation. Uses partition as a helper method.
     * @param arr array of integers
     * @param low index of the first element of the sub-array to sort
     * @param high index of the last element of the sub-array to sort
     */
    private static void quickSort(int arr[], int low, int high) {
        int indexOfPivot;
        if (low <= high) {
            indexOfPivot = partition(arr, low, high); // the index of pivot element
            System.out.println("Pivot: " + arr[indexOfPivot]);
            System.out.println(Arrays.toString(arr));
            quickSort(arr, low, indexOfPivot - 1);
            quickSort(arr, indexOfPivot + 1, high);
        }
    }

    /**
     * Helper method for the quick sort. Rearranges the array so that it
     * first has elements < pivot, then pivot, and then elements >= pivot.
     * Chooses the middle element as the pivot.
     * @param arr array
     * @param low index of the first element of the sub-array
     * @param high index of the last element of the sub-array
     * @return index of the pivot after partition
     */
    public static int partition(int arr[], int low, int high) {
        int mid = (low + high) / 2;
        int pivotElem = arr[mid];

        // Swap pivot with the element at the last index
        int tmp = arr[high];
        arr[high] = pivotElem;
        arr[mid] = tmp;

        int i = low;
        int j = high - 1;
        while (i <= j) {
            while ( (arr[i] < pivotElem))
                i++;

            while ((j >= low) && (arr[j] >= pivotElem))
                j--;

            if (i > j)
                break;
            else { // swap elements at indices i and j
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        } // while
        if (i > j) {
            // swap arr[i] and last elem
            tmp = arr[i];
            arr[i] = arr[high];
            arr[high] = tmp;
        }
        return i;
    }

    public static void main(String[] args) {
        //Integer[] arr = new Integer[]{3, 13, 4, 2, 6, 5, 5, 1, 7, 11, 0};
        //SoritngAlgorithm.selectionSort(arr);
        //SoritngAlgorithm.bubbleSort(arr);
        //SoritngAlgorithm.insertionSort(arr);

        //int[] arr1 = new int[]{1, 4, 6, 100};
        //int[] arr2 = new int[]{2, 4, 7, 11};
        //int[] temp = merge(arr1, arr2);
        // System.out.println(Arrays.toString(temp));


        //System.out.println(fib(4));
        //System.out.println(reverse("hello"));
        //System.out.println(convertDecimalToBinary(10, ""));

        //int[] a = new int[] {17, 10, 15, 13, 4, 12, 7, 9, 16, 8, 5, 14, 3};
        //int[] temp = new int[13];
        //mergeSort(a, temp, 0, 12);


        //int[] b = new int[] {7, 2, 8, 3, 4, 1, 5, 0};
        //int[] temp2 = new int[8];
        //mergeSort(b, temp2, 0, 7);


        //insertionSort(a);

        String[] arr1 = {"B", "B", "B", "C", "A", "C", "A", "A", "A", "A", "A"};
        System.out.println(sortAndFindWinner(arr1));
        int[] arr2 = {5, 10, 70, 88};
        int[] arr3 = {1, 8, 10, 40, 55, 70};

        int[] arr4 = {17, 10, 15, 13, 4, 12, 7, 9, 16, 8, 5, 14, 3};
        quickSort(arr4, 0, 12);

    }
}


