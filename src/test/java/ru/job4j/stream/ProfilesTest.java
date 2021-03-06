package ru.job4j.stream;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenCollectedAndDeleteCopies() {
        List<Profile> prof = List.of(
                new Profile(new Address("moscow", "lubyanka", 21, 45)),
                new Profile(new Address("moscow", "lubyanka", 21, 45)),
                new Profile(new Address("moscow", "lubyanka", 22, 45)),
                new Profile(new Address("chelyabinsk", "surovaya", 42, 666)),
                new Profile(new Address("chelyabinsk", "surovaya", 42, 666))
        );
        Profiles ps = new Profiles();
        List<Address> rsl = ps.collect(prof);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("chelyabinsk", "surovaya", 42, 666));
        expected.add(new Address("moscow", "lubyanka", 21, 45));
        expected.add(new Address("moscow", "lubyanka", 22, 45));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenZero() {
        List<Profile> prof = List.of();
        Profiles ps = new Profiles();
        List<Address> rsl = ps.collect(prof);
        List<Address> expected = new ArrayList<>();
        assertThat(rsl, is(expected));
    }
}