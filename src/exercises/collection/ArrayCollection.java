///*Реализовать необходимо только не default методы, а именно:
//        boolean add(E e)
//        boolean addAll(Collection<? extends E> c)
//        void clear()
//        boolean contains(Object o)
//        boolean containsAll(Collection<?> c)
//        boolean equals(Object o)
//        int hashCode()
//        boolean isEmpty()
//        Iterator iterator()
//        boolean remove(Object o)
//        boolean removeAll(Collection<?> c)
//        boolean retainAll(Collection<?> c)
//        int size()
//        Object[] toArray()
//        T[] toArray(T[] a)*/


package exercises.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayCollection<T> implements Collection<T> {

    private T[] m = (T[])new Object[1];

    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(final Object o) {
        for (int i = 0; i < size; i++) {
            if (m[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

    @Override
    public Object[] toArray() {
        final T[] newM = (T[])new Object[this.size()];
        System.arraycopy(m, 0, newM, 0, this.size());
        return newM;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return (T1[]) this.toArray();
    }

    @Override
    public boolean add(final T t) {
        if (m.length == size) {
            final T[] oldM = m;
            m = (T[]) new Object[this.size() * 2];
            System.arraycopy(oldM, 0, m, 0, oldM.length);
        }
        m[size++] = t;
        return true;
    }

    @Override
    public boolean remove(final Object o) {
        for (int i = 0; i < size(); i++) {
            if (m[i].equals(o)) {
                if (i != this.size() - 1)
                    System.arraycopy(m, i + 1, m, i, this.size() - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        for (final T item : c) {
            this.add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        for (final Object item : c) {
            this.remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        for (int i = 0; i < size(); i++) {
            if (!c.contains(m[i])) {
                this.remove(m[i]);
                i--;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        m = (T[])new Object[1];
        size = 0;
    }

    private class ElementsIterator implements Iterator<T> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return ArrayCollection.this.m.length > index;
        }

        @Override
        public T next() {
            if (!this.hasNext()) throw new NoSuchElementException();
            return m[index++];
        }
    }

}

