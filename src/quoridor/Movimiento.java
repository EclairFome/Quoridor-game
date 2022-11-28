package quoridor;

import java.awt.*;




public class Movimiento {
    //Busca la posicion del jugador 1 y la retorna
    public static int[] buscarJugador1(Board board) {
        int[] pos = new int[2];
        for (int row = 0; row < Board.ROWS; row++) {
            for (int col = 0; col < Board.COLS; col++) {
                if (board.cells[row][col].getBackground() == Color.RED) {
                    pos[0] = row;
                    pos[1] = col;
                }
            }
        }
        return pos;
    }

    //Busca la posicion del jugador 2 y la retorna
    public static int[] buscarJugador2(Board board) {
        int[] pos = new int[2];
        for (int row = 0; row < Board.ROWS; row++) {
            for (int col = 0; col < Board.COLS; col++) {
                if (board.cells[row][col].getBackground() == Color.WHITE) {
                    pos[0] = row;
                    pos[1] = col;
                }
            }
        }
        return pos;
    }

    //Posibles movimientos de cada jugador en su turno pintandolos de verde, 2 arriba, 2 abajo, 2 izquierda, 2 derecha
    public static void posMovimientos(Board board, int currentPlayer) {
        int[] pos = new int[2];
        if (currentPlayer == 1) {
            pos = buscarJugador1(board);
            if (pos[0] - 2 >= 0 && board.cells[pos[0] - 1][pos[1]].getBackground() == Color.BLACK && !(board.cells[pos[0] - 2][pos[1]].getBackground() == Color.RED) && !(board.cells[pos[0] - 2][pos[1]].getBackground() == Color.WHITE)) {
                board.cells[pos[0] - 2][pos[1]].setBackground(Color.GREEN);
                
            }
            if (pos[0] + 2 <= 16 && board.cells[pos[0] + 1][pos[1]].getBackground() == Color.BLACK && !(board.cells[pos[0] + 2][pos[1]].getBackground() == Color.RED) && !(board.cells[pos[0] + 2][pos[1]].getBackground() == Color.WHITE)) {
                board.cells[pos[0] + 2][pos[1]].setBackground(Color.GREEN);
                
            }
            if (pos[1] - 2 >= 0 && board.cells[pos[0]][pos[1] - 1].getBackground() == Color.BLACK && !(board.cells[pos[0]][pos[1] - 2].getBackground() == Color.RED) && !(board.cells[pos[0]][pos[1] - 2].getBackground() == Color.WHITE)) {
                board.cells[pos[0]][pos[1] - 2].setBackground(Color.GREEN);
                
            }
            if (pos[1] + 2 <= 16 && board.cells[pos[0]][pos[1] + 1].getBackground() == Color.BLACK && !(board.cells[pos[0]][pos[1] + 2].getBackground() == Color.RED) && !(board.cells[pos[0]][pos[1] + 2].getBackground() == Color.WHITE)) {
                board.cells[pos[0]][pos[1] + 2].setBackground(Color.GREEN);
                
            }
            //El jugador se puede mover a las casillas verdes cuando se le da click

        


        } else {
            pos = buscarJugador2(board);
            if (pos[0] - 2 >= 0 && board.cells[pos[0] - 1][pos[1]].getBackground() == Color.BLACK && !(board.cells[pos[0] - 2][pos[1]].getBackground() == Color.RED) && !(board.cells[pos[0] - 2][pos[1]].getBackground() == Color.WHITE)) {
                board.cells[pos[0] - 2][pos[1]].setBackground(Color.GREEN);
                
            }
            if (pos[0] + 2 <= 16 && board.cells[pos[0] + 1][pos[1]].getBackground() == Color.BLACK && !(board.cells[pos[0] + 2][pos[1]].getBackground() == Color.RED) && !(board.cells[pos[0] + 2][pos[1]].getBackground() == Color.WHITE)) {
                board.cells[pos[0] + 2][pos[1]].setBackground(Color.GREEN);
                
            }
            if (pos[1] - 2 >= 0 && board.cells[pos[0]][pos[1] - 1].getBackground() == Color.BLACK && !(board.cells[pos[0]][pos[1] - 2].getBackground() == Color.RED) && !(board.cells[pos[0]][pos[1] - 2].getBackground() == Color.WHITE)) {
                board.cells[pos[0]][pos[1] - 2].setBackground(Color.GREEN);
                
            }
            if (pos[1] + 2 <= 16 && board.cells[pos[0]][pos[1] + 1].getBackground() == Color.BLACK && !(board.cells[pos[0]][pos[1] + 2].getBackground() == Color.RED) && !(board.cells[pos[0]][pos[1] + 2].getBackground() == Color.WHITE)) {
                board.cells[pos[0]][pos[1] + 2].setBackground(Color.GREEN);
                
            }
            //El jugador se puede mover a las casillas verdes cuando se le da click
   

        }
    }
}
