import Interfaces.ControllerInterface;
import Interfaces.WisielecModelInterface;
import Interfaces.WisielecObserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by user_name on 18.07.2017.
 */
public class WisielecView implements ActionListener, WisielecObserver {
    WisielecModelInterface model;
    ControllerInterface controller;

    public WisielecView(ControllerInterface controller, WisielecModelInterface model){
        this.controller = controller;
        this.model = model;
        model.registerObserver((WisielecObserver)this);
    }

    public void createView(){

    }

    public void createControls(){

    }

    public void actionPerformed(ActionEvent event){

    }

    public void updateGame(){

    }
}
