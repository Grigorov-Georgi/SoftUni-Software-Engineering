package collectionHierarchy.models;

import collectionHierarchy.interfaces.AddRemovable;
import collectionHierarchy.interfaces.Addable;

public class AddRemoveCollection extends Collection implements AddRemovable {
    @Override
    public String remove() {
        return this.items.remove(this.items.size() - 1);
    }

    @Override
    public int add(String element) {
        this.items.add(0, element);
        return 0;
    }
}
