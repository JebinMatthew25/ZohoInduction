import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class FormLines {
    ArrayList<SimpleEntry<String, Integer>> words = new ArrayList<>();
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
            words.add(new SimpleEntry<>(str, val));
        }
        words.sort(Comparator.comparingInt(SimpleEntry::getValue));
        Collections.reverse(words);
//        words = words.entrySet().stream().sorted(Map.Entry.comparingByValue())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));

        for (SimpleEntry<String, Integer> k: words)
            System.out.printf("%s %d\n", k.getKey(), k.getValue());
    }

    void process()
    {
        SimpleEntry temp;

        while (!words.isEmpty())
        {
            temp  = words.remove(0);
        }
    }
}
