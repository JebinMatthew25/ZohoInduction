public class HugePalindromeDriver {
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
