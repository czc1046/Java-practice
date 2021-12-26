import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyConnectFour {

    public static void main(String[] args){
        MyConnectFour game = new MyConnectFour();//Instantiation, new MyConnectFour called game
        game.playGame(game.board);
    }

    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private char[][] board = new char[6][7];

    public void myConnectFour() {
    }

    private void playGame(char[][] board){
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("Player 1 is Red, Player 2 is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in") ;
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("");
        printBoard();
        boolean win = false;
        while(!win){
            // player 1
            System.out.println("It's Player1 turn");
            System.out.println("Please input X position from 0-6:");
            String player1Input1 = getUserInput();
            int player1MoveX = Integer.parseInt(player1Input1);
            System.out.println("Please input Y position from 0-4:");
            String player1Input2 = getUserInput();
            int player1MoveY = Integer.parseInt(player1Input2);
            placeCounter('r',player1MoveX,player1MoveY);
            boolean hasWon = false;
            int count = 0;
            // check horizontal
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[i].length; j++){
                    if(board[i][j] == 'r'){
                        count = count + 1;
                        if(count >= 4){
                            hasWon = true;
                        }
                    }
                    else{
                        count = 0;
                    }
                }

            }
            // check vertical
            count = 0;
            for(int i=0; i<board[0].length; i++){
                for(int j=0; j<board.length; j++){
                    if(board[j][i] == 'r'){
                        count = count + 1;
                        if(count >= 4){
                            hasWon = true;
                        }
                    }
                    else{
                        count = 0;
                    }
                }

            }

            // check upward slope
            count = 0;
            for (int i=3; i<board.length; i++){
                for(int j=0; j<board[i].length-3; j++){
                    if(board[i][j]=='r' && board[i-1][j+1]=='r' && board[i-2][j+2]=='r' && board[i-3][j+3]=='r'){
                        hasWon = true;
                    }
                }
            }

            // check downward slope
            for (int i=0; i<board.length-3; i++){
                for(int j=0; j<board[i].length-3; j++){
                    if(board[i][j]=='r' && board[i+1][j+1]=='r' && board[i+2][j+2]=='r' && board[i+3][j+3]=='r'){
                        hasWon = true;
                    }
                }
            }

            printBoard();
            if(hasWon){
                win = true;
                System.out.println("Player1 Have Won!!!");
            }
            else{
                //player 2
                System.out.println("It's Player2 turn");
                System.out.println("Please input X position from 0-6:");
                String player2Input1 = getUserInput();
                int player2MoveX = Integer.parseInt(player2Input1);
                System.out.println("Please input Y position from 0-4:");
                String player2Input2 = getUserInput();
                int player2MoveY = Integer.parseInt(player2Input2);
                placeCounter('y',player2MoveX,player2MoveY);
                hasWon = false;
                count = 0;
                // check horizontal
                for(int i=0; i<board.length; i++){
                    for(int j=0; j<board[i].length; j++){
                        if(board[i][j] == 'y'){
                            count = count + 1;
                            if(count >= 4){
                                hasWon = true;
                            }
                        }
                        else{
                            count = 0;
                        }
                    }

                }
                // check vertical
                count = 0;
                for(int i=0; i<board[0].length; i++){
                    for(int j=0; j<board.length; j++){
                        if(board[j][i] == 'y'){
                            count = count + 1;
                            if(count >= 4){
                                hasWon = true;
                            }
                        }
                        else{
                            count = 0;
                        }
                    }
                }

                // check upward slope
                count = 0;
               for (int i=3; i<board.length; i++){
                    for(int j=0; j<board[i].length-3; j++){
                        if(board[i][j]=='y' && board[i-1][j+1]=='y' && board[i-2][j+2]=='y' && board[i-3][j+3]=='y'){
                            hasWon = true;
                        }
                    }
                }

               // check downward slope
                for (int i=0; i<board.length-3; i++){
                    for(int j=0; j<board[i].length-3; j++){
                        if(board[i][j]=='y' && board[i+1][j+1]=='y' && board[i+2][j+2]=='y' && board[i+3][j+3]=='y'){
                            hasWon = true;
                        }
                    }
                }


                printBoard();
                if(hasWon){
                    System.out.println("Player2 Have Won!!!");
                    win = true;
                }
            }
        }

    }

    private String getUserInput(){
        String toReturn = null;
        try{
            toReturn = input.readLine();
        }
        catch(Exception e){

        }
        return toReturn;
    }

    private void printBoard(){
        for(int i=0; i<board.length-1; i++){
            for(int j=0; j<board[i].length-1; j++){
                if(board[j][i] == 'r'){
                    System.out.print("| r ");
                }
                else if(board[j][i] == 'y'){
                    System.out.print("| y ");
                }
                else{
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("  0   1   2   3   4   5   6");
    }

    private void placeCounter(char player, int x, int y) {
        boolean placed = false;
        if (player == 'r') {
            if (board[x][y] != 'r' && board[x][y] != 'y') {
                board[x][y] = 'r';
            }else{
                System.out.println("This position is occupied, please input agian!");
                System.out.println("Please re-input X position:");
                String player1Input1 = getUserInput();
                int player1MoveX = Integer.parseInt(player1Input1);
                System.out.println("Please re-input Y position:");
                String player1Input2 = getUserInput();
                int player1MoveY = Integer.parseInt(player1Input2);
                placeCounter('r',player1MoveX,player1MoveY);
            }
        } else {
            if (board[x][y] != 'r' && board[x][y] != 'y') {
                board[x][y] = 'y';
            }else{
                System.out.println("This position is occupied, please input agian!");
                System.out.println("Please re-input X position:");
                String player1Input1 = getUserInput();
                int player1MoveX = Integer.parseInt(player1Input1);
                System.out.println("Please re-input Y position:");
                String player1Input2 = getUserInput();
                int player1MoveY = Integer.parseInt(player1Input2);
                placeCounter('y',player1MoveX,player1MoveY);
            }
        }
    }
}
