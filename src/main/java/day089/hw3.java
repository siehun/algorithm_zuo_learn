package day089;

import java.util.HashMap;

public class hw3 {
    public HashMap<Integer, Integer> hash = new HashMap<>();
    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        if (hash.containsKey(n)) {
            return hash.get(n);
        }
        int ans = Math.min(n % 2  + 1 + minDays(n/2), n % 3 + 1+ minDays(n / 3));
        hash.put(n, ans);
        return ans;

    }
}
