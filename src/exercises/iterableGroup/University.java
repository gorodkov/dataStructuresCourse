// В этом практическом задании Вам необходимо создать итераторы для двух классов:
//
// University
// Group
// Эти два класса имеют два разных итератора. Класс University использует нестатический (non-static) вложенный
// класс для реализации итератора, соответственно, итератор имеет доступ ко всем полям объекта, который
// создает этот итератор.
//
// Класс Group использует итератор, который является статическим классом и, соответственно,
// сам итератор не имеет доступа к полям объекта Group.


package exercises.iterableGroup;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class University implements Iterable<Student> {

    private final Student[] students;

    public University(final Student[] students) {
        this.students = students;
    }

    public Iterator<Student> iterator() {
        return new StudentsIterator();
    }

    private class StudentsIterator implements Iterator<Student> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return University.this.students.length > index;
        }

        @Override
        public Student next() {
            if (!this.hasNext()) throw new NoSuchElementException();
            return students[index++];
        }

    }



}
