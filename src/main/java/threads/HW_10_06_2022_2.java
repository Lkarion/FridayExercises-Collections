package threads;

import java.util.Arrays;
import java.util.Random;

public class HW_10_06_2022_2 {

    /**
     * 2. Ваша программа должна заполнить массив на 100 миллионов int случайными числами.
     * Реализуйте заполнение 1) в 1 поток, 2) в 2 параллельных потока, в 5 параллельных потоков
     * (каждый поток заполняет свою часть массива). Измерьте время выполнения каждого
     * из вариантов, сравните результаты.
     */
}

class Way1 {

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();

        int[] array = new int[100_000_000];

        long startTime = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100_000_000; i++) {
                array[i] = random.nextInt();
            }
        });
        thread1.start();
        thread1.join();

        System.out.println("The 1st Way took " + (System.currentTimeMillis() - startTime) + " ms");

    }
}

class Way2 {

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();

        int[] array2 = new int[100_000_000];

        long startTime2 = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < array2.length/2; i++) {
                array2[i] = random.nextInt();
            }
        });
        thread1.start();
        thread1.join();

        Thread thread2 = new Thread(() -> {
            for (int i = array2.length/2; i < array2.length; i++) {
                array2[i] = random.nextInt();
            }
        });
        thread2.start();
        thread2.join();

        System.out.println("The 2nd Way took " + (System.currentTimeMillis() - startTime2) + " ms");

    }
}

class Way3 {

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();

        int[] array3 = new int[100_000_000];

        long startTime3 = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 20_000_000; i++) {
                array3[i] = random.nextInt(10);
            }
        });
        thread1.start();
        thread1.join();

        Thread thread2 = new Thread(() -> {
            for (int i = 20_000_000; i < 40_000_000; i++) {
                array3[i] = random.nextInt(10);
            }
        });
        thread2.start();
        thread2.join();

        Thread thread3 = new Thread(() -> {
            for (int i = 40_000_000; i < 60_000_000; i++) {
                array3[i] = random.nextInt(10);
            }
        });
        thread3.start();
        thread3.join();

        Thread thread4 = new Thread(() -> {
            for (int i = 60_000_000; i < 80_000_000; i++) {
                array3[i] = random.nextInt(10);
            }
        });
        thread4.start();
        thread4.join();

        Thread thread5 = new Thread(() -> {
            for (int i = 80_000_000; i < 100_000_000; i++) {
                array3[i] = random.nextInt(10);
            }
        });
        thread5.start();
        thread5.join();

        System.out.println("The 3rd Way took " + (System.currentTimeMillis() - startTime3) + " ms");

        // System.out.println(Arrays.toString(array3));
    }
}
