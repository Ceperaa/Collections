package ru.clevertec.homework.collections.test;

import org.openjdk.jmh.annotations.*;

import java.util.LinkedList;
import java.util.List;

@State(value = Scope.Benchmark)
public class TestLinkedList extends SpeedTest {

    private static final List<String> list = new LinkedList<>();

    public TestLinkedList() {
        super(list);
    }

    @Override
    @Setup(Level.Invocation)
    public void createList() {
        for (int i = 0; i < 100000; i++) {
            list.add("test".concat(String.valueOf(i)));
        }
    }
}
