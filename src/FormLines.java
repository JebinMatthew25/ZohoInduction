import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyPair extends SimpleEntry<String, Integer> {
    public MyPair(String key, Integer value) {
        super(key, value);
    }
}

class FormLines {
    private ArrayList<MyPair> words = new ArrayList<>();
    private Integer max_len;

    FormLines(Integer max_len, Character spl_ch, String[] arr)
    {
        this.max_len = max_len;
        for(String str: arr)
        {
            int val = 0;
            for (int i = 0; i < str.length(); i++)
            {
                if(Character.toLowerCase(str.charAt(i)) != spl_ch)
                    val += 1;
            }
            words.add(new MyPair(str, val));
        }
        words.sort(Comparator.comparingInt(MyPair::getValue));
        Collections.reverse(words);
//        words = words.entrySet().stream().sorted(Map.Entry.comparingByValue())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));

        for (MyPair k: words)
            System.out.printf("%s %d\n", k.getKey(), k.getValue());
    }

    void process() {
        MyPair temp = null;
        StringBuilder res = new StringBuilder();

        while (!words.isEmpty()) {
            temp = words.remove(0);
            if (words.isEmpty())
                break;
            for (MyPair k : words) {
                if (k.getValue() == max_len - temp.getValue()) {

                    res.append(String.format("%s %s (%d)\n", temp.getKey(),
                            k.getKey(), temp.getValue()+k.getValue()));
                    temp = null;
                    words.remove(k);
                    break;
                }
            }
            if (temp != null) {
                for (MyPair k : words) {
                    if (k.getValue() + temp.getValue() < max_len) {
                        res.append(String.format("%s %s (%d)\n", temp.getKey(),
                                k.getKey(), temp.getValue()+k.getValue()));
                        temp = null;
                        words.remove(k);
                        break;
                    }
                }
            }
        }
        if (temp != null)
            res.append(String.format("%s (%d)\n", temp.getKey(), temp.getValue());

        System.out.println(res);
    }
}
