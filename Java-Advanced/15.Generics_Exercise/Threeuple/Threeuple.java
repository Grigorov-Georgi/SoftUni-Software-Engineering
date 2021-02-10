package Threeuple;

public class Threeuple<K, V, V1> {
    private K firstParameter;
    private V secondParameter;
    private V1 thirdParameter;

    public Threeuple(K firstParameter, V secondParameter, V1 thirdParameter) {
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
        this.thirdParameter = thirdParameter;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.firstParameter, this.secondParameter, this.thirdParameter);
    }
}
