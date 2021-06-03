package view;

import constantes.ColorConstantes;
import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class PanelGame extends JPanel {

    JLabel statusBar = new JLabel("Current player");
    public Controller controller;

    public PanelGame(Controller controller){
        this.controller=controller;
    }


    public void paint(Graphics g) {
        for (int j=0;j<8;j++) {
            for (int i=0;i<8;i++) {
                if (((i+j)%2) == 1)
                    g.setColor(ColorConstantes.LIGHT_BROWN);
                else
                    g.setColor(ColorConstantes.DARK_BROWN);
                g.fillRect(i*80, j*80, 80, 80);

                int p =controller.gameManager.board.getPiece(i,j);
                if (p >= 0) {
                    if ((p%2) == 0)
                        g.setColor(ColorConstantes.DARK_BROWN);
                    else
                        g.setColor(ColorConstantes.LIGHT_BROWN);
                    g.fillOval(i*80+5, j*80+5, 70, 70);
                    g.setColor(Color.WHITE);
                    g.drawOval(i*80+5, j*80+5, 70, 70);
                }
            }
        }
    }

    public void redraw() {
            String msg = (controller.gameManager.board.getCurrentPlayer()==0)?"Noir":"Blanc";
            statusBar.setText("Joueur actuel: "+msg);
            repaint();


    }
}
