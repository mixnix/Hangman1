package Interfaces;

import java.util.ArrayList;

/**
 * Created by user_name on 18.07.2017.
 */
public interface WisielecModelInterface {
    void initialize();

    String getWord();
    ArrayList getValidIndexes();

    void enterLetter(char c);
    void checkForWin();

    void registerObserver(WisielecObserver o);
    void removeObserver(WisielecObserver o);
}
