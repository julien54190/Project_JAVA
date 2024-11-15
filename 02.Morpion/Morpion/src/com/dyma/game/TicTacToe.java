package com.dyma.game;

import static com.dyma.game.StringConstants.LINE_SEPARATOR;
import static com.dyma.game.StringConstants.SPACE;

public class TicTacToe {

    private char [][] grid = new char[][]{
        {'.', '.', '.'},
        {'.', '.', '.'},
        {'.', '.', '.'}
    };

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
