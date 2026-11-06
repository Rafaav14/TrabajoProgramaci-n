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

                } else if (menu == 3) {

                }
            } while (menu < 4);
        }
    }
}
