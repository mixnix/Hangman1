import Interfaces.ControllerInterface;
import Interfaces.WisielecModelInterface;

/**
 * Created by user_name on 18.07.2017.
 */
public class WisielecTest {
    public static void main(String[] args){
        WisielecModelInterface model = new WisielecModel();
        ControllerInterface controller = new Controller(model);
    }
}
