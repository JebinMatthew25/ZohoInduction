import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestChain {
    private Integer[][] pairs;
    private Integer N;

    LongestChain(Integer[][] pairs)
    {
        this.pairs = pairs;
        N = pairs.length;
    }

    public void get_longest() {
        Integer[] best = new Integer[N];
        Arrays.fill(best, -1);
        Integer max = 0;



    }
}
