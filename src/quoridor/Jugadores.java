//Integrantes: Erick Cañizales, Mack Torres, Jose Rivera, Allison Cheves y Emily Pérez
package quoridor;

import javax.swing.border.LineBorder;
import java.awt.*;

public class Jugadores {
    int walls1 = 10;
    int walls2 = 10;
    //Metodo inicializacion de los jugadores en sus posiciones iniciales para board
    public static void iniJugadores(Board board) {
        board.cells[0][8].setBackground(Color.RED);
        board.cells[0][8].setBorder(new LineBorder(Color.BLACK));
        board.cells[16][8].setBackground(Color.WHITE);
        board.cells[16][8].setBorder(new LineBorder(Color.BLACK));
    }

    public void restarWalls1(){
        walls1 -= 1;
    }

    public void restarWalls2(){
        walls2 -= 1;
    }
}




