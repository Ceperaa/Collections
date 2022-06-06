package ru.clevertec.homework.collections.test;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;

@State(value = Scope.Benchmark)
public class TestArrayList extends SpeedTest {

    private static final List<String> list = new ArrayList<>();

    public TestArrayList() {
        super(list);
    }

    @Setup(Level.Invocation)
    public void arrayList() {
        for (int i = 0; i < 100000; i++) {
            list.add("test".concat(String.valueOf(i)));
        }
    }
}
