import java.util.Scanner;

public class Principal {
    static void main() {
        Scanner s = new Scanner(System.in);

        System.out.println("¿Cuántos viajeros habéis realizado el viaje? (Máximo 5): ");
        int viajeros = s.nextInt();

        if (viajeros > 5 || viajeros < 2) {
            System.out.println("ERROR, debe haber al menos 2 viajeros y máximo 5 viajeros implicados.");
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

                } else if (menu == 2) {

                } else if (menu == 3) {

                }
            } while (menu < 4);
        }
    }
}
