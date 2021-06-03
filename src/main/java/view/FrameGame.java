package view;

import javax.swing.*;
import java.awt.*;

public class FrameGame extends JFrame {


    public FrameGame(PanelGame panel) {

        //definit le titre de la fenetre
        this.setTitle("CHECKERS");

        //definit la taille de la fenetre
        this.setSize(100 * 8, 100 * 8);

        ///Termine le processus lorsqu'on clique sur la croix rouge
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //positionne notre fenetre au milieu
        this.setLocationRelativeTo(null);

        //la fenetre n est pas redimentionnable
        this.setResizable(true);


        //    //On prévient notre JFrame que notre JPanel sera son content pane
        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.getContentPane().add(panel.statusBar,BorderLayout.SOUTH);

        //rend notre fenetre visible
        this.setVisible(true);


        //la fenetre est toujours visible
        this.setAlwaysOnTop(true);





    }
}
