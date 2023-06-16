public class lr13_4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(new NumberThread(i));
            thread.start();
        }
    }

    static class NumberThread implements Runnable {
        private int number;

        public NumberThread(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            System.out.println("Thread: " + number);
        }
    }
}