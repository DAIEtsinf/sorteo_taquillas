package lib;

import java.util.ArrayList;
import java.util.Collection;

public class MArrayList<E> extends ArrayList implements MList {

    /**
     * Constructor method of the class.
     */
    public MArrayList() {
        super();
    }

    /**
     * Constructor method of the class.
     * @param c Collection of elements.
     */
    public MArrayList(Collection c) {
        super(c);
    }

    /**
     * Constructor methos of the class.
     * @param initialCapacity represents the initial capacity of the list.
     */
    public MArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Method wich clones this object
     * @return an exact copy of this object. The objects inside the list are not
     * copied.
     */
    @Override
    public MArrayList clone() {
        MArrayList res = new MArrayList();

        for (Object a : this) {
            res.add(a);
        }

        return res;
    }

    /**
     * Method for changin the order of the elements contained in the list.
     * @return MArrayList with the elements of this list in a random order.
     */
    public MArrayList randomize() {
        MArrayList res = new MArrayList();
        MArrayList aux = clone();
        int r;

        while (!aux.isEmpty()) {
            r = (int) (Math.random() * aux.size());
            res.add(aux.get(r));
            aux.remove(r);
        }

        return res;
    }

    /**
     * This methor removes duplicated elements contained in the list.
     * @return MArrayList with no duplicate elements.
     */
    @Override
    public MArrayList removeDuplicates() {
        MArrayList res = new MArrayList();

        for (Object a : this) {
            if (!res.contains(a)) {
                res.add(a);
            }
        }

        return res;
    }

    /**
     * This method returns the elements wich are not in both lists.
     * @param l list wich is compared to this one.
     * @return MList wich contais the elements wich are not in both lists.
     */
    @Override
    public MList difference(MList l) {
        MArrayList res = new MArrayList();

        for (Object o : l) {
            if (!this.contains(o)) {
                res.add(o);
            }
        }
        
        for (Object o : this) {
            if (!l.contains(o)) {
                res.add(o);
            }
        }

        return res;
    }
    
    /**
     * Method wich returns a list wich is a copy of this one but have not got
     * the elements in l list.
     * @param l list where we search for the elements to remove in this list.
     * @return MList wich not contains elements in l.
     */
    @Override
    public MList removeElements(MList l){
        MArrayList res = this.clone();
        for (Object o : l) {
            while (res.contains(o)) {
                res.remove(o);
            }
        }
        return res;
    }

}
