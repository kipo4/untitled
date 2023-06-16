import java.util.Arrays;

public class lr13_6 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int processors = Runtime.getRuntime().availableProcessors(); // Получаем количество ядер процессора
        int chunkSize = array.length / processors; // Вычисляем размер части массива для каждого потока

        SumThread[] threads = new SumThread[processors];

        for (int i = 0; i < processors; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == processors - 1) ? array.length : startIndex + chunkSize;

            threads[i] = new SumThread(array, startIndex, endIndex);
            threads[i].start();
        }

        int[] sums = new int[processors];

        try {
            for (int i = 0; i < processors; i++) {
                threads[i].join();
                sums[i] = threads[i].getSum();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int overallSum = Arrays.stream(sums).sum();
        System.out.println("Сумма элементов: " + overallSum);
    }

    static class SumThread extends Thread {
        private int[] array;
        private int startIndex;
        private int endIndex;
        private int sum;

        public SumThread(int[] array, int startIndex, int endIndex) {
            this.array = array;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public void run() {
            for (int i = startIndex; i < endIndex; i++) {
                sum += array[i];
            }
        }

        public int getSum() {
            return sum;
        }
    }
}