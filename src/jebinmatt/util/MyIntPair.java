package jebinmatt.util;

import java.util.AbstractMap;

public class MyIntPair extends AbstractMap.SimpleEntry<Integer, Integer> {
    public MyIntPair(Integer key, Integer value) {
        super(key, value);
    }

    public String toString()
    {
        return String.format("(%d, %d)", getKey(), getValue());
    }
}
