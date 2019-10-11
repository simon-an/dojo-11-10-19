package de.metafinanz.codingdojo;

import java.io.PrintStream;
import java.util.StringJoiner;
import java.util.Vector;

public class Game {

    char EMPTY = ' ';
    char Player1 = 'O';
    char Player2 = 'X';

    boolean player1Turn = true;

    char board[][] = { { EMPTY, EMPTY, EMPTY }, { EMPTY, EMPTY, EMPTY }, { EMPTY, EMPTY, EMPTY } };

    public void print(PrintStream out) {
        out.println(this.toString());
    }

    String checkGameWon() {

        if (board[1][1] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return getPlayer(board[1][1]);
        }
        if (board[1][1] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return getPlayer(board[1][1]);
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return getPlayer(board[i][1]);
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return getPlayer(board[1][i]);
            }
        }

        return null;
    }

    String getPlayer(Character player) {
        if (player == Player1) {
            return "Player1 has won";
        }
        return "Player2 has won";
    }

    public void playerTurn(Vector<Character> coordinates) throws IllegalStateException {

        int index1 = coordinates.firstElement() - 65;
        int index2 = coordinates.get(1) - 48;
        if (this.board[index2][index1] == ' ') {
            if (player1Turn) {
                this.board[index2][index1] = Player1;
            } else {
                this.board[index2][index1] = Player2;
            }
        } else {
            throw new IllegalStateException("Field occupied");
        }

        player1Turn = !player1Turn;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" A B C\n");
        int counter = 0;
        for (char[] line : board) {
            sb.append(counter++);

            StringJoiner joiner = new StringJoiner("|");
            for (char field : line) {
                joiner.add("" + field);
            }
            sb.append(joiner.toString());
            if (counter < 3) {
                sb.append("\n -+-+- \n");
            }
        }
        return sb.toString();
    }

}