//Integrantes: Erick Cañizales, Mack Torres, Jose Rivera, Allison Cheves y Emily Pérez
package quoridor;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Turnos implements ActionListener {
    public static int player1Paredes = 10;
    public static int player2Paredes = 10;


    // Check if a player has won
    public Boolean checkWinner(Board board, int currentPlayer) {
        boolean v=false;
        if (currentPlayer == 1) {
            if (Movimiento.buscarJugador1(board)[0] == 16) {
                JOptionPane.showMessageDialog(null, "El jugador 1 ha ganado");
                System.exit(0);
                v=true;

            }
        } else {
            if (Movimiento.buscarJugador2(board)[0] == 0) {
                JOptionPane.showMessageDialog(null, "El jugador 2 ha ganado");
                System.exit(0);
                v=true;

            }
        }
        return v;
        
    }

    public void turn(Board board) {
        JOptionPane.showMessageDialog(null, "Turno del jugador " + board.playerActual);
            String[] options = { "Moverse", "Colocar pared" };
            int opcion = JOptionPane.showOptionDialog(null, "Que quieres hacer?", "Quoridor",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (opcion == 0) {
                board.opcionM = 3;

                if(board.playerActual== 1){
                    board.pos = Movimiento.buscarJugador1(board);
                    Movimiento.posMovimientos(board, board.playerActual);
                    return;
                } else {
                    board.pos = Movimiento.buscarJugador2(board);
                    Movimiento.posMovimientos(board, board.playerActual);
                    return;
                }
             

        } else {
            options[0] = "Pared vertical";
            options[1] = "Pared Horizontal";
            opcion = JOptionPane.showOptionDialog(null, "Que tipo de pared quiere colocar?", "Quoridor",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            board.opcionM = opcion;
            return;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

