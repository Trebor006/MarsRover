package source;

/**
 *
 * @author Robert
 */
public class Plateau {

    int maxX, maxY;
    /**
     * direction = 0 = N 
     * direction = 1 = E 
     * direction = 2 = S 
     * direction = 3 = W
     */
    public int direction;
    public int rover_pos_x, rover_pos_y;

    public Plateau() {
    }

    public Plateau(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Establece la posicion inicial de un rover
     *
     * @param x posicion en el eje X
     * @param y posicion en el eje Y
     * @param dir direccion hacia la q apunta el rover (N,E,S,W)
     */
    public void establecerPosicionRoverInicial(int x, int y, char dir) {
        rover_pos_x = x;
        rover_pos_y = y;
        switch (dir) {
            case 'N': {
                direction = 0;
            }
            break;
            case 'E': {
                direction = 1;
            }
            break;
            case 'S': {
                direction = 2;
            }
            break;
            case 'W': {
                direction = 3;
            }
            break;
        }
    }

    /**
     * Establece los movimientos que ejecutara el Rover y ademas los ejecuta.
     * dejando los resultados en las variables rover_pos_x, rover_pos_y y
     * direccion
     *
     * @param movimientos
     */
    public void establecerMovimientosRover(String movimientos) {
        for (int i = 0; i < movimientos.length(); i++) {
            char comando = movimientos.charAt(i);
            switch (comando) {
                case 'M': {
                    move();
                }
                break;
                case 'L': {
                    toLeft();
                }
                break;
                case 'R': {
                    toRight();

                }
                break;
            }
        }

    }

    /**
     *
     * @return la posicion POSX,POSY y direccion del Rover
     */
    public String obtenerDireccionFinal() {
        char punto_cardinal = 0;
        switch (direction) {
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

    /**
     * Girar a la Izquierda el Rover Actual
     */
    private void toLeft() {
        direction--;
        if (direction < 0) {
            direction = 3;
        }
    }

    /**
     * girar a la derecha el Rover actual
     */
    private void toRight() {
        direction++;
        if (direction > 3) {
            direction = 0;
        }
    }

    /**
     * Avanza hacia la direccion establecida. dentro de los margenes del
     * Plateau. MaxX,MaxY
     */
    private void move() {
        switch (direction) {
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

}
