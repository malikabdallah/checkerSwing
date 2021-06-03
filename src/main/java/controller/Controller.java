package controller;

import model.GameManager;
import view.FrameGame;
import view.PanelGame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener {

    public FrameGame frame;
    public PanelGame panel;
    public GameManager gameManager;

    public Controller(){

        gameManager=new GameManager();
        panel=new PanelGame(this);
        frame=new FrameGame(panel);
        panel.addMouseListener(this);

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse pressed");
        int i = e.getX() / 80;
        int j = e.getY() / 80;
        if (gameManager.board.getPiece(i,j) == gameManager.board.getCurrentPlayer()) {
            gameManager.selectedPiece = new int[2];
            gameManager.selectedPiece[0] = i;
            gameManager.selectedPiece[1] = j;
        }
        else {
            gameManager.selectedPiece = null;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released");
        if (gameManager.selectedPiece == null) {
            return;
        }
        int i = e.getX() / 80;
        int j = e.getY() / 80;
        if (gameManager.board.movePiece(gameManager.selectedPiece[0], gameManager.selectedPiece[1], i, j)) {
            panel.redraw();
        }
        gameManager.selectedPiece = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
