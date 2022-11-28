//Integrantes: Erick Cañizales, Mack Torres, Jose Rivera, Allison Cheves y Emily Pérez
package quoridor;

import javax.swing.*;



public class Inicio {
    Turnos funcTurno = new Turnos();
    public Jugadores jugadores = new Jugadores();
    Boolean isEnd = false;
    int currentPlayer = 1;
    public Board Tablero2 = new Board(currentPlayer);

    public Inicio() {

        //Se crea el tablero.
        int opcion = JOptionPane.showConfirmDialog(null, "Quieres iniciar el juego?", "Quoridor", JOptionPane.YES_NO_OPTION);
        if (opcion == 0) {
            Tablero2.CreateBoard();

        } else {
            System.exit(0);
        }

        funcTurno.turn(Tablero2);



    }
}
