import Interfaces.ControllerInterface;
import Interfaces.WisielecModelInterface;
import Interfaces.WisielecObserver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by user_name on 18.07.2017.
 */
public class WisielecView implements ActionListener, WisielecObserver {
    WisielecModelInterface model;
    ControllerInterface controller;

    //elementy widoku
    JFrame mainViewFrame;
    JPanel mainJPanel;
    //panel z obrazkiem
    JPanel panelHangmanPicture;
    BufferedImage imgHangmanPicture;
    JPanel panelScreenKeyboard;
    JPanel panelDisplayedWord;

    public WisielecView(ControllerInterface controller, WisielecModelInterface model){
        this.controller = controller;
        this.model = model;
        model.registerObserver((WisielecObserver)this);
    }

    public void createView(){
        //panel z obrazkiem
        try {
            //            imgHangmanPicture = ImageIO.read(new File("wisielec\\"+model.getIncorrectGuesses()+".png"));
            //w wersji testowej na sztywno wyswietla szosty obrazek
            //todo: usunac ten na sztywno wyswietlany
            imgHangmanPicture = ImageIO.read(new File("wisielec\\"+"6"+".png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(imgHangmanPicture));
        panelHangmanPicture = new JPanel(new GridLayout(1,1));
        panelHangmanPicture.add(picLabel);

        //panel z wyswietlanym zgadywanym slowem
        JLabel slowoLabel = new JLabel("sl owo _ _ testowe", SwingConstants.CENTER);

        panelDisplayedWord = new JPanel(new BorderLayout());
        panelDisplayedWord.add(slowoLabel, BorderLayout.CENTER);

        //glowny frame i panel
        mainJPanel = new JPanel(new GridLayout(2,2));
        mainJPanel.add(panelHangmanPicture);
        mainJPanel.add(panelDisplayedWord);

        mainViewFrame = new JFrame("Wisielec");
        mainViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainViewFrame.setSize(new Dimension(1000,500));
        mainViewFrame.getContentPane().add(mainJPanel, BorderLayout.CENTER);
        mainViewFrame.pack();
        mainViewFrame.setVisible(true);
    }

    public void createControls(){

    }

    public void actionPerformed(ActionEvent event){

    }

    public void updateGame(){

    }

    public void koniecGry(){

    }
}
