package oata;

import java.util.*;

public class TicTacToe {
    private char[][] board;

    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        currentPlayer = 'X';
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            System.out.println("Invalid move, try again.");
            return;
        }
        if (board[row][col] != '-') {
            System.out.println("Spot already taken, try again.");
            return;
        }
        board[row][col] = currentPlayer;
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();  
        Scanner gol = new Scanner(System.in);
        while (true) {
            game.printBoard();
            System.out.println("Player " + game.currentPlayer + "'s turn. Enter row and column:");
            int row = gol.nextInt();
            int col = gol.nextInt();
            game.makeMove(row, col);
            if (game.checkWin()) {
                game.printBoard();
                System.out.println("Player " + game.currentPlayer + " wins!");
                break;
            }
        }
    }
}