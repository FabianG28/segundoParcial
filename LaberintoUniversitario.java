import java.util.Random;

public class LaberintoUniversitario {

    public static void main(String[] args) {
        int[][] laberinto = generarMatriz(5);
        mostrarMatriz(laberinto);

        int paresMayoresA4 = contarParesMayoresA4(laberinto);
        System.out.println(" Números pares mayores a 4: " + paresMayoresA4);

        double promedioImpares = calcularPromedioImpares(laberinto);
        System.out.println(" Promedio de impares: " + promedioImpares);

        System.out.println(" Suma por filas:");
        sumarFilas(laberinto);

        int[] posicionMaximo = encontrarNumeroMaximo(laberinto);
        System.out.println(" Número más alto en posición: (" + posicionMaximo[0] + ", " + posicionMaximo[1] + ")");
    }

    public static int[][] generarMatriz(int tamaño) {
        int[][] matriz = new int[tamaño][tamaño];
        Random rand = new Random();

        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                matriz[i][j] = rand.nextInt(9) + 1;
            }
        }
        return matriz;
    }

    public static void mostrarMatriz(int[][] matriz) {
        System.out.println("Laberinto generado:");
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }

    public static int contarParesMayoresA4(int[][] matriz) {
        int contador = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor > 4 && valor % 2 == 0) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static double calcularPromedioImpares(int[][] matriz) {
        int suma = 0;
        int contador = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor % 2 != 0) {
                    suma += valor;
                    contador++;
                }
            }
        }
        return contador > 0 ? (double) suma / contador : 0;
    }

    public static void sumarFilas(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            int sumaFila = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumaFila += matriz[i][j];
            }
            System.out.println("Fila " + i + ": " + sumaFila);
        }
    }

    public static int[] encontrarNumeroMaximo(int[][] matriz) {
        int max = Integer.MIN_VALUE;
        int[] posicion = new int[2];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > max) {
                    max = matriz[i][j];
                    posicion[0] = i;
                    posicion[1] = j;
                }
            }
        }
        return posicion;
    }
}