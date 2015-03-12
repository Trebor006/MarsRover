package source;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Robert
 */
public class Plateau {

    int maxX, maxY;
    /**
     * direccion = 0 = N direccion = 1 = E direccion = 2 = S direccion = 3 = O
     */
    public int direccion;
    public int rover_pos_x, rover_pos_y;

    public Plateau() {
    }

    public Plateau(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void establecerPosicionRoverInicial(int x, int y, char dir) {
        rover_pos_x = x;
        rover_pos_y = y;
        switch (dir) {
            case 'N': {
                direccion = 0;
            }
            break;
            case 'E': {
                direccion = 1;
            }
            break;
            case 'S': {
                direccion = 2;
            }
            break;
            case 'W': {
                direccion = 3;
            }
            break;
        }
    }

    public void establecerMovimientosRover(String movimientos) {
        for (int i = 0; i < movimientos.length(); i++) {
            char comando = movimientos.charAt(i);
            switch (comando) {
                case 'M': {
                    switch (direccion) {
                        case 0: {
                            if (rover_pos_y <= maxY - 1) {
                                rover_pos_y++;
                            }
                        }
                        break;
                        case 1: {
                            if (rover_pos_x <= maxX - 1) {
                                rover_pos_x++;
                            }
                        }
                        break;
                        case 2: {
                            if (rover_pos_y >= 1) {
                                rover_pos_y--;
                            }
                        }
                        break;
                        case 3: {
                            if (rover_pos_x >= 1) {
                                rover_pos_x--;
                            }
                        }
                        break;
                    }
                }
                break;
                case 'L': {
                    direccion--;
                    if (direccion < 0) {
                        direccion = 3;
                    }
                }
                break;
                case 'R': {
                    direccion++;
                    if (direccion > 3) {
                        direccion = 0;
                    }

                }
                break;
            }
        }

    }

    public String obtenerDireccionFinal() {
        char punto_cardinal = 0;
        switch (direccion) {
            case 0: {
                punto_cardinal = 'N';
            }
            break;
            case 1: {
                punto_cardinal = 'E';
            }
            break;
            case 2: {
                punto_cardinal = 'S';
            }
            break;
            case 3: {
                punto_cardinal = 'W';
            }
            break;
        }
        return String.format("%d %d %c", rover_pos_x, rover_pos_y, punto_cardinal);
    }

}
