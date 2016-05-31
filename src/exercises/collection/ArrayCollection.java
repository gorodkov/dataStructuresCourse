//Реализовать необходимо только не default методы, а именно:
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
//        T[] toArray(T[] a)


package exercises.collection;

import java.util.Collection;
import java.util.Iterator;

public class ArrayCollection<T> implements Collection<T> {

    private T[] m = (T[])new Object[1];

    private int size;

    @Override
    public int size() {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public boolean isEmpty() {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public boolean contains(final Object o) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public Iterator<T> iterator() {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public Object[] toArray() {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public boolean add(final T t) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public boolean remove(final Object o) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public void clear() {
        // BEGIN (write your solution here)

        // END
    }

    private class ElementsIterator implements Iterator<T> {
        // BEGIN (write your solution here)


        // END
    }

}

