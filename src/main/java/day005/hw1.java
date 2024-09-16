package day005;

import java.util.Arrays;
// 选择，插入，冒泡排序对数器验证
public class hw1 {
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
    public static boolean sameArr(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        if (n != m) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public static int[] randomArray(int n, int v) {
        // 数组长度n, 值为1-v之间
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * v) + 1;
        }
        return arr;
    }
    public static void main(String[] args) {
        int N = 200;
        int V = 1000;
        int testTimes = 5000;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int n = (int)(Math.random() * N);
            int[] arr = randomArray(n, V);
            int[] arr1 = copyArr(arr);
            int[] arr2 = copyArr(arr);
            int[] arr3 = copyArr(arr);
            selectionSort(arr1);
            bubbleSort(arr2);
            insertionSort(arr3);
            Arrays.sort(arr);
            if (!sameArr(arr, arr1) || !sameArr(arr,arr2) || !sameArr(arr,arr3)) {
                System.out.println("出错了！");
            }
        }
        System.out.println("测试结束");


    }
}
