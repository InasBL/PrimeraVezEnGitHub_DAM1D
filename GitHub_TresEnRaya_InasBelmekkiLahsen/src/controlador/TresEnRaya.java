package controlador;
import java.util.Scanner;

	public class TresEnRaya {
	    static char[][] tablero = {
	        {' ', ' ', ' '},
	        {' ', ' ', ' '},
	        {' ', ' ', ' '}
	    };
	    static char jugadorActual = 'X';

	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        boolean juegoActivo = true;

	        while (juegoActivo) {
	            imprimirTablero();
	            System.out.println("Turno del jugador " + jugadorActual);
	            System.out.print("Introduce fila (0-2): ");
	            int fila = sc.nextInt();
	            System.out.print("Introduce columna (0-2): ");
	            int columna = sc.nextInt();

	            if (movimientoValido(fila, columna)) {
	                tablero[fila][columna] = jugadorActual;

	                if (hayGanador()) {
	                    imprimirTablero();
	                    System.out.println("¡El jugador " + jugadorActual + " gana!");
	                    juegoActivo = false;
	                } else if (tableroLleno()) {
	                    imprimirTablero();
	                    System.out.println("¡Empate!");
	                    juegoActivo = false;
	                } else {
	                    cambiarJugador();
	                }
	            } else {
	                System.out.println("Movimiento inválido, intenta de nuevo.");
	            }
	        }

	        sc.close();
	    }

	    static void imprimirTablero() {
	        System.out.println("-------------");
	        for (int i = 0; i < 3; i++) {
	            System.out.print("| ");
	            for (int j = 0; j < 3; j++) {
	                System.out.print(tablero[i][j] + " | ");
	            }
	            System.out.println("\n-------------");
	        }
	    }

	    static boolean movimientoValido(int fila, int columna) {
	        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ';
	    }

	    static void cambiarJugador() {
	        jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
	    }

	    static boolean hayGanador() {
	        for (int i = 0; i < 3; i++) {
	            if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual)
	                return true;
	            if (tablero[0][i] == jugadorActual && tablero[1][i] == jugadorActual && tablero[2][i] == jugadorActual)
	                return true;
	        }
	        if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual)
	            return true;
	        if (tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual)
	            return true;

	        return false;
	    }

	    static boolean tableroLleno() {
	        for (int i = 0; i < 3; i++)
	            for (int j = 0; j < 3; j++)
	                if (tablero[i][j] == ' ')
	                    return false;
	        return true;
	    }
	}

