package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

        @Test
    public void whenCompatorByNameIncr() {
        Comparator<Job> cmpNamePriority = new JobIncrByName();
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("B", 1)
        );
        assertThat(rsl, lessThan(0));
    }
        @Test
    public void whenCompatorByPriorityIncr() {
        Comparator<Job> cmpNamePriority = new JobIncrByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
        @Test
    public void whenCompatorByNameDecr() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("B", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
        @Test
    public void whenCompatorByPriorityDecr() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityIncr() {
        Comparator<Job> cmpNamePriority = new JobIncrByName().thenComparing(new JobIncrByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A", 0),
                new Job("B", 1)
        );
        assertThat(rsl, lessThan(0));
    }

}