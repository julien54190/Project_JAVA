package com.dyma.game;

import static com.dyma.game.StringConstants.LINE_SEPARATOR;
import static com.dyma.game.StringConstants.SPACE;

public class TicTacToe {

    private char [][] grid = new char[][]{
        {'.', '.', '.'},
        {'.', '.', '.'},
        {'.', '.', '.'}
    };

    public void processInput(Player player, int inputUser) {
        var row = (inputUser - 1) / 3;
        var column = (inputUser - 1) % 3;
        if (grid[row][column] == '.') {
            grid[row][column] = player.equals(Player.FIRST)? 'X' : 'O';
        } else {
            System.out.println("Cellule déjà occupée!");
        }
    }

    public boolean  checkwin() {
        for (int i = 0; i < 3; i++){
            var checkWinLine = grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][2] != '.';
            var checkWinColumn = grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[2][i] != '.';
            if (checkWinLine || checkWinColumn) {
                return true;
            }
        }
        var checkWinDiagonal1 = grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[2][2] != '.';
        var checkWinDiagonal2 = grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[2][0] != '.';
        if (checkWinDiagonal1 || checkWinDiagonal2) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder();
        builder.append("Grille du Morpion: ").append(LINE_SEPARATOR);
        for (char[] lines : grid) {
            for (char cell : lines) {
                builder.append(SPACE).append(cell).append(SPACE);
            }
            builder.append(LINE_SEPARATOR);
        }
        return builder.toString();
    }







    
}
