package ru.job4j.encapsulation;

public class Merge {
    public static int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int leftLength = left.length;
        int rightLength = right.length;
        int indexLeft = 0, indexRight = 0, indexRsl = 0;
        while (indexLeft < leftLength && indexRight < rightLength) {
            if (left[indexLeft] <= right[indexRight]) {
                rsl[indexRsl] = left[indexLeft];
                indexLeft++;
            } else {
                rsl[indexRsl] = right[indexRight];
                indexRight++;
            }
            indexRsl++;
        }
        while (indexLeft < leftLength) {
            rsl[indexRsl] = left[indexLeft];
            indexLeft++;
            indexRsl++;
        }
        while (indexRight < rightLength) {
            rsl[indexRsl] = right[indexRight];
            indexRight++;
            indexRsl++;
        }

        return rsl;
    }
}