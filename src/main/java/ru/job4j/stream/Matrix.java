package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    public static List<Integer> MatrixToList(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Integer[][] m = new Integer[2][3];
        m[0][0] = 1;
        m[0][1] = 2;
        m[0][2] = 3;
        m[1][0] = 4;
        m[1][1] = 5;
        m[1][2] = 6;

        for (Integer[] integers : m) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(integers[j]);
            }
            System.out.println();
        }

        List<Integer> flat = MatrixToList(m);
        System.out.println(flat);

    }
}

