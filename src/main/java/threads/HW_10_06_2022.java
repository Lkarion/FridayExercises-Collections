package threads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class HW_10_06_2022 {

    /**
     * 1. Необходимо создать класс Counter с единственным полем counter типа Integer.
     * Необходимо реализовать 3 метода: увеличение значение counter на 1,
     * уменьшения значения поля counter на 1 и печать значения counter при условии,
     * если значение counter кратно 100. Создать 1 объект типа Counter.
     * Создать 3 потока, каждый из которых миллион раз вызывает метод увеличивающий
     * значение counter, 3 потока уменьшающих значение counter.
     * Создать 1 поток (demon) вызывающий метод печати. Запустить все созданные потоки
     * параллельно. По завершении распечатать значение counter.
     */

    public static void main(String[] args) throws InterruptedException {

        Counter counterObject = new Counter(0);

        new Thread(() -> {
                for (long i = 0; i < 1_000_000L; i++) {
                    counterObject.setCounter(counterObject.getCounter()+1);
                }
        }).start();
        new Thread(() -> {
                for (long i = 0; i < 1_000_000L; i++) {
                    counterObject.setCounter(counterObject.getCounter()+1);
                }
        }).start();
        new Thread(() -> {
                for (long i = 0; i < 1_000_000L; i++) {
                    counterObject.setCounter(counterObject.getCounter()+1);
                }
        }).start();
        new Thread(() -> {
                for (long i = 0; i < 1_000_000L; i++) {
                    counterObject.setCounter(counterObject.getCounter()-1);
                }
        }).start();
        new Thread(() -> {
                for (long i = 0; i < 1_000_000L; i++) {
                    counterObject.setCounter(counterObject.getCounter()-1);                }
        }).start();
        new Thread(() -> {
                for (long i = 0; i < 1_000_000L; i++) {
                    counterObject.setCounter(counterObject.getCounter()-1);                }
        }).start();



        Thread daemon = new Thread(() -> {
            while(true) {
                Integer counter = counterObject.getCounter();

                if (counter % 100 == 0) {
                    System.out.println(counter);
                }
            }
        });
        daemon.setDaemon(true);
        daemon.start();


        Thread.sleep(1500L);
        System.out.println("At the end counter = " +counterObject.getCounter());
    }
}

@AllArgsConstructor
@Getter
@Setter
class Counter {
    private Integer counter;
}
