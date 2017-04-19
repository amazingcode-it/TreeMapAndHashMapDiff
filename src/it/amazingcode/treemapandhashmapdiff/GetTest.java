package it.amazingcode.treemapandhashmapdiff;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GetTest extends Main {

    private int lastGeneratedKey = 0;

    public static void main(String[] args) {
        new GetTest().runTests();
    }

    private void runTests() {
        for (int i = 0; i < 10; i++) {
            runTreeMapTest();
            runHashMapTest();
            System.out.println("---------------");
        }
    }

    private void runTreeMapTest() {
        Map<Integer, Object> map = getTreeMap();

        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < getValues().size(); i++) {
            map.get(getGeneratedKey());
        }
        logResult("runTreeMapTest", System.currentTimeMillis() - currentTime);
    }

    private Map<Integer, Object> getTreeMap() {
        final Map<Integer, Object> map = new TreeMap<>();

        lastGeneratedKey = 0;
        getValues().forEach(value -> map.put(getLastGeneratedKey(), value));

        return map;
    }

    private void runHashMapTest() {
        Map<Integer, Object> map = getHashMap();

        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < getValues().size(); i++) {
            map.get(getGeneratedKey());
        }
        logResult("runHashMapTest", System.currentTimeMillis() - currentTime);
    }

    private Map<Integer, Object> getHashMap() {
        final Map<Integer, Object> map = new HashMap<>();

        lastGeneratedKey = 0;
        getValues().forEach(value -> map.put(getLastGeneratedKey(), value));

        return map;
    }

    private int getLastGeneratedKey() {
        return lastGeneratedKey++;
    }
}
