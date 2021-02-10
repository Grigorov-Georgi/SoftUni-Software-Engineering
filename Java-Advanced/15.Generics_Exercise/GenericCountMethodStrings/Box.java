package GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box(){
        this.values = new ArrayList<>();
    }

    public void addValue(T element){
        this.values.add(element);
    }

    public long countGreaterElements(T toCompare){
        long count = this.values.stream().filter(e -> e.compareTo(toCompare) > 0).count();
        return count;
    }
}
