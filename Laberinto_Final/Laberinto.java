import java.util.Stack;

public class Laberinto {
    private int[][] laberinto;
    private int filas;
    private int columnas;
    private Stack<int[]> pila = new Stack<>();

    public Laberinto(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        laberinto = new int[filas][columnas];
    }

    public void agregarObstaculo(int fila, int columna) {
        laberinto[fila][columna] = 1;
    }

    public boolean resolver(int filaInicio, int columnaInicio) {
        pila.push(new int[]{filaInicio, columnaInicio});

        while (!pila.isEmpty()) {
            int[] posicion = pila.pop();
            int fila = posicion[0];
            int columna = posicion[1];

            if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
                return true;
            }

            if (laberinto[fila][columna] == 1 || laberinto[fila][columna] == 2) {
                continue;
            }

            laberinto[fila][columna] = 2;

            pila.push(new int[]{fila - 1, columna});
            pila.push(new int[]{fila + 1, columna});
            pila.push(new int[]{fila, columna - 1});
            pila.push(new int[]{fila, columna + 1});
        }

        return false;
    }

    int getColumnas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getFilas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean esObstaculo(int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean esCamino(int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}