package ru.clevertec.homework.collections;


import java.util.*;

public class ArrayCustom<E> extends AbstractList<E> {

    private E[] o;
    private int count;

    public ArrayCustom(E[] array) {
        this.o = array;
        this.count = array.length;
    }

    public ArrayCustom() {
        o = (E[]) new Object[10];
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public Object[] toArray() {
        return o;
    }

    public boolean remove(Object o) {
        for (int index = 0; index < count; index++) {
            if (o.equals(this.o[index])) {
                remove(index);
                return true;
            }
        }
        return false;
    }

    public E remove(int index) {
        E e = get(index);
        int num = count - index - 1;
        if (num > 0) {
            System.arraycopy(o, index + 1, o, index, num);
        }
        count--;
        o[count] = null;
        return e;
    }

    public void clear() {
        count = 0;
        o = (E[]) new Object[10];
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof List)) {
            return false;
        }
        return (o.getClass() == ArrayList.class);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(o);
    }

    public E get(int index) {
        if (contains(index)) {
            return o[index];
        }
        return null;
    }

    public int find(Object obj) {
        for (int i = 0; i < o.length; i++) {
            if (o[i] == obj) {
                return i;
            }
        }
        return -1;
    }

    public E set(int index, E element) {
        if (index <= o.length) {
            o[index] = element;
            return element;
        }
        return null;
    }

    public boolean add(E e) {
        if (o.length == count) {
            Object o1 = o;
            o1 = new Object[o.length * 2];
            System.arraycopy(o, 0, o1, 0, o.length);
        }
        o[count] = e;
        count++;
        return false;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        int size = toIndex - fromIndex;
        List<E> f = new ArrayCustom<>();
        for (int i = 0; i < size; i++) {
            f.add(get(i));
        }
        return f;
    }

    public void setMaxSize(int size) {
        o = (E[]) new Object[size];
    }

    public void trim() {
        for (int i = 0; i < size(); i++) {
            if (o[i] == null) {
                remove(i);
            }
        }
    }

    public boolean contains(int index) {
        return o[index] != null;
    }

    public boolean addAll(Collection<? extends E> c) {
        E[] c1 = (E[]) c.toArray();

        E[] result = Arrays.copyOf(o, count + c.size());
        int count1 = count + c.size();
        System.arraycopy(c1, 0, result, count, c.size());
        count = count1;
        o = result;
        return true;
    }
//    public boolean hasNext() {
//        return contains(position + 1);
//    }


}
