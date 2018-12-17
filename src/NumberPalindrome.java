class NumberPalindrome
{
    private Integer N;

    NumberPalindrome(Integer n){
        this.N = n;
    }

    private Integer reverse(Integer n)
    {
        int K = 0;

        while (n != 0)
        {
            K = 10*K + n%10;
            n = n/10;
        }

        return K;
    }

    void process()
    {
        Integer n = N;
        for (int i=0; i < 5; i++)
        {
            Integer rev = reverse(n);
            Integer sum = n+rev;
            System.out.printf("%d + %d = %d\n", n, rev, sum);
            if(sum.equals(reverse(sum)))
                break;
            n = sum;
        }
    }
}

class NumberPalindromeDriver {
    public static void main(String[] args)
    {
        NumberPalindrome obj = new NumberPalindrome(39);
        obj.process();
    }
}
