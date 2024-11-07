package comDymaGame;

import java.util.ArrayList;
import java.util.List;

public class GuessGame {

    private final List<Character> secretWord = new ArrayList<>();
    private int lifePoints;
    private final List<Character> guessWord = new ArrayList<>();

    public GuessGame(String secretWord, int lifePoints) {
        for (char c : secretWord.toCharArray()) {
            this.secretWord.add(c);
        }
        this.lifePoints = lifePoints;
        for (int index = 0; index < secretWord.length(); index++) {
            this.guessWord.add('_');
        }
    }

    @Override
    public String toString() {
        return "mot à deviner : " + guessWord +
                " | points de vie : " + lifePoints;
    }

    public void guessLetter(char letter) {
        if (secretWord.contains(letter) && !guessWord.contains(letter)) {
            for (int index = 0; index < secretWord.size(); index++) {
                if (secretWord.get(index) == letter) {
                    guessWord.set(index, letter);
                }
            }
        } else if (!secretWord.contains(letter) && guessWord.contains(letter)) {
    } else {
        lifePoints--;
    }
}

    public boolean isLost() {
        return lifePoints <= 0;
    }

    public boolean isWon() {
        return !guessWord.contains('_');
    }
}