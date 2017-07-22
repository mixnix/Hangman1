import Interfaces.ControllerInterface;
import Interfaces.GameStates;
import Interfaces.WisielecModelInterface;

import javax.naming.ldap.Control;

/**
 * Created by user_name on 18.07.2017.
 */
public class Controller implements ControllerInterface {
    WisielecModelInterface model;
    WisielecView view;

    public Controller(WisielecModelInterface model){
        this.model = model;
        view = new WisielecView(this, model);
        view.createView();
        view.createControls();
    }

    public void startGry(){
        model.initializeWithRandom();
    }
    public void wprowadzenieLiterki(char c){
        model.enterLetter(c);
        model.checkForWin();
        if(model.getGameState().equals(GameStates.WIN)){
            koniecGry(GameStates.WIN);
        } else if(model.getGameState().equals(GameStates.LOSE)){
            koniecGry(GameStates.LOSE);
        }

    }
    public void koniecGry(GameStates gs){
        view.koniecGry(gs);
    }

}
