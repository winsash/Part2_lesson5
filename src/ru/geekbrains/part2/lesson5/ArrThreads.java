package ru.geekbrains.part2.lesson5;
import java.util.Arrays;

public class ArrThreads {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    public ArrThreads() {
        Arrays.fill(arr, 1);
    }

    public void makePrep() {
        long init_time = System.currentTimeMillis();

        float[] arr_part_1 = new float[size / 2];
        float[] arr_part_2 = new float[size / 2];

        System.arraycopy(arr, 0, arr_part_1, 0, h);
        System.arraycopy(arr, h, arr_part_2, 0, h);

        Thread arr_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                operations(arr_part_1);
            }
        });
        arr_1.start();

        Thread arr_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                operations(arr_part_2);
            }
        });
        arr_2.start();

        try{
            arr_1.join();
            arr_2.join();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.arraycopy(arr_part_1, 0, arr, 0, h);
        System.arraycopy(arr_part_2, 0, arr, h, h);
        long end = System.currentTimeMillis() - init_time;
        System.out.println(end);
    }

    private void operations(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
