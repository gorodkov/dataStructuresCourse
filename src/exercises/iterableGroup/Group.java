package exercises.iterableGroup;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Group {

    private Student[] students;

    public Group(final Student[] students) {
        this.students = students;
    }

    public Iterator<Student> iterator() {
        return new StudentsIterator(students);
    }

    private static class StudentsIterator implements Iterator<Student> {

        private int index =0;

        private final Student[] students;

        public StudentsIterator(Student[] students) {
            this.students = students;
        }

        @Override
        public boolean hasNext() {
            return this.students.length > index;
        }

        @Override
        public Student next() {
            if (hasNext()) {
                return this.students[index++];
            } else {
                throw new NoSuchElementException();
            }
        }

    }

}
