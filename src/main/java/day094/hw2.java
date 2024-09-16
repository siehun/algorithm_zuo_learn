package day094;

public class hw2 {
    public String largestPalindromic(String num) {
        char[] nums = num.toCharArray();
        int len = nums.length;
        int[] record = new int[10];
        for (int i = 0; i < len; i++) {
            record[nums[i] - '0']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 9; i > 0; i--) {
            if (record[i] % 2 == 0 && record[i] != 0) {
                for (int j = 0; j < record[i] / 2; j++) {
                    builder.append(i);

                }
                record[i] = 0;
            }
            if (record[i] % 2 != 0) {
                for (int j = 0; j < record[i] / 2; j++) {
                    builder.append(i);

                }
                record[i] = 1;
            }
        }
        if (record[0] != 0 && !builder.isEmpty()) {
            for (int j = 0; j < record[0] / 2; j++) {
                builder.append(0);

            }
            if (record[0] % 2 == 0) {
                record[0] = 0;
            } else {
                record[0] = 1;
            }

        }
        int flag = 0;
        for (int i = 9; i >= 0; i--) {
            if (record[i] != 0) {
                builder.append(i);
                flag = 1;
                break;
            }
        }
        char[] ans = builder.toString().toCharArray();
        int col = 0;
        if (flag == 0) {
            col = ans.length - 1;
        } else {
            col = ans.length - 2;
        }
        for (int i = col; i >= 0; i--) {
            builder.append(ans[i]);
        }
        return builder.toString();

    }
}
