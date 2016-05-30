package exercises.iterableGroup;

import java.util.Iterator;

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



        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Student next() {
            return null;
        }

    }

}
