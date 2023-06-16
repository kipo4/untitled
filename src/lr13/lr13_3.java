public class lr13_3 {
    public static void main(String[] args) {
        Thread evenThread = new Thread(new EvenThread());
        Thread oddThread = new Thread(new OddThread());

        evenThread.start();
        oddThread.start();
    }

    static class EvenThread implements Runnable {
        @Override
        public void run() {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Even Thread: " + i);
                try {
                    Thread.sleep(500); // Приостанавливаем поток на 0.5 секунды
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class OddThread implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 9; i += 2) {
                System.out.println("Odd Thread: " + i);
                try {
                    Thread.sleep(500); // Приостанавливаем поток на 0.5 секунды
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}