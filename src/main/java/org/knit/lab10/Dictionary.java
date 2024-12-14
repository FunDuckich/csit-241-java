package org.knit.lab10;

import java.util.Map;
import java.util.HashMap;

public class Dictionary<K, V> {
    private final Map<K, V> dict;

    public Dictionary() {
        this.dict = new HashMap<>();
    }

    public void put(K key, V value) {
        if (dict.containsKey(key)) {
            System.out.println("Ключ " + key + " уже содержит значение " + dict.get(key) + ", оно будет перезаписано!");
        }

        dict.put(key, value);
    }

    public void remove(K key) {
        if (dict.containsKey(key)) {
            dict.remove(key);
        } else {
            throw new IllegalArgumentException("Ключ '" + key + "' отсутствует в словаре.");
        }
    }

    public V get(K key) {
        if (dict.containsKey(key)) {
            return dict.get(key);
        } else {
            throw new IllegalArgumentException("Ключ '" + key + "' отсутствует в словаре.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(" = {\n");
        for (K key : dict.keySet()) {
            sb.append("\t").append(key).append(": ").append(dict.get(key)).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}
