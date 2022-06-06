package ru.clevertec.homework.collections;


import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayCustom<String> productArray = new ArrayCustom<>();
        productArray.add("11");
        productArray.add("21");
        productArray.add("31");
        productArray.add("41");
        productArray.add("51");
        productArray.add(null);

        System.out.println("----------несуществующий");
        System.out.println(productArray.get(8));

        System.out.println("----------все элементы");
        for (String s : productArray) {
            System.out.println(s);
        }

        System.out.println("----------добавить коллекцию к коллекции");
        List<String> list = new ArrayCustom<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        productArray.addAll(list);
        for (String s : productArray) {
            System.out.println(s);
        }

        System.out.println("----------обновление элемента");
        System.out.println(productArray.set(6,"100"));

        System.out.println("----------размер");
        System.out.println(productArray.size());

        System.out.println("----------удаление по элементу");
        System.out.println(productArray.remove("21"));

        System.out.println("----------удаление по индексу");
        System.out.println(productArray.remove(0));

        System.out.println("----------поиск по элементу");
        System.out.println(productArray.find("3"));

        System.out.println("----------поиск по индексу");
        System.out.println(productArray.get(6));

        System.out.println("----------массив элементов");
        System.out.println(Arrays.toString(productArray.toArray()));

        System.out.println("----------");
        for (String value : productArray) {
            System.out.println(value);
        }

        System.out.println("----------trim");
        productArray.trim();
        for (String value : productArray) {
            System.out.println(value);
        }

        System.out.println("----------clear");
        productArray.clear();


        System.out.println(productArray.size());
        System.out.println("----------");

    }
}
