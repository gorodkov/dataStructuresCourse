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
        // BEGIN (write your solution here)
        return map.size();
        // END
    }

    @Override
    public boolean isEmpty() {
        // BEGIN (write your solution here)
        return map.isEmpty();
        // END
    }

    @Override
    public boolean contains(Object o) {
        // BEGIN (write your solution here)
        return map.containsKey(o);
        // END
    }

    @Override
    public Iterator<T> iterator() {
        // BEGIN (write your solution here)
        return map.keySet().iterator();
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
    public boolean add(T t) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public boolean remove(Object o) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // BEGIN (write your solution here)

        // END
    }

    @Override
    public void clear() {
        // BEGIN (write your solution here)

        // END
    }

}

