package collectionHierarchy.models;

import collectionHierarchy.interfaces.MyList;

public class MyListImpl extends Collection implements MyList {
    @Override
    public int getUsed() {
        return this.items.size();
    }

    @Override
    public String remove() {
        return this.items.remove(0);
    }

    @Override
    public int add(String element) {
        this.items.add(0, element);
        return 0;
    }
}
