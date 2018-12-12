public class QueenStrikesAgainDriver {
    public static void main(String[] args){
        QueenStrikesAgain game = new QueenStrikesAgain(4,5);
        game.show();
        game.add_queen(new Integer[] {1,1});
        game.show();
        game.add_obstacles(2, new Integer[][] {{0,1}, {2,2}});
        game.show();
        game.attack();
    }
}
