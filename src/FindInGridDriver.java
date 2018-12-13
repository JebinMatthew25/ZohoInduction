public class FindInGridDriver {
    public static void main(String[] args)
    {
        FindInGrid obj = new FindInGrid(new Character[][]
                {
                        {'P', 'W', 'K', 'C', 'T'},
                        {'B', 'O', 'F', 'A', 'L'},
                        {'O', 'O', 'E', 'R', 'M'},
                        {'X', 'L', 'A', 'T', 'E'},
                        {'A', 'C', 'O', 'T', 'N'}
                });

        String[] test_cases = new String[]{"POET", "CART", "LATE", "TEAL", "MEN",
                "BOX", "ROAM", "BOAT", "FOX", "WOOL", "COT"};
        for(String s: test_cases)
            obj.find(s);
    }
}
