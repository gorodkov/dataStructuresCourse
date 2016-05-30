package exercises.interfaceIterable;

import java.util.Arrays;
import java.util.Iterator;

public class University implements Iterable<Student> {

    private final Student[] students;

    public University(final Student[] students) {
        this.students = students;
    }

    @Override
    public Iterator<Student> iterator() {

        return Arrays.asList(students).iterator();

    }
}
