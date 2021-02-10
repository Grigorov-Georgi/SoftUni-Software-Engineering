package Tulpe;

public class Tulpe<K, V> {
    private K firstParameter;
    private V secondParameter;

    public Tulpe(K firstParameter, V secondParameter) {
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.firstParameter, this.secondParameter);
    }
}
