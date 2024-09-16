package day107;

public class hw1 {
    public static class pool {
        private int size;
        public int[] bag;
        public pool(int s) {
            size = s;
            bag = new int[s];
        }
        private boolean pick(int i) {
            return (int)(Math.random()*i) < size;
        }
        private int where() {
            return (int) (Math.random() *size);
        }
        public void enter(int i) {
            if (i <= size) {
                bag[i - 1] = i;
            } else {
                if (pick(i)) {
                    bag[where()] = i;
                }
            }

        }
    }


}
