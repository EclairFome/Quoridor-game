//Integrantes: Erick Cañizales, Mack Torres, Jose Rivera, Allison Cheves y Emily Pérez
package quoridor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JFrame implements ActionListener, MouseListener {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static final int ROWS = 17;
    public static final int COLS = 17;
    Turnos turno = new Turnos();
    int opcionM = 3;
    int playerActual;
    int[] pos = new int[2];

    final JButton[][] cells = new JButton[ROWS][COLS];
    Jugadores jugadores = new Jugadores();
    int currentPlayer = 1;

    public Board(int playerActual) {
        this.playerActual = playerActual;
    }

    public void CreateBoard() {
        super.setTitle("Quoridor");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(ROWS, COLS));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());
        infoPanel.setPreferredSize(new Dimension(WIDTH, 40));

        JButton newGameButton = new JButton("Nuevo Juego");
        newGameButton.addActionListener(this);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        // Inicializacion de las celdas
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JButton button = new JButton();
                if ((row % 2 == 0) && (col % 2 == 0)) {
                    button.setBackground(Color.GRAY);
                    button.setBorder(new LineBorder(Color.BLACK));

                    button.addMouseListener(this);

                    button.setActionCommand(row + "," + col);
                } else {
                    button.setBackground(Color.BLACK);
                    button.setBorder(new LineBorder(Color.BLACK));
                    button.setActionCommand(row + "," + col);
                    button.addMouseListener(this);
                }
                cells[row][col] = button;
                boardPanel.add(button);
            }
        }
        add(boardPanel, BorderLayout.CENTER);
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        southPanel.add(newGameButton);
        southPanel.add(exitButton);
        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);

        // Metodo de los jugadores
        Jugadores.iniJugadores(this);
        // Exit
        exitButton.addActionListener(e -> System.exit(0));
        // Reiniciar
        newGameButton.addActionListener(e -> {
            dispose();
            new Inicio();
        });

    }

    int player = 0;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (opcionM == 1) {
            for (int i = 0; i < 17; i++) {

                for (int j = 0; j < 17; j++) {

                    if (e.getSource() == cells[i][j]) {

                        if (this.playerActual == 1) {
                            if (!((cells[i][j].getBackground() == Color.BLACK)
                                    && ((cells[i][j - 1].getBackground() == Color.GRAY)
                                            && ((cells[i][j + 1]
                                                    .getBackground() == Color.BLACK))))
                                    && !(i % 2 == 0) && !(j % 2 == 0)) {

                                if (!((cells[i][j].getBackground() == Color.yellow)
                                        && ((cells[i][j - 1]
                                                .getBackground() == Color.yellow)
                                                && ((cells[i][j + 1]
                                                        .getBackground() == Color.yellow))))
                                        && !(i % 2 == 0) && !(j % 2 == 0)) {
                                    cells[i][j - 1].setBackground(Color.yellow);
                                    cells[i][j].setBackground(Color.yellow);
                                    cells[i][j + 1].setBackground(Color.yellow);
                                    cells[i][j - 1]
                                            .setBorder(new LineBorder(Color.black));
                                    cells[i][j].setBorder(new LineBorder(Color.BLACK));
                                    cells[i][j + 1]
                                            .setBorder(new LineBorder(Color.BLACK));

                                    jugadores.restarWalls1();
                                    System.out.println("Jug 1: " + jugadores.walls1);
                                    System.out.println("Jug 2: " + jugadores.walls2);
                                    this.playerActual = 2;
                                    turno.turn(this);

                                }

                            }
                        } else {
                            if (!((cells[i][j].getBackground() == Color.BLACK)
                                    && ((cells[i][j - 1].getBackground() == Color.GRAY)
                                            && ((cells[i][j + 1]
                                                    .getBackground() == Color.BLACK))))
                                    && !(i % 2 == 0) && !(j % 2 == 0)) {
                                if (!(cells[i][j - 1].getBackground() == Color.YELLOW)
                                        && !(cells[i][j].getBackground() == Color.YELLOW)
                                        && !(cells[i][j + 1].getBackground() == Color.YELLOW)) {

                                    if (!((cells[i][j].getBackground() == Color.yellow)
                                            && ((cells[i][j - 1]
                                                    .getBackground() == Color.yellow)
                                                    && ((cells[i][j + 1]
                                                            .getBackground() == Color.yellow))))
                                            && !(i % 2 == 0) && !(j % 2 == 0)) {
                                        cells[i][j - 1].setBackground(Color.YELLOW);
                                        cells[i][j].setBackground(Color.YELLOW);
                                        cells[i][j + 1].setBackground(Color.YELLOW);
                                        cells[i][j - 1]
                                                .setBorder(new LineBorder(Color.BLACK));
                                        cells[i][j].setBorder(new LineBorder(Color.BLACK));
                                        cells[i][j + 1]
                                                .setBorder(new LineBorder(Color.BLACK));

                                        jugadores.restarWalls2();
                                        this.playerActual = 1;
                                        System.out.println("Jug 1: " + jugadores.walls1);
                                        System.out.println("Jug 2: " + jugadores.walls2);
                                        turno.turn(this);
                                    }
                                }
                            }
                        }

                    }
                }
            }
        } else if (opcionM == 0) {
            for (int i = 0; i < 17; i++) {

                for (int j = 0; j < 17; j++) {

                    if (e.getSource() == cells[i][j]) {

                        if (this.playerActual == 1) {
                            if (!((cells[i][j].getBackground() == Color.BLACK)
                                    && ((cells[i - 1][j].getBackground() == Color.GRAY)
                                            && ((cells[i + 1][j]
                                                    .getBackground() == Color.BLACK))))
                                    && !(i % 2 == 0) && !(j % 2 == 0)) {
                                if (!(cells[i - 1][j].getBackground() == Color.YELLOW)
                                        && !(cells[i][j].getBackground() == Color.YELLOW)
                                        && !(cells[i + 1][j].getBackground() == Color.YELLOW)) {

                                        if (!((cells[i][j].getBackground() == Color.yellow)
                                                && ((cells[i - 1][j]
                                                .getBackground() == Color.yellow)
                                                && ((cells[i + 1][j]
                                                .getBackground() == Color.yellow))))
                                                && !(i % 2 == 0) && !(j % 2 == 0)) {
                                            cells[i - 1][j].setBackground(Color.YELLOW);
                                            cells[i][j].setBackground(Color.YELLOW);
                                            cells[i + 1][j].setBackground(Color.YELLOW);
                                            cells[i - 1][j]
                                                    .setBorder(new LineBorder(Color.BLACK));
                                            cells[i][j].setBorder(new LineBorder(Color.BLACK));
                                            cells[i + 1][j]
                                                    .setBorder(new LineBorder(Color.BLACK));

                                            jugadores.restarWalls1();
                                            System.out.println("Jug 1: " + jugadores.walls1);
                                            System.out.println("Jug 2: " + jugadores.walls2);
                                            this.playerActual = 2;
                                            turno.turn(this);

                                        }

                                }
                            }

                        } else {
                            if (!((cells[i][j].getBackground() == Color.BLACK)
                                    && ((cells[i - 1][j].getBackground() == Color.GRAY)
                                            && ((cells[i + 1][j]
                                                    .getBackground() == Color.BLACK))))
                                    && !(i % 2 == 0) && !(j % 2 == 0)) {
                                if (!(cells[i - 1][j].getBackground() == Color.YELLOW)
                                        && !(cells[i][j].getBackground() == Color.YELLOW)
                                        && !(cells[i + 1][j].getBackground() == Color.YELLOW)) {
                                        if (!((cells[i][j].getBackground() == Color.yellow)
                                                && ((cells[i - 1][j]
                                                .getBackground() == Color.yellow)
                                                && ((cells[i + 1][j]
                                                .getBackground() == Color.yellow))))
                                                && !(i % 2 == 0) && !(j % 2 == 0)) {
                                            cells[i - 1][j].setBackground(Color.YELLOW);
                                            cells[i][j].setBackground(Color.YELLOW);
                                            cells[i + 1][j].setBackground(Color.YELLOW);
                                            cells[i - 1][j]
                                                    .setBorder(new LineBorder(Color.BLACK));
                                            cells[i][j].setBorder(new LineBorder(Color.BLACK));
                                            cells[i + 1][j]
                                                    .setBorder(new LineBorder(Color.BLACK));

                                            jugadores.restarWalls2();
                                            System.out.println("Jug 1: " + jugadores.walls1);
                                            System.out.println("Jug 2: " + jugadores.walls2);
                                            this.playerActual = 1;
                                            turno.turn(this);

                                        }


                                }
                            }
                        }

                    }
                }
            }
        } else if (opcionM == 3) {
            for (int i = 0; i < 17; i++) {

                for (int j = 0; j < 17; j++) {

                    if (e.getSource() == cells[i][j]) {
                        int finalPos = pos[0];
                        int finalPos2 = pos[1];
                        if (this.playerActual == 1) {

                            if (cells[i][j].getBackground() == Color.GREEN) {
                                cells[finalPos][finalPos2].setBackground(Color.GRAY);
                                cells[finalPos][finalPos2].setBorder(new LineBorder(Color.BLACK));
                                cells[i][j].setBackground(Color.red);
                                cells[i][j].setBorder(new LineBorder(Color.BLACK));

                                // Se limpian las casillas verdes
                                for (int row = 0; row < Board.ROWS; row++) {
                                    for (int col = 0; col < Board.COLS; col++) {
                                        if (cells[row][col].getBackground() == Color.GREEN) {
                                            cells[row][col].setBackground(Color.GRAY);
                                            cells[row][col].setBorder(new LineBorder(Color.BLACK));
                                        }
                                    }
                                }
                                if(turno.checkWinner(this, playerActual)==false){
                                this.playerActual = 2;
                                turno.turn(this);
                                }
                            }

                        } else {
                            if (cells[i][j].getBackground() == Color.GREEN) {
                                cells[finalPos][finalPos2].setBackground(Color.GRAY);
                                cells[finalPos][finalPos2].setBorder(new LineBorder(Color.BLACK));
                                cells[i][j].setBackground(Color.WHITE);
                                cells[i][j].setBorder(new LineBorder(Color.BLACK));

                                // Se limpian las casillas verdes
                                for (int row = 0; row < Board.ROWS; row++) {
                                    for (int col = 0; col < Board.COLS; col++) {

                                        if (cells[row][col].getBackground() == Color.GREEN) {
                                            cells[row][col].setBackground(Color.GRAY);
                                            cells[row][col].setBorder(new LineBorder(Color.BLACK));
                                        }
                                    }
                                }
                                if(turno.checkWinner(this, playerActual)==false){
                                this.playerActual = 1;
                                turno.turn(this);
                                }

                            }

                        }

                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        for (int i = 0; i < 17; i++) {

            for (int j = 0; j < 17; j++) {

                if (e.getSource() == cells[i][j]) {

                    if (opcionM == 1) {
                        if (!((cells[i][j].getBackground() == Color.BLACK)
                                && ((cells[i][j - 1].getBackground() == Color.GRAY)
                                        && ((cells[i][j + 1]
                                                .getBackground() == Color.BLACK))))
                                && !(i % 2 == 0) && !(j % 2 == 0)) {

                            if (!(cells[i][j - 1].getBackground() == Color.YELLOW)
                                    && !(cells[i][j].getBackground() == Color.YELLOW)
                                    && !(cells[i][j + 1].getBackground() == Color.YELLOW)) {

                                if (cells[i][j - 1].getBackground() == Color.YELLOW) {
                                    cells[i][j - 1].setBackground(Color.YELLOW);
                                } else {
                                    cells[i][j - 1].setBackground(Color.white);
                                }
                                if (cells[i][j].getBackground() == Color.YELLOW) {
                                    cells[i][j].setBackground(Color.YELLOW);
                                } else {
                                    cells[i][j].setBackground(Color.white);
                                }
                                if (cells[i][j + 1].getBackground() == Color.YELLOW) {
                                    cells[i][j + 1].setBackground(Color.YELLOW);
                                } else {
                                    cells[i][j + 1].setBackground(Color.white);

                                }
                            }
                        }
                    } else if (opcionM == 0F) {
                        if (!((cells[i][j].getBackground() == Color.BLACK)
                                && ((cells[i - 1][j].getBackground() == Color.GRAY)
                                        && ((cells[i + 1][j]
                                                .getBackground() == Color.BLACK))))
                                && !(i % 2 == 0) && !(j % 2 == 0)) {

                            if (!(cells[i - 1][j].getBackground() == Color.YELLOW)
                                    && !(cells[i][j].getBackground() == Color.YELLOW)
                                    && !(cells[i + 1][j].getBackground() == Color.YELLOW)) {
                                if (!(cells[i - 1][j].getBackground() == Color.YELLOW)
                                        && !(cells[i][j].getBackground() == Color.YELLOW)
                                        && !(cells[i + 1][j].getBackground() == Color.YELLOW)) {

                                    if (cells[i - 1][j].getBackground() == Color.YELLOW) {
                                        cells[i - 1][j].setBackground(Color.YELLOW);
                                    } else {
                                        cells[i - 1][j].setBackground(Color.white);
                                    }
                                    if (cells[i][j].getBackground() == Color.YELLOW) {
                                        cells[i][j].setBackground(Color.YELLOW);
                                    } else {
                                        cells[i][j].setBackground(Color.white);
                                    }
                                    if (cells[i + 1][j].getBackground() == Color.YELLOW) {
                                        cells[i + 1][j].setBackground(Color.YELLOW);
                                    } else {
                                        cells[i + 1][j].setBackground(Color.white);

                                    }
                                }

                            }
                        }
                    }

                }
            }
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < 17; i++) {

            for (int j = 0; j < 17; j++) {

                if (e.getSource() == cells[i][j]) {

                    if (opcionM == 1) {

                        if (!((cells[i][j].getBackground() == Color.BLACK)
                                && ((cells[i][j - 1].getBackground() == Color.GRAY)
                                        && ((cells[i][j + 1]
                                                .getBackground() == Color.BLACK))))
                                && !(i % 2 == 0) && !(j % 2 == 0)) {
                            if (cells[i][j - 1].getBackground() == Color.YELLOW) {
                                cells[i][j - 1].setBackground(Color.YELLOW);
                            } else {
                                cells[i][j - 1].setBackground(Color.BLACK);
                            }
                            if (cells[i][j].getBackground() == Color.YELLOW) {
                                cells[i][j].setBackground(Color.YELLOW);
                            } else {
                                cells[i][j].setBackground(Color.BLACK);
                            }
                            if (cells[i][j + 1].getBackground() == Color.YELLOW) {
                                cells[i][j + 1].setBackground(Color.YELLOW);
                            } else {
                                cells[i][j + 1].setBackground(Color.BLACK);
                            }
                        }

                    } else if (opcionM == 0) {
                        if (!((cells[i][j].getBackground() == Color.BLACK)
                                && ((cells[i - 1][j].getBackground() == Color.GRAY)
                                        && ((cells[i + 1][j]
                                                .getBackground() == Color.BLACK))))
                                && !(i % 2 == 0) && !(j % 2 == 0)) {

                            if (cells[i - 1][j].getBackground() == Color.YELLOW) {
                                cells[i - 1][j].setBackground(Color.YELLOW);
                            } else {
                                cells[i - 1][j].setBackground(Color.BLACK);
                            }
                            if (cells[i][j].getBackground() == Color.YELLOW) {
                                cells[i][j].setBackground(Color.YELLOW);
                            } else {
                                cells[i][j].setBackground(Color.BLACK);
                            }
                            if (cells[i + 1][j].getBackground() == Color.YELLOW) {
                                cells[i + 1][j].setBackground(Color.YELLOW);
                            } else {
                                cells[i + 1][j].setBackground(Color.BLACK);
                            }
                        }
                    }
                }

            }
        }
    }
}
