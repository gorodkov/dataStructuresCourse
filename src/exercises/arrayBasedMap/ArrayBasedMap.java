/**
 * В Вашем распоряжении есть список пар, каждая пара представлена в виде объекта типа ArrayBasedMap.Pair
 * Ваша задача реализовать следующие методы интерфейса Map:
 *
 * size()
 * isEmpty()
 * containsKey(Object key)
 * containsValue(Object value)
 * get(Object key) {
 * put(K key, V value)
 * remove(Object key)
 * clear()
 * values()
 * Некоторые методы уже реализованы за Вас, например:
 *
 * entrySet() - мы еще не рассматривали тему Set
 * keySet() - по той же причине
 * putAll(Map<? extends K, ? extends V> m) - требует немного магии Generics
 *
 */

package exercises.arrayBasedMap;

import java.util.*;

public class ArrayBasedMap<K, V> implements Map<K, V> {

    private List<Pair> values = new ArrayList<Pair>();

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        for (Pair p : values)
            if (p.getKey().equals(key)) return true;
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Pair p : values)
            if (p.getValue().equals(value)) return true;
        return false;
    }

    @Override
    public V get(Object key) {
        for (Pair p : values)
            if (p.getKey().equals(key)) return p.getValue();
        return null;
    }

    @Override
    public V put(K key, V value) {
        V result = value;
        if (!containsKey(key)) {
            values.add(new Pair(key, value));
            return null;
        }
        for (Pair p : values)
            if (p.getKey().equals(key)) {
                result = p.getValue();
                p.setValue(value);
                break;
            }
        return result;
    }

    @Override
    public V remove(Object key) {
        V value = null;
        for (int i = 0; i < values.size(); i++) {
            final Pair p = values.get(i);
            if (p.getKey().equals(key)) {
                value = p.getValue();
                values.remove(i);
                return value;
            }
        }
        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<K, V> e : (Set<Map.Entry<K, V>>)(Set)m.entrySet())
            put(e.getKey(), e.getValue());
    }

    @Override
    public void clear() {
        values.clear();
    }

    @Override
    public Set<K> keySet() {
        final Set<K> keys = new HashSet<K>();
        for (Pair p : values) keys.add(p.getKey());
        return keys;
    }

    @Override
    public Collection<V> values() {
        final List<V> val = new ArrayList<>();
        for (Pair p : values) val.add(p.getValue());
        return val;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return (Set<Entry<K, V>>)(Set)new HashSet<>(values);
    }

    private class Pair implements Map.Entry<K, V> {

        private final K key;

        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            final V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            Map.Entry<K, V> pair = (Map.Entry<K, V>) o;


            if (key != null ? !key.equals(pair.getKey()) : pair.getKey() != null) return false;
            return !(value != null ? !value.equals(pair.getValue()) : pair.getValue() != null);

        }

        @Override
        public int hashCode() {
            return (key   == null ? 0 :   key.hashCode()) ^
                    (value == null ? 0 : value.hashCode());
        }
    }
}

