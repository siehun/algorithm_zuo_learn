package day107;

public class hw2 {
    public static double escape1(int people, int tryTimes, int testTimes) {
        int escape = 0;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateRandomArray(people);
            if (maxCircle(arr) <= tryTimes) {
                escape++;
            }
        }
        return (double) escape/ (double) testTimes;
    }
    public static int maxCircle(int[] arr) {
        int maxCircle = 1;
        for (int i = 0; i < arr.length; i++) {
            int curCircle = 1;
            while (i != arr[i]) {
                swap(arr, i, arr[i]);
                curCircle++;
            }
            maxCircle = Math.max(maxCircle, curCircle);
        }
        return maxCircle;
    }
    public static int[] generateRandomArray(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i;
        }
        // 每个位置都模拟打乱一次
        for (int i = len - 1; i > 0; i--) {
           swap(arr, i, (int) (Math.random() * (i + 1)));
        }
        return arr;
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static double escape2(int people, int tryTimes) {
        double a= 0;
        for (int r = tryTimes + 1; r <= people; r++) {
            a += (double) 1 / (double) r;
        }
        return (double) 1 -a;
    }
    public static void main(String[] args) {
        int people = 100;
        int tryTimes = 50;
        int testTimes = 100;
        System.out.println(escape1(people, tryTimes, testTimes));
        System.out.println(escape2(people, tryTimes));
    }
}
