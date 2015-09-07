package lib;

import java.util.List;

public interface MList<E> extends List{
    public MList randomize();
    public MList removeDuplicates();
    public MList difference(MList l);
    public MList removeElements(MList l);
}
