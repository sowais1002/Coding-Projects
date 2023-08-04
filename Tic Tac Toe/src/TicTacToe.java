import java.util.Scanner;

public class TicTacToe {

    final char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        for(int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                board[i][j] = ' ';
            }
        }
        currentPlayer ='X';
    }

    public void play(){
        Scanner sc = new Scanner(System.in);
        boolean gameWon = false;

        while (!gameWon && !isBoardFull()){
            System.out.println("Current Player: "+currentPlayer);
            System.out.println("Enter row (0-2) and column (0-2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if(board[row][col] == ' '){
                board[row][col] = currentPlayer;
                if(isWinningMove(row,col)){
                    gameWon = true;
                }else{
                    currentPlayer = (currentPlayer == 'X')? '0' : 'X';
                }
            }else{
                System.out.println("Cell is already occupied.");
            }
        }

        if (gameWon){
            System.out.println("Congratulations! Player "+currentPlayer+" has won");
        }else{
            System.out.println("It is a draw");
        }
    }

    private boolean isWinningMove(int row, int col){
        if(board[row][0] == currentPlayer && board[row][1]== currentPlayer && board[row][2] == currentPlayer){
            return true;
        }
        if(board[0][col] == currentPlayer && board[1][col]== currentPlayer && board[2][col] == currentPlayer){
            return true;
        }
        if(row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer){
            return true;
        }
        if(row + col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer){
            return true;
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
