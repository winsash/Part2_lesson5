package ru.geekbrains.part2.lesson5;

import java.util.Arrays;

public class ArrLine {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    public ArrLine() {
        Arrays.fill(arr, 1);
    }
    public void makePrep() {
        long init_time = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long end = System.currentTimeMillis() - init_time;
        System.out.println(end);
    }
}
