import Interfaces.ControllerInterface;
import Interfaces.GameStates;
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
import java.util.ArrayList;

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
    JLabel picLabel;
    //klawiatura ekranowa
    JPanel panelScreenKeyboard;
    ArrayList<JButton> keyboardButtons = new ArrayList<>();
    //wyswietlane zgadywane slowo
    JPanel panelDisplayedWord;
    JLabel slowoLabel;
    //panel wyswietlany w przypadku wygranej gry
    JPanel endGamePanel;
    JLabel endGameLabel;

    public WisielecView(ControllerInterface controller, WisielecModelInterface model){
        this.controller = controller;
        this.model = model;
        model.registerObserver((WisielecObserver)this);
    }

    public void createView(){
        //panel z obrazkiem
        try {
            imgHangmanPicture = ImageIO.read(new File("wisielec\\"+model.getIncorrectGuesses()+".png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        picLabel = new JLabel(new ImageIcon(imgHangmanPicture));
        panelHangmanPicture = new JPanel(new GridLayout(1,1));
        panelHangmanPicture.add(picLabel);

        //panel z wyswietlanym zgadywanym slowem
        slowoLabel = new JLabel(model.getDisplayWord(), SwingConstants.CENTER);

        panelDisplayedWord = new JPanel(new BorderLayout());
        panelDisplayedWord.add(slowoLabel, BorderLayout.CENTER);

        //panel z wyswietlana klawiatura
        panelScreenKeyboard = new JPanel(new GridLayout(4, 8));
        String row2 = "aąbcćdeę";
        String row3 = "fghijklł";
        String row4 = "mnńoóprs";
        String row5 = "śtuwyzźż";
        String[] rows = { row2, row3, row4, row5 };
        for (int i = 0; i < rows.length; i++) {
            char[] keys = rows[i].toCharArray();
            for (int j = 0; j < keys.length; j++) {
                JButton button = new JButton(Character.toString(keys[j]));
                panelScreenKeyboard.add(button);
                keyboardButtons.add(button);
            }
        }


        //glowny frame i panel
        mainJPanel = new JPanel(new GridLayout(2,2));
        mainJPanel.add(panelHangmanPicture);
        mainJPanel.add(panelDisplayedWord);
        mainJPanel.add(panelScreenKeyboard);

        mainViewFrame = new JFrame("Wisielec");
        mainViewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainViewFrame.setSize(new Dimension(1000,500));
        mainViewFrame.getContentPane().add(mainJPanel, BorderLayout.CENTER);
        mainViewFrame.pack();
        mainViewFrame.setVisible(true);
    }

    public void createControls(){
        for(JButton b : keyboardButtons){
            char c = b.getText().toCharArray()[0];
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.wprowadzenieLiterki(c);
                }
            });
        }
    }

    public void actionPerformed(ActionEvent event){

    }

    public void updateGame(){
        if(!model.getGameState().equals(GameStates.IN_PROGRESS))
            return;
        slowoLabel.setText(model.getDisplayWord());
        try {
            imgHangmanPicture = ImageIO.read(new File("wisielec\\"+model.getIncorrectGuesses()+".png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        picLabel.setIcon(new ImageIcon(imgHangmanPicture));
    }

    public void koniecGry(GameStates a){
        mainViewFrame.remove(mainJPanel);

        if(a.equals(GameStates.WIN)){
            endGameLabel = new JLabel("Brawo, wygrałeś!", SwingConstants.CENTER);

        } else{
            endGameLabel = new JLabel("Brawo, przegrałeś!", SwingConstants.CENTER);

        }
        endGamePanel = new JPanel(new BorderLayout());
        endGamePanel.add(endGameLabel, BorderLayout.CENTER);
        mainViewFrame.add(endGamePanel);
    }
}
