import java.util.Arrays;

public class lr13_5 {
    public static void main(String[] args) {
        int[] array = {7, 2, 9, 1, 6, 3, 8, 5, 10, 4};

        int processors = Runtime.getRuntime().availableProcessors(); // Получаем количество ядер процессора
        int chunkSize = array.length / processors; // Вычисляем размер части массива для каждого потока

        MaxElementThread[] threads = new MaxElementThread[processors];

        for (int i = 0; i < processors; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == processors - 1) ? array.length : startIndex + chunkSize;

            threads[i] = new MaxElementThread(array, startIndex, endIndex);
            threads[i].start();
        }

        int[] maxValues = new int[processors];

        try {
            for (int i = 0; i < processors; i++) {
                threads[i].join();
                maxValues[i] = threads[i].getMaxValue();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int overallMax = Arrays.stream(maxValues).max().getAsInt();
        System.out.println("Максимальный элемент: " + overallMax);
    }

    static class MaxElementThread extends Thread {
        private int[] array;
        private int startIndex;
        private int endIndex;
        private int maxValue;

        public MaxElementThread(int[] array, int startIndex, int endIndex) {
            this.array = array;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public void run() {
            maxValue = array[startIndex];

            for (int i = startIndex + 1; i < endIndex; i++) {
                if (array[i] > maxValue) {
                    maxValue = array[i];
                }
            }
        }

        public int getMaxValue() {
            return maxValue;
        }
    }
}