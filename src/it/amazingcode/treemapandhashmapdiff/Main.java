package it.amazingcode.treemapandhashmapdiff;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int NUMBER_OF_OBJECTS = 100000;

    private List<Object> values = new ArrayList<>();
    private Random random = new Random(NUMBER_OF_OBJECTS);

    public Main() {
        for (int i = 0; i < NUMBER_OF_OBJECTS; i++) {
            values.add(new Object());
        }
    }

    protected List<Object> getValues() {
        return values;
    }

    protected Integer getGeneratedKey() {
        return random.nextInt();
    }

    protected void logResult(String methodName, long time) {
        System.out.println(String.format(methodName + ": %dms", time));
    }
}
