package ru.clevertec.homework.collections.test;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TestLinkedList.class.getSimpleName())
                .include(TestArrayList.class.getSimpleName())
                .forks(1)
                .warmupIterations(1)
                .measurementIterations(1)
                .timeUnit(TimeUnit.MILLISECONDS)
                .mode(Mode.AverageTime)
                .build();

        new Runner(opt).run();
    }
}
