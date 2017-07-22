import Interfaces.ControllerInterface;
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

    }
    public void koniecGry(){
        view.koniecGry();
    }

}
