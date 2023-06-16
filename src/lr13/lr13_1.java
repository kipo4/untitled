import java.util.Date;

public class lr13_1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread());
        Thread thread2 = new Thread(new MyThread());

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(10000); // Приостанавливаем главный поток на 10 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
        thread2.interrupt();
    }

    static class MyThread implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Поток: " + Thread.currentThread().getName() + ", время: " + new Date());

                try {
                    Thread.sleep(1000); // Приостанавливаем поток на 1 секунду
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Устанавливаем флаг прерывания, чтобы завершить поток
                }
            }
        }
    }
}