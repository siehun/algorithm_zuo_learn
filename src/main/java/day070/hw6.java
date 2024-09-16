package day070;

import java.util.Arrays;

public class hw6 {
    public int[] getMaxMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int a = 0, b = 0, c= 0, d = 0;
        int[] nums = new int[m];
        for (int up = 0; up < n; up++) {
            Arrays.fill(nums, 0);
            for (int down = up; down < n; down++) {
                int pre = Integer.MIN_VALUE;
                for (int l = 0, r = 0; r < m; r++) {
                    nums[r] += matrix[down][r];
                    if (pre >= 0) {
                        pre += nums[r];
                    } else {
                        pre = nums[r];
                        l = r;
                    }
                    if (pre > max) {
                        max = pre;
                        a = up;
                        b = l;
                        c = down;
                        d = r;
                    }
                }
            }
        }
        return new int[]{a, b, c, d};
    }
}
