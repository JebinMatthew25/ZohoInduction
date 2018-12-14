package jebinmatt.util;

import java.util.AbstractMap;

public class MyStrInt extends AbstractMap.SimpleEntry<String, Integer> {
    public MyStrInt(String key, Integer value) {
        super(key, value);
    }
    public String toString() {
        return String.format("(%s, %d)", getKey(), getValue());
    }

    public static Integer sum(MyList<MyStrInt> list)
    {
        Integer tot = 0;
        for (MyStrInt k :list)
            tot += k.getValue();

        return tot;
    }
}
