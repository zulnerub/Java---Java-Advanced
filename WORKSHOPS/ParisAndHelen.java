package WORKSHOPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParisAndHelen {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int energy = Integer.parseInt(rd.readLine());
        int fs = Integer.parseInt(rd.readLine());

        int rowH = -1;
        int colH = -1;

        int rowP = -1;
        int colP = -1;

        String[][] field = new String[fs][];

        for (int i = 0; i < field.length; i++) {
            field[i] = rd.readLine().split("");
        }

        for (int rows = 0; rows < fs; rows++) {
            for (int cols = 0; cols < field[rows].length; cols++) {
                if (field[rows][cols].equals("H")) {
                    rowH = rows;
                    colH = cols;
                } else if (field[rows][cols].equals("P")) {
                    rowP = rows;
                    colP = cols;
                }
            }
        }

        boolean dead = false;
        boolean won = false;
        while (energy > 0 && !dead && !won) {
            String[] input = rd.readLine().split("\\s+");
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);
            field[row][col] = "S";

            switch (input[0]) {
                case "up":
                    energy--;
                    if (energy > 0) {
                        if (rowP - 1 >= 0) {
                            if (field[rowP - 1][colP].equals("S")) {
                                energy -= 2;
                                if (energy < 0) {
                                    dead = true;
                                    field[rowP][colP] = "-";
                                    field[--rowP][colP] = "X";
                                    break;
                                } else {
                                    field[rowP][colP] = "-";
                                    field[--rowP][colP] = "P";
                                }
                            } else if (field[rowP - 1][colP].equals("H")) {
                                field[rowP][colP] = "-";
                                field[rowH][colH] = "-";
                                won = true;
                            } else {
                                field[rowP][colP] = "-";
                                field[--rowP][colP] = "P";
                            }
                        }
                    } else {
                        dead = true;
                        field[rowP][colP] = "-";
                        field[--rowP][colP] = "X";
                        break;
                    }

                    break;
                case "down":
                    energy--;
                    if (energy > 0) {
                        if (rowP + 1 < fs) {
                            if (field[rowP + 1][colP].equals("S")) {
                                energy -= 2;
                                if (energy < 0) {
                                    dead = true;
                                    field[rowP][colP] = "-";
                                    field[++rowP][colP] = "X";
                                    break;
                                } else {
                                    field[rowP][colP] = "-";
                                    field[++rowP][colP] = "P";
                                }
                            } else if (field[rowP + 1][colP].equals("H")) {
                                field[rowP][colP] = "-";
                                field[rowH][colH] = "-";
                                won = true;
                            } else {
                                field[rowP][colP] = "-";
                                field[++rowP][colP] = "P";
                            }
                        }
                    } else {
                        dead = true;
                        field[rowP][colP] = "-";
                        field[++rowP][colP] = "X";
                        break;
                    }
                    break;
                case "left":
                    energy--;
                    if (energy > 0) {
                        if (colP - 1 >= 0) {
                            if (field[rowP][colP - 1].equals("S")) {
                                energy -= 2;
                                if (energy < 0) {
                                    dead = true;
                                    field[rowP][colP] = "-";
                                    field[rowP][--colP] = "X";
                                    break;
                                } else {
                                    field[rowP][colP] = "-";
                                    field[rowP][--colP] = "P";
                                }
                            } else if (field[rowP][colP - 1].equals("H")) {
                                field[rowP][colP] = "-";
                                field[rowH][colH] = "-";
                                won = true;
                            } else {
                                field[rowP][colP] = "-";
                                field[rowP][--colP] = "P";
                            }
                        }
                    } else {
                        dead = true;
                        field[rowP][colP] = "-";
                        field[rowP][--colP] = "X";
                        break;
                    }
                    break;
                case "right":
                    energy--;
                    if (energy > 0) {
                        if (colP + 1 < field[rowP].length) {
                            if (field[rowP][colP + 1].equals("S")) {
                                energy -= 2;
                                if (energy < 0) {
                                    dead = true;
                                    field[rowP][colP] = "-";
                                    field[rowP][++colP] = "X";
                                    break;
                                } else {
                                    field[rowP][colP] = "-";
                                    field[rowP][++colP] = "P";
                                }
                            } else if (field[rowP][colP + 1].equals("H")) {
                                field[rowP][colP] = "-";
                                field[rowH][colH] = "-";
                                won = true;
                            } else {
                                field[rowP][colP] = "-";
                                field[rowP][++colP] = "P";
                            }
                        }
                    } else {
                        dead = true;
                        field[rowP][colP] = "-";
                        field[rowP][++colP] = "X";
                        break;
                    }
                    break;
            }
        }
        if (dead) {
            System.out.printf("Paris died at %d;%d.%n", rowP, colP);
        } else if (won) {
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
        }

        for (int row = 0; row < fs; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }
}

