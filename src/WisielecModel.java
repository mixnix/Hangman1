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
    ArrayList<Integer> correctAnswers = new ArrayList<Integer>();
    int incorrectGuesses = 0;
    ArrayList wisielecObservers = new ArrayList();
    GameStates stanGry;

    //todo: potem tutaj bedzie inicjalizacja z pliku
    public void initializeWithRandom(){
        word = "matula";
        notifyWisielecObservers();
    }

    public void initialize(String word){
        this.word = word;
        notifyWisielecObservers();
    }

    public String getWord(){
        return word;
    }

    public String getDisplayWord(){
        String toDisplay = "";

        for(int i = 0; i < word.length(); i++){
            boolean wstawicLiterke = false;
            for(int j = 0; j < correctAnswers.size(); j++){
                if(correctAnswers.get(j) == i)
                    wstawicLiterke = true;
            }
            if(wstawicLiterke){
                toDisplay = toDisplay + word.charAt(i) + " ";
            }else{
                toDisplay = toDisplay + "_ ";
            }

        }
        return toDisplay;
    }

    public ArrayList getCorrectAnswers(){
        return correctAnswers;
    }

    public int getIncorrectGuesses(){ return incorrectGuesses; }

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
        notifyWisielecObservers();
    }

    public void checkForWin(){
        if(incorrectGuesses >= 7)
            stanGry = GameStates.LOSE;
        if(correctAnswers.size() == word.length())
            stanGry = GameStates.WIN;
        else
            stanGry = GameStates.IN_PROGRESS;
        notifyWisielecObservers();
    }

    public void registerObserver(WisielecObserver o){
        wisielecObservers.add(o);
    }
    public void removeObserver(WisielecObserver o){
        wisielecObservers.remove(o);
    }


    public void notifyWisielecObservers(){
        for(int i = 0; i < wisielecObservers.size(); i++){
            WisielecObserver observer = (WisielecObserver) wisielecObservers.get(i);
            observer.updateGame();
        }
    }
}
