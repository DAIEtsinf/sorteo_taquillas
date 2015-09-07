package lib;

import java.util.ArrayList;
import java.util.Collection;

public class MArrayList<E> extends ArrayList implements MList {

    public MArrayList() {
        super();
    }

    public MArrayList(Collection c) {
        super(c);
    }

    public MArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public MArrayList clone() {
        MArrayList res = new MArrayList();

        for (Object a : this) {
            res.add(a);
        }

        return res;
    }

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
    
    public MList removeElements(MList l){
        MArrayList res = this.clone();
        for(int i = 0; i<l.size();i++)
            while(res.contains(l.get(i)))
                res.remove(l.get(i));
        return res;
    }

}
