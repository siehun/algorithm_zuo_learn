package day060;

public class hw4 {
    public int maximumInvitations(int[] favorite) {
        int len = favorite.length;
        int[] degree = new int[len];
        for (int i = 0; i < len; i++) {
            degree[favorite[i]]++;
        }
        int[] que = new int[len];
        int l = 0, r = 0;
        for (int i = 0; i < len; i++) {
            if (degree[i] == 0) {
                que[r++] = i;
            }
        }
        int[] deep = new int[len];
        while (l < r) {
            int cur = que[l++];
            int next = favorite[cur];
            deep[next] = Math.max(deep[next], deep[cur] + 1);
            if (--degree[next] == 0) {
                que[r++] = next;
            }
        }
        int two_max = 0;
        int moreThree = 0;
        for (int i = 0; i < len; i++) {
            int size = 1;
            if (degree[i] != 0) {
                degree[i] = 0;
                for (int j = favorite[i]; j != i; j = favorite[j]) {
                    size++;
                    degree[j] = 0;
                }
                if (size == 2) {
                    two_max += 2 + deep[i] + deep[favorite[i]];
                } else {
                    moreThree = Math.max(moreThree, size);
                }
            }
        }
        return Math.max(two_max, moreThree);
    }
}
