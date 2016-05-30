package exercises.iterableGroup;

public class Group {

    private Student[] students;

    public Group(final Student[] students) {
        this.students = students;
    }

    public Iterator<Student> iterator() {
        return new StudentsIterator(students);
    }

    private static class StudentsIterator implements Iterator<Student> {
        // BEGIN (write your solution here)

        // END
    }

}
