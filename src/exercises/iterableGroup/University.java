package exercises.iterableGroup;

public class University {

    private final Student[] students;

    public University(final Student[] students) {
        this.students = students;
    }

    public Iterator<Student> iterator() {
        return new StudentsIterator();
    }

    private class StudentsIterator implements Iterator<Student> {
        // BEGIN (write your solution here)

        // END
    }



}
