package ru.clevertec.homework.collections.test;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.List;

public abstract class SpeedTest {

    private List<String> list;

    public SpeedTest(List<String> list) {

        this.list = list;
    }

    abstract public void arrayList();

    @Benchmark
    public void addFirst() {
        list.add(0, "test1");
    }

    @Benchmark
    public void addCenter() {
        list.add(50000, "test2");
    }

    @Benchmark
    public void addLast() {
        list.add("test3");
    }

    @Benchmark
    public void deleteElement() {
        list.remove("test");
    }

    @Benchmark
    public void deleteFirst() {
        list.remove(0);
    }

    @Benchmark
    public void deleteCenter() {
        list.remove(50000);
    }

    @Benchmark
    public void deleteLast() {
        list.remove(list.size() - 1);
    }

    @Benchmark
    public void contains() {
        list.contains("test55555");
    }
}
