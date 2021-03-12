public static int[] union(int[] arr1, int[] arr2) {
    int[] temp = new int[arr1.length + arr2.length];
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] < arr2[j]) {
            temp[k] = arr1[i];
            k++;
            i++;
        } else if (arr1[i] > arr2[j]) {
            temp[k] = arr2[j];
            j++;
            k++;
        } else {
            temp[k] = arr1[i];
            k++;
            i++;
            j++;
        }
    }
    while (i < arr1.length) {
        temp[k] = arr1[i];
        i++;
        k++;
    }
    while (j < arr2.length) {
        temp[k] = arr2[j];
        j++;
        k++;
    }

    return Arrays.copyOf(temp, k);
}

Pivot: 7
[5, 3, 4, 7, 15, 12, 10, 9, 16, 8, 17, 14, 13]
Pivot: 3
[3, 4, 5, 7, 15, 12, 10, 9, 16, 8, 17, 14, 13]
Pivot: 4
[3, 4, 5, 7, 15, 12, 10, 9, 16, 8, 17, 14, 13]
Pivot: 5
[3, 4, 5, 7, 15, 12, 10, 9, 16, 8, 17, 14, 13]
Pivot: 16
[3, 4, 5, 7, 15, 12, 10, 9, 13, 8, 14, 16, 17]
Pivot: 9
[3, 4, 5, 7, 8, 9, 10, 14, 13, 15, 12, 16, 17]
Pivot: 8
[3, 4, 5, 7, 8, 9, 10, 14, 13, 15, 12, 16, 17]
Pivot: 13
[3, 4, 5, 7, 8, 9, 10, 12, 13, 15, 14, 16, 17]
Pivot: 10
[3, 4, 5, 7, 8, 9, 10, 12, 13, 15, 14, 16, 17]
Pivot: 12
[3, 4, 5, 7, 8, 9, 10, 12, 13, 15, 14, 16, 17]
Pivot: 15
[3, 4, 5, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17]
Pivot: 14
[3, 4, 5, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17]
Pivot: 17
[3, 4, 5, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17]