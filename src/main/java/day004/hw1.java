package day004;

public class hw1 {
    // 三傻排序
    // 好久没写了
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i; j < n; j++) {
                min = arr[min] < arr[j] ? min : j;
            }
            swap(arr, i, min);
        }
    }
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j - 1 >= 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }
    public static int[] copyArr(int[] arr) {
        int n = arr.length;
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,4,2,9,8,6,7, 5,10};
        int[] arr2 = copyArr(arr1);
        int[] arr3 = copyArr(arr1);
        selectionSort(arr1);
        printArr(arr1);
        bubbleSort(arr2);
        printArr(arr2);
        insertionSort(arr3);
        printArr(arr3);
    }
}
