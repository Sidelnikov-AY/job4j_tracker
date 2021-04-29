package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static ru.job4j.stream.Matrix.MatrixToList;

public class MatrixTest {

    @Test
    public void WhenListGenerated() {
        Integer[][] m = new Integer[2][3];
        m[0][0] = 1;
        m[0][1] = 2;
        m[0][2] = 3;
        m[1][0] = 4;
        m[1][1] = 5;
        m[1][2] = 6;

        List<Integer> rsl = MatrixToList(m);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertThat(rsl, is(expected));
    }
}