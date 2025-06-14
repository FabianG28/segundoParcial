public class examenFinal {

    public static int contarConsumosAltos(int[][] matriz) {
        int contador = 0;
        for (int[] fila : matriz) {
            for (int consumo : fila) {
                if (consumo > 8) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static double promedioConsumoModerado(int[][] matriz) {
        int suma = 0;
        int cantidad = 0;
        for (int[] fila : matriz) {
            for (int consumo : fila) {
                if (consumo >= 4 && consumo <= 7) {
                    suma += consumo;
                    cantidad++;
                }
            }
        }
        return cantidad > 0 ? (double) suma / cantidad : 0.0;
    }

    public static void imprimirConsumoBajo(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 3) {
                    System.out.println("Consumo bajo de " + matriz[i][j] + " galones en la posición [" + i + "][" + j + "]");
                }
            }
        }
    }

    public static int[] posicionConsumoMaximo(int[][] matriz) {
        int max = matriz[0][0];
        int[] posicion = {0, 0};

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

    public static void consumoTotalPorVehiculo(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            int total = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                total += matriz[i][j];
            }
            System.out.println("Vehículo " + i + " tuvo un consumo total de " + total + " galones.");
        }
    }

    public static void main(String[] args) {
        int[][] consumo = {
            {5, 2, 9, 7},
            {3, 8, 4, 1},
            {6, 10, 2, 5}
        };

        System.out.println("Consumos mayores a 8 galones: " + contarConsumosAltos(consumo));
        System.out.println("Promedio de consumos moderados (4-7 galones): " + promedioConsumoModerado(consumo));
        System.out.println("Consumos bajos (<3 galones):");
        imprimirConsumoBajo(consumo);

        int[] maxPos = posicionConsumoMaximo(consumo);
        System.out.println("Consumo máximo en la posición [" + maxPos[0] + "][" + maxPos[1] + "]");

        System.out.println("\nBONUS: Consumo total por vehículo:");
        consumoTotalPorVehiculo(consumo);
    }
}

