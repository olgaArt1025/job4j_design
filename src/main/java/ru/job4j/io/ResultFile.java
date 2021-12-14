package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class ResultFile {
    public static int[][] multiple(int size) {
        int[][] result  = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = (i + 1) * (j + 1);

            }
        }
        return result;
    }

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("multiple.txt")) {
            out.write(Arrays.deepToString(multiple(9)).getBytes());
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
