package collectionHierarchy.models;

import collectionHierarchy.interfaces.Addable;

public class AddCollection extends Collection implements Addable {
    @Override
    public int add(String element) {
        this.items.add(element);
        return this.items.size() - 1;
    }
}
