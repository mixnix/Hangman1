import Interfaces.GameStates;
import Interfaces.WisielecModelInterface;
import Interfaces.WisielecObserver;

import java.util.ArrayList;

/**
 * Created by user_name on 18.07.2017.
 */
public class WisielecModel implements WisielecModelInterface {
    //pola
    String word;
    ArrayList<Integer> correctAnswers;
    int incorrectGuesses;
    ArrayList wisielecObservers;

    //todo: potem tutaj bedzie inicjalizacja z pliku
    public void initializeWithRandom(){
        word = "matula";
        correctAnswers = new ArrayList<Integer>();
        incorrectGuesses = 0;
        wisielecObservers = new ArrayList();
    }

    public void initialize(String word){
        this.word = word;
        correctAnswers = new ArrayList<Integer>();
        incorrectGuesses = 0;
        wisielecObservers = new ArrayList();
    }

    public String getWord(){
        return word;
    }

    public ArrayList getCorrectAnswers(){
        return correctAnswers;
    }

    public void enterLetter(char c){
        char[] charArray = word.toCharArray();
        boolean hasLetter = false;
        for(int i = 0; i < charArray.length; i++){
            if( charArray[i] == c ){
                hasLetter = true;
                correctAnswers.add(i);
            }
        }
        if(!hasLetter)
            incorrectGuesses++;
    }

    public GameStates checkForWin(){
        if(incorrectGuesses >= 7)
            return GameStates.LOSE;
        if(correctAnswers.size() == word.length())
            return GameStates.WIN;
        else
            return GameStates.IN_PROGRESS;
    }

    public void registerObserver(WisielecObserver o){
        wisielecObservers.add(o);
    }
    public void removeObserver(WisielecObserver o){
        wisielecObservers.remove(o);
    }
}
