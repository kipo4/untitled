public class lr13_2 {
    public static void main(String[] args) {
        Thread numberThread = new Thread(new NumberThread());
        numberThread.start();
    }

    static class NumberThread implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000); // Приостанавливаем поток на 1 секунду
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}