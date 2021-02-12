package lesson05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static final int GC_SIZE = 10000000;
    static final int GC_HALF = GC_SIZE / 2;

    public static void main(String[] args) {
        try {
            singleThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            multiThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void formula(float[] itFlt) {
        for (int i = 0; i < itFlt.length; i++) {
            //Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
            itFlt[i] = (float) (itFlt[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void singleThread() throws InterruptedException {
        float[] ltFlt = new float[GC_SIZE]; //Создают одномерный длинный массив
        for (int i = 0; i < ltFlt.length; i++) ltFlt[i] = 1; //Заполняют этот массив единицами
        long lvStart = System.currentTimeMillis(); //Засекают время выполнения
        Thread loThread = new Thread(new MyThread(ltFlt));
        loThread.start();
        loThread.join();
        long lvFinish = System.currentTimeMillis(); //Проверяется время окончания метода
        System.out.println("Время работы с одним потоком: " + (lvFinish - lvStart) + " мс");
    }

    public static void multiThread() throws InterruptedException {
        float[] ltFlt = new float[GC_SIZE]; //Создают одномерный длинный массив
        for (int i = 0; i < ltFlt.length; i++) ltFlt[i] = 1; //Заполняют этот массив единицами
        long lvStart = System.currentTimeMillis(); //Засекают время выполнения

        //Второй разбивает массив на два массива
        float[] ltFlt1 = new float[GC_HALF];
        float[] ltFlt2 = new float[GC_HALF];
        System.arraycopy(ltFlt, 0, ltFlt1, 0, GC_HALF);
        System.arraycopy(ltFlt, GC_HALF, ltFlt2, 0, GC_HALF);

        //в двух потоках высчитывает новые значения
        Thread loThread1 = new Thread(new MyThread(ltFlt1));
        Thread loThread2 = new Thread(new MyThread(ltFlt2));
        loThread1.start();
        loThread2.start();
        loThread1.join();
        loThread2.join();
        //склеивает эти массивы обратно в один
        System.arraycopy(ltFlt1, 0, ltFlt, 0, GC_HALF);
        System.arraycopy(ltFlt1, 0, ltFlt, GC_HALF, GC_HALF);

        long lvFinish = System.currentTimeMillis(); //Проверяется время окончания метода
        System.out.println("Время работы с двумя потоками: " + (lvFinish - lvStart) + " мс");
    }
}

class MyThread implements Runnable {

    private float[] mtFlt;

    public MyThread(float[] itFlt) {
        mtFlt = itFlt;
    }

    @Override
    public void run() {
        Main.formula(mtFlt);
    }
}
