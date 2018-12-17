import jebinmatt.util.MyList;
import jebinmatt.util.MyStrInt;

import java.util.Collections;
import java.util.Comparator;


class FormLines {
    private MyList<MyStrInt> words = new MyList<>();
    private MyList<MyStrInt> best = null;
    private Integer max_len, best_max_len;
    private StringBuilder res = new StringBuilder();

    FormLines(Integer max_len, Character spl_ch, String[] arr) {
        this.max_len = max_len;
        for (String str : arr) {
            int val = 0;
            for (int i = 0; i < str.length(); i++) {
                if (Character.toLowerCase(str.charAt(i)) != spl_ch)
                    val += 1;
            }
            words.add(new MyStrInt(str, val));
        }
        words.sort(Comparator.comparingInt(MyStrInt::getValue));
        Collections.reverse(words);
//        words = words.entrySet().stream().sorted(Map.Entry.comparingByValue())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                        (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(words);
    }

    private void rec(MyList<MyStrInt> left, MyList<MyStrInt> right)
    {
        if(best == null)
        {
            Integer sum = MyStrInt.sum(left);
            if(sum.equals(max_len))
                best = left;

            for (int i = 0; i < right.size(); i++)
                if(sum + right.get(i).getValue() <= max_len)
                    rec(left.plus(right.subList(i, i+1)), right.invertedSubList(i, i+1));
        }
    }

    private void rec2(MyList<MyStrInt> left, MyList<MyStrInt> right)
    {
        Integer sum = MyStrInt.sum(left);
        if(sum > best_max_len)
            best = left;

        for (int i = 0; i < right.size(); i++)
            if(sum + right.get(i).getValue() <= max_len)
                rec2(left.plus(right.subList(i, i+1)), right.invertedSubList(i, i+1));
    }

    void process()
    {
        while (!words.isEmpty())
        {
            for (int i = 0; i < words.size(); i++)
                rec(words.subList(i, i+1), words.invertedSubList(i, i+1));
            if(best == null)
            {
                best_max_len = 0;
                for (int i = 0; i < words.size(); i++)
                    rec2(words.subList(i, i+1), words.invertedSubList(i, i+1));
                best.sort(Comparator.comparingInt(MyStrInt::getValue));
                Collections.reverse(best);
            }
            pack();
        }
        System.out.println(res);
    }

    private void pack()
    {
        Integer sum = MyStrInt.sum(best);
        for (MyStrInt k : best) {
            words.remove(k);
            res.append(k.getKey());
            res.append(' ');
        }
        res.append(String.format(" (%d)\n", sum));
        best = null;
    }
}

class FormLinesDriver {
    public static void main(String[] args)
    {
        FormLines obj = new FormLines(10, 'o',
                new String[]{"Zoho", "Eating", "Watching", "Pogo", "Loving", "Mango"});
        obj.process();

        FormLines obj2 = new FormLines(15, 'w',
                new String[]{"Twinkle", "Twinkle", "little", "star", "how", "I", "wonder", "what", "you", "are"});
        obj2.process();

    }
}
