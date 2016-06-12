/**
 *Сегодня Вам предстоит самостоятельно релизовать интерфейс Set (на базе HashMap).
 * Как не трудно догдаться имя реализации интферфейса Set: HashSet
 * Напомним Вам, что интерфейс Set полностью дублирует методы интерфейса Collection,
 * с тем лишь исключением, что он добавляет новые ограничения на методы.
 * Ваш интерфейс должен соответствовать описанию в официальной документации.
 */

package exercises.hashSet;

import java.util.*;

public class HashSet<T> implements Set<T> {

    private static final Boolean EXIST = true;

    private final Map<T, Boolean> elements = new HashMap<>();

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return elements.containsKey(o);
    }

    @Override
    public Iterator<T> iterator() {
        return elements.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return elements.keySet().toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return elements.keySet().toArray(a);
    }

    @Override
    public boolean add(T t) {
        elements.put(t, EXIST);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        elements.remove(o);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T e : c) {
            if (add(e)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c)
            remove(o);
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object o : this)
            if (!c.contains(o))
                remove(o);
        return true;
    }

    @Override
    public void clear() {
        elements.clear();
    }

}

