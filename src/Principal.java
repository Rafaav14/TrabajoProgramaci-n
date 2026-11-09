import java.util.Scanner;

public class Principal {
    static void main() {
        Scanner s = new Scanner(System.in);

        System.out.println("¿Cuántos viajeros habéis realizado el viaje? (Máximo 5): ");
        int viajeros = s.nextInt();

        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0;
        int v5 = 0;

        // Lo que debe pagar (negativo) o recibir (positivo) cada viajero
        double saldo1 = 0;
        double saldo2 = 0;
        double saldo3 = 0;
        double saldo4 = 0;
        double saldo5 = 0;

        if (viajeros > 5 || viajeros < 1) {
            System.out.println("ERROR, debe haber al menos 1 viajero y máximo 5 viajeros implicados.");
        } else {
            int menu = 0;
            do {
                System.out.println("---MENÚ---");
                System.out.println("1. Introducir gastos de los viajeros");
                System.out.println("2. Calcular reparto de gastos");
                System.out.println("3. Mostrar el reparto de los viajeros");
                System.out.println("4. Salir");
                menu = s.nextInt();

                if (menu == 1) {

                    System.out.println("¿Cuánto han sido los gastos de cada viajero?");
                    System.out.println("Introduzca los gastos de cada viajero, introduzca un salto de línea después.");
                    System.out.println("Debe introducir el valor -1 para indicar que un viajero no existe.");
                    v1 = s.nextInt();
                    v2 = s.nextInt();
                    v3 = s.nextInt();
                    v4 = s.nextInt();
                    v5 = s.nextInt();

                } else if (menu == 2) {
                    if (v1 == 0 && v2 == 0 && v3 == 0 && v4 == 0 && v5 == 0) {
                        System.out.println("Debe realizar el paso 1 en el menú antes de continuar.");
                    }

                    // Solo se calcula si ya se ha hecho el paso 1
                    if (v1 != 0 || v2 != 0 || v3 != 0 || v4 != 0 || v5 != 0) {
                        int total = 0;
                        int reales = 0;

                        // Solo cuentan los viajeros que existen ,distintos de -1
                        if (v1 != -1) { total += v1;
                            reales++;
                        }
                        if (v2 != -1) { total += v2;
                            reales++;
                        }
                        if (v3 != -1) { total += v3;
                            reales++;
                        }
                        if (v4 != -1) { total += v4;
                            reales++;
                        }
                        if (v5 != -1) { total += v5;
                            reales++;
                        }

                        if (reales == 0) {
                            System.out.println("No hay ningún viajero válido, vuelve a introducir los gastos.");
                        } else {
                            // Lo que le corresponde pagar a cada uno
                            double media = (double) total / reales;

                            if (v1 != -1) saldo1 = v1 - media;
                            else saldo1 = 0;
                            if (v2 != -1) saldo2 = v2 - media;
                            else saldo2 = 0;
                            if (v3 != -1) saldo3 = v3 - media;
                            else saldo3 = 0;
                            if (v4 != -1) saldo4 = v4 - media;
                            else saldo4 = 0;
                            if (v5 != -1) saldo5 = v5 - media;
                            else saldo5 = 0;

                            System.out.println("Reparto calculado correctamente.");
                        }
                    }

                } else if (menu == 3) {

                }
            } while (menu < 4);
        }
    }
}
