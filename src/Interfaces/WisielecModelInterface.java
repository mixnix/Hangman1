package Interfaces;

import java.util.ArrayList;

/**
 * Created by user_name on 18.07.2017.
 */
public interface WisielecModelInterface {
    void initializeWithRandom();
    void initialize(String word);

    String getWord();
    String getDisplayWord();
    ArrayList getCorrectAnswers();
    GameStates getGameState();

    void enterLetter(char c);
    void checkForWin();
    int getIncorrectGuesses();

    void registerObserver(WisielecObserver o);
    void removeObserver(WisielecObserver o);
}
