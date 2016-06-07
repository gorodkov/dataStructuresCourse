/*
Задание
Сегодня Вам предстоит пожалуй самое сложное задание этого модуля.
Вам предстоит самостоятельно реализовать двунаправленный (двух связный) лист: LinkedList.
Он сложнее чем однонаправленный. Для того, чтобы понять какие типы листов бывают и какой
именно Вы реализуете, можно заглянуть сюда.
Эта задача иногда выдается некоторыми университетами в качестве курсового проекта!
Не ожидайте, что задача будет проста и легко решаема. Решив её самостоятельно Вы своими руками
прочувствуете то, насколько она нетривиальна.
В Вашем распоряжении есть вложенный класс "LinkedList.Item", который Вы должны использовать для
реализации всех методов интерфейса List.
В качестве небольшой "помощи" - Вам нет необходимости реализовывать методы:
subList
lastIndexFor
Желаем Вам удачи в этой нелегкой практике!
*/

package exercises.linkedList;

import java.util.*;


public class LinkedList<T> implements List<T> {

    private Item<T> first = null;

    private Item<T> last = null;

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
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Item<T> x = first; x != null; x = x.next)
            result[i++] = x.element;
        return result;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size)
            a = (T1[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = a;
        for (Item<T> x = first; x != null; x = x.next)
            result[i++] = x.element;
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean add(final T t) {
        final Item<T>  l = last;
        final Item<T> newItem = new Item<>(t, l, null);
        last = newItem;
        if (l == null)
            first = newItem;
        else
            l.next = newItem;
        size++;
        return true;
    }

    @Override
    public boolean remove(final Object o) {
        if (o == null) {
            for (Item<T> x = first; x != null; x = x.next) {
                if (x.element == null) {
                    final Item<T> next = x.next;
                    final Item<T> prev = x.prev;

                    if (prev == null) {
                        first = next;
                    } else {
                        prev.next = next;
                        x.prev = null;
                    }

                    if (next == null) {
                        last = prev;
                    } else {
                        next.prev = prev;
                        x.next = null;
                    }

                    x.element = null;
                    size--;
                    return true;
                }
            }
        } else {
            for (Item<T> x = first; x != null; x = x.next) {
                if (o.equals(x.element)) {
                    final Item<T> next = x.next;
                    final Item<T> prev = x.prev;

                    if (prev == null) {
                        first = next;
                    } else {
                        prev.next = next;
                        x.prev = null;
                    }

                    if (next == null) {
                        last = prev;
                    } else {
                        next.prev = prev;
                        x.next = null;
                    }

                    x.element = null;
                    size--;
                    return true;
                }
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
            add(item);
        }
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        for (final Object item : c) {
            remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        for (final Object item : this) {
            if (!c.contains(item)) this.remove(item);
        }
        return true;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public T remove(final int index) {
        Item<T> x = node(index);

        if (x.element == null) {
            final Item<T> next = x.next;
            final Item<T> prev = x.prev;

            if (prev == null) {
                first = next;
            } else {
                prev.next = next;
                x.prev = null;
            }

            if (next == null) {
                last = prev;
            } else {
                next.prev = prev;
                x.next = null;
            }

            x.element = null;
            size--;
        }
        return x.getElement();
    }


    Item<T> node(int index) {
        if (index < (size >> 1)) {
            Item<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Item<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public List<T> subList(final int start, final int end) {
        return null;
    }

    @Override
    public ListIterator listIterator() {
        return new ElementsIterator(0);
    }

    @Override
    public ListIterator listIterator(final int index) {
        return new ElementsIterator(index);
    }

    @Override
    public int lastIndexOf(final Object target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(final Object target) {
        int index = 0;
        if (target == null) {
            for (Item<T> x = first; x != null; x = x.next) {
                if (x.element == null)
                    return index;
                index++;
            }
        } else {
            for (Item<T> x = first; x != null; x = x.next) {
                if (target.equals(x.element))
                    return index;
                index++;
            }
        }
        return -1;
    }

    @Override
    public void add(final int index, final T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(final int index, final Collection elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(final int index, final T element) {
        checkElementIndex(index);
        Item<T> x = node(index);
        T oldVal = x.element;
        x.element = element;
        return oldVal;
    }

    @Override
    public T get(final int index) {
        //checkElementIndex(index);
        return node(index).element;
    }

    private void checkElementIndex(int index) {
        if (index >= 0 && index < size)
            throw new IndexOutOfBoundsException();
    }

    private class ElementsIterator implements ListIterator<T> {

        private Item<T> current;

        private Item<T> lastReturned;

        private int nextIndex;

        public ElementsIterator() {
            this(0);
        }

        public ElementsIterator(final int index) {
            current = node(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = current;
            current = current.next;
            nextIndex++;
            return lastReturned.element;
        }

        @Override
        public void add(final T element) {
            LinkedList.this.add(element);
        }

        @Override
        public void set(final T element) {
            if (lastReturned == null)
                throw new IllegalStateException();
            LinkedList.this.set(nextIndex, element);
        }

        @Override
        public int previousIndex(){
            return nextIndex - 1;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public T previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = current = (current == null) ? lastReturned : current.prev;
            nextIndex--;
            return lastReturned.element;
        }

        @Override
        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();

            Item<T> lastNext = lastReturned.next;

            final Item<T> next = lastReturned.next;
            final Item<T> prev = lastReturned.prev;

            if (prev == null) {
                first = next;
            } else {
                prev.next = next;
                lastReturned.prev = null;
            }

            if (next == null) {
                last = prev;
            } else {
                next.prev = prev;
                lastReturned.next = null;
            }

            lastReturned.element = null;
            size--;


            if (current == lastReturned)
                current = lastNext;
            else
                nextIndex--;

            lastReturned = null;

        }

    }

    private static class Item<T> {

        private T element;

        private Item<T> next;

        private Item<T> prev;

        public Item(final T element, final Item<T> prev, final Item<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public T getElement() {
            return element;
        }

        public Item<T> getNext() {
            return next;
        }

        public Item<T> getPrev() {
            return prev;
        }

    }

}

