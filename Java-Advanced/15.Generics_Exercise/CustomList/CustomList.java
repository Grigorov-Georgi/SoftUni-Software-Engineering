package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<E extends Comparable<E>> {
    private List<E> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(E element) {
        this.data.add(element);
    }

    public E remove(int index) {
        E element = this.data.remove(index);
        return element;
    }

    public boolean contains(E element) {
        return this.data.contains(element);
    }

    public void swap(int index1, int index2) {
        E firstElement = this.data.get(index1);
        E secondElement = this.data.get(index2);
        this.data.set(index1, secondElement);
        this.data.set(index2, firstElement);
    }

    public int countGreaterThan(E element) {
        long countInLong = this.data.stream().filter(e -> e.compareTo(element) > 0).count();
        return (int) countInLong;
    }

    public void getMax() {
        System.out.println(Collections.max(data));
    }

    public void getMin() {
        System.out.println(Collections.min(data));
    }

    public void print() {
        for (E datum : data) {
            System.out.println(datum);
        }
    }

}
