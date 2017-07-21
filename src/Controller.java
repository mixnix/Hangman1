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
    }

    public void startGry(){

    }
    public void wprowadzenieLiterki(){

    }
    public void koniecGry(){

    }

}
