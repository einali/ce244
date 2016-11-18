/**
 * Created by Teaching on 10/5/2015.
 */
public class TicTacToe {

    static char[][] table=new char[3][3];
    static  char mySymbol=' ';
    static  char opponentSymbol=' ';

    public static void main(String[] args) {
        init();
        getOpponentSymbol();
        boolean continuePlay=true;

        while (true){
            getOpponentMove();
            boolean finished= isGameFinished();
            if(finished){
                break;
            }
            playComputerTurn();
            finished= isGameFinished();
            if(finished){
                int i = whoIsTheWinner();
                System.out.println(i);
                break;
            }
        }



    }

    /**
     *
     * @return 1 for computer, 2 for opponent, 3 for tie
     */
    private static int whoIsTheWinner() {
        return 1;
    }
    private static boolean isGameFinished() {

        return false;
    }

    private static void init() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3; j++) {
                table[i][j]=' ';
            }
        }
    }


    public static void displayGameSpace(){


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3; j++) {
                System.out.print(table[i][j]);
                if(j!=2){
                    System.out.print("|");
                }
            }
            if(i!=2){
                System.out.println("---");
            }
        }

    }


    public static void getOpponentMove(){

    }
    public static void getOpponentSymbol(){

    }

    public static void playComputerTurn(){

    }
}
