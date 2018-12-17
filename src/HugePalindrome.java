import java.util.HashMap;
import java.util.Map;

public class HugePalindrome {
    String seq;
    Map<Character, Integer> count = new HashMap<Character, Integer>();
    Character middle;
    String palindrome;

    HugePalindrome(String seq)
    {
        this.seq = seq;
        for (int i=0; i<seq.length(); i++)
        {
            char k = seq.charAt(i);
            if(!Character.isLetter(k))
                continue;
            k = Character.toLowerCase(k);
            count.putIfAbsent(k, 0);
            count.put(k, count.get(k)+1);
        }
    }

    void show_count()
    {
        for (Character ch: count.keySet())
            System.out.println(ch.toString() + ' ' + count.get(ch));
        System.out.println();
    }

    void pre_process()
    {
        Boolean got = false;
        for (Character ch: count.keySet())
        {
            if(got)
                count.put(ch, count.get(ch)&0xFE);
            else if((count.get(ch) & 1) == 1)
            {
                got = true;
                middle = ch;
                count.put(ch, count.get(ch)&0xFE);
            }
        }
    }

    void show_palindrome()
    {
        if(palindrome.equals(""))
            System.out.println("Make the palindrome by calling make_palindrome!");
        else
            System.out.println(palindrome);
    }

    void make_palindrome()
    {
        StringBuilder left = new StringBuilder();

        for (Character ch: count.keySet())
            for (int i =0; i< count.get(ch)/2; i++)
                left.append(ch);

        palindrome = left.toString() + middle + left.reverse();
    }
}


class HugePalindromeDriver {
    public static void main(String[] args)
    {
        HugePalindrome obj = new HugePalindrome("Hello World");
        obj.show_count();
        obj.pre_process();
        obj.show_count();
        obj.make_palindrome();
        obj.show_palindrome();
    }
}
