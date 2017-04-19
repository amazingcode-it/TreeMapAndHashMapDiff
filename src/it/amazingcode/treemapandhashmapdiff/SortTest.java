package it.amazingcode.treemapandhashmapdiff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortTest extends Main {

    public static void main(String[] args) {
        new SortTest().runTests();
    }

    private void runTests() {
        for (int i = 0; i < 10; i++) {
            runTreeMapTest();
            runHashMapTest();
            System.out.println("---------------");
        }
    }

    private void runTreeMapTest() {
        long currentTime = System.currentTimeMillis();

        getSortedMapUsingTreeMap();

        logResult("runTreeMapTest", System.currentTimeMillis() - currentTime);
    }

    private Map<Integer, Object> getSortedMapUsingTreeMap() {
        final Map<Integer, Object> map = new TreeMap<>();

        getValues().forEach(value -> map.put(getGeneratedKey(), value));

        return map;
    }

    private void runHashMapTest() {
        long currentTime = System.currentTimeMillis();

        getSortedMapUsingHashMap();

        logResult("runHashMapTest", System.currentTimeMillis() - currentTime);
    }

    private Map<Integer, Object> getSortedMapUsingHashMap() {
        final Map<Integer, Object> unsortedMap = new HashMap<>();
        for (final Object value : getValues()) {
            unsortedMap.put(getGeneratedKey(), value);
        }

        final Map<Integer, Object> sortedMap = new HashMap<>();

        final List<Integer> keys = new ArrayList<>(unsortedMap.keySet());
        Collections.sort(keys);

        for (final Integer key : keys) {
            sortedMap.put(key, unsortedMap.get(key));
        }

        return sortedMap;
    }
}
