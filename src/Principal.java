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

        // Indican si ya se han introducido los gastos (opción 1) y si ya se ha calculado el reparto (opción 2)
        boolean gastosIntroducidos = false;
        boolean repartoCalculado = false;

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
                    System.out.println("Debe introducir el valor -1 para indicar que un viajero no existe.");

                    // Se piden los gastos de los 5 viajeros.
                    // Si se introduce -1, ese viajero no existe y no cuenta para el reparto.
                    System.out.println("Gastos del viajero 1:");
                    v1 = s.nextInt();
                    System.out.println("Gastos del viajero 2:");
                    v2 = s.nextInt();
                    System.out.println("Gastos del viajero 3:");
                    v3 = s.nextInt();
                    System.out.println("Gastos del viajero 4:");
                    v4 = s.nextInt();
                    System.out.println("Gastos del viajero 5:");
                    v5 = s.nextInt();

                    gastosIntroducidos = true;
                    // Si cambian los gastos, hay que volver a calcular el reparto
                    repartoCalculado = false;

                } else if (menu == 2) {
                    if (!gastosIntroducidos) {
                        System.out.println("Debe realizar el paso 1 en el menú antes de continuar.");
                    } else {
                        // Solo se calcula si ya se ha hecho el paso 1
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

                            repartoCalculado = true;
                            System.out.println("Reparto calculado correctamente.");
                        }
                    }

                } else if (menu == 3) {
                    if (!repartoCalculado) {
                        System.out.println("Debe realizar los pasos 1 y 2 en el menú antes de continuar.");
                    } else {
                        System.out.println("---REPARTO DE GASTOS---");

                        // Saldo positivo: debe recibir. Saldo negativo: debe pagar.
                        if (v1 != -1) {
                            if (saldo1 > 0) System.out.printf("Viajero 1 debe recibir %.2f €%n", saldo1);
                            else if (saldo1 < 0) System.out.printf("Viajero 1 debe pagar %.2f €%n", -saldo1);
                            else System.out.println("Viajero 1 no debe pagar ni recibir nada.");
                        }
                        if (v2 != -1) {
                            if (saldo2 > 0) System.out.printf("Viajero 2 debe recibir %.2f €%n", saldo2);
                            else if (saldo2 < 0) System.out.printf("Viajero 2 debe pagar %.2f €%n", -saldo2);
                            else System.out.println("Viajero 2 no debe pagar ni recibir nada.");
                        }
                        if (v3 != -1) {
                            if (saldo3 > 0) System.out.printf("Viajero 3 debe recibir %.2f €%n", saldo3);
                            else if (saldo3 < 0) System.out.printf("Viajero 3 debe pagar %.2f €%n", -saldo3);
                            else System.out.println("Viajero 3 no debe pagar ni recibir nada.");
                        }
                        if (v4 != -1) {
                            if (saldo4 > 0) System.out.printf("Viajero 4 debe recibir %.2f €%n", saldo4);
                            else if (saldo4 < 0) System.out.printf("Viajero 4 debe pagar %.2f €%n", -saldo4);
                            else System.out.println("Viajero 4 no debe pagar ni recibir nada.");
                        }
                        if (v5 != -1) {
                            if (saldo5 > 0) System.out.printf("Viajero 5 debe recibir %.2f €%n", saldo5);
                            else if (saldo5 < 0) System.out.printf("Viajero 5 debe pagar %.2f €%n", -saldo5);
                            else System.out.println("Viajero 5 no debe pagar ni recibir nada.");
                        }
                    }
                }
            } while (menu < 4);
        }
    }
}
