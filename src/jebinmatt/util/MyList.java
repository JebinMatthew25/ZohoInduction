package jebinmatt.util;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyList<T> extends ArrayList<T> {

    public MyList<T> invertedSubList(int start, int end)
    {
        MyList<T> temp = new MyList<>();
        temp.addAll(super.subList(0,start));
        temp.addAll(super.subList(end, size()));
        return temp;
    }

    public MyList<T> subList(int fromIndex, int toIndex)
    {
        MyList<T> temp = new MyList<>();
        temp.addAll(super.subList(fromIndex, toIndex));
        return temp;
    }

    public MyList<T> plus(MyList<T> other) {
        MyList<T> temp = new MyList<>();
        temp.addAll(super.subList(0, size()));
        temp.addAll(other);
        return temp;
    }

//    public Number sum(Boolean sum_by_key) {
//        Number tot;
//        if(sum_by_key)
//            tot = stream().collect(Collectors.toList(T::getValue()));
//
//        return tot;
//    }
}
