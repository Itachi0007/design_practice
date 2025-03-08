import java.util.Scanner;

public class TicTac {
    private Players player1;
    private Players player2;
    private char[][] board;
    private Players currPlayer;
    private static GameControls game;
    private static int x;
    private static int y;

    public void playNewGame() {
        getPlayers();
        Scanner scanner = new Scanner(System.in);
        board = new char[][]{{'.', '.', '.'}, {'.', '.', '.'}, {'.', '.', '.'}};
        currPlayer = player1;
        while(true) {
            printBoard(board);

            System.out.println("Player " + currPlayer.getSymbol() + "'s turn");
            System.out.println("Enter row (0, 1, or 2): ");
            x = scanner.nextInt();
            System.out.println("Enter column (0, 1, or 2): ");
            y = scanner.nextInt();
            if(!game.checkMove(board, x, y)) {
                System.out.println("Invalid spot");
                continue;
            }

            board[x][y]=currPlayer.getSymbol();
            if(game.checkWin(board, currPlayer.getSymbol())) {
                printBoard(board);
                System.out.println(currPlayer.getName() + " you win");
                break;
            }

            if(currPlayer.equals(player1)) currPlayer = player2;
            else currPlayer = player1;
        }
    }

    private void printBoard(char[][] board) {
        for(int i=0;i<3;i++) {
            System.out.print('|');
            for(int j=0;j<3;j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println('|');
        }

    }

    public void getPlayers() {
        System.out.println("Player X name: ");
        Scanner scanner = new Scanner(System.in);
        String p1 = scanner.nextLine();
        this.player1 = new Players(p1, 'X');

        System.out.println("Player O name: ");
        String p2 = scanner.nextLine();
        this.player2 = new Players(p2, 'O');
    }
}
