import jebinmatt.util.MyIntPair;
import jebinmatt.util.MyList;

class LongestChain {
    private MyList<MyIntPair> pairs = new MyList<>();
    private MyList best = new MyList();

    LongestChain(Integer[][] pairs)
    {
        for (Integer[] k : pairs)
            this.pairs.add(new MyIntPair(k[0], k[1]));
    }

    private void rec(MyList<MyIntPair> left, MyList<MyIntPair> right)
    {
        if(left.size() > best.size())
            best = left;
        for (int i = 0; i < right.size(); i++)
            if(left.get(left.size()-1).getValue() < right.get(i).getKey())
                rec(left.plus(right.subList(i, i+1)), right.invertedSubList(i, i+1));
    }

    void get_longest() {
        System.out.println(pairs);
        for (int i = 0; i < pairs.size(); i++)
            rec(pairs.subList(i, i+1), pairs.invertedSubList(i, i+1));
        System.out.print("Best: ");
        System.out.println(best);
    }
}

class LongestChainDriver {
    public static void main(String[] args)
    {
        LongestChain obj = new LongestChain(new Integer[][]
                {{39, 60}, {15, 28}, {27, 40}, {50, 90}, {5, 24}});
        obj.get_longest();
    }
}
