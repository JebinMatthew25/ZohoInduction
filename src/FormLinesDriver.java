public class FormLinesDriver {
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
