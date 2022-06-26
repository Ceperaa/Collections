package ru.clevertec.homework;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class SpeedLog {

    private static final CountDownLatch START = new CountDownLatch(5);
    private static int trackLength;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Длинна трассы : ");
        trackLength = scanner.nextInt();
        System.out.println("Количество авто: ");
        int numberAuto = scanner.nextInt();
        for (int i = 1; i <= numberAuto; i++) {
            new Thread(new Car(i, (int) (Math.random() * 100 + 50))).start();
            Thread.sleep(500);
        }
    }

    public static class Car implements Runnable {
        private final int carNumber;
        private final int carSpeed;

        public Car(int carNumber, int carSpeed) {
            this.carNumber = carNumber;
            this.carSpeed = carSpeed;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль №%d подъехал к стартовой прямой.\n", carNumber);
                START.countDown();
                START.await();

                int trackLengthLocal = trackLength;
                int numberOfSeconds = (10 * (trackLength / carSpeed)) / 1000;
                int x = numberOfSeconds == 0 ? 1 : numberOfSeconds;
                int distanceBySecond = trackLength / x;

                for (int i = 0; i < numberOfSeconds; i++) {
                    Thread.sleep(1000);
                    trackLengthLocal = trackLengthLocal - distanceBySecond;
                    System.out.println("Оставшееся время авто №" + carNumber + " " + trackLengthLocal);
                }

                System.out.printf("Автомобиль №%d финишировал!\n", carNumber);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
