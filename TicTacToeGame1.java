import java.util.Scanner;

public class TicTacToeGame1 {
    private static char[][] board = new char[3][3]; // array to represent the game board
    private static char currentPlayer = 'X'; // The current player ('X' or 'O')

    public static void main(String[] args) {
        initializeBoard(); // Initialize the game board with empty spaces
        displayBoard(); // Display the initial game board
        playGame(); // Start the game
    }

    public static void initializeBoard() {
        // Initialize the game board with empty spaces ('-')
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void displayBoard() {
        // Display the current state of the game board
        System.out.println("Tic Tac Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void playGame() {
        boolean gameFinished = false; // A flag to track if the game has finished
        Scanner scanner = new Scanner(System.in);

        while (!gameFinished) {
            System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                // Check if the player's move is valid (within the board and the cell is empty)
                board[row][col] = currentPlayer; // Place the player's symbol on the board
                displayBoard(); // Display the updated board

                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameFinished = true; // Game is finished
                } else if (checkDraw()) {
                    System.out.println("It's a draw!");
                    gameFinished = true; // Game is finished
                } else {
                    // Switch to the other player's turn
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    public static boolean checkWin() {
        // Check for a win by examining rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true; // Row win
            }
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true; // Column win
            }
        }
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true; // Diagonal win
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true; // Diagonal win
        }
        return false; // No win yet
    }

    public static boolean checkDraw() {
        // Check if the game is a draw (all cells are filled)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false; // There is an empty cell, the game is not a draw
                }
            }
        }
        return true; // All cells are filled, it's a draw
    }
}
