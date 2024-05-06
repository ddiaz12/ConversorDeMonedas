import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte opcion;

        do {
            System.out.println("Bienvenido al conversor de monedas!");
            System.out.println("Por favor, seleccione la conversión que desea realizar:");
            System.out.println("1. Dólar a Peso Argentino");
            System.out.println("2. Peso Argentino a Dólar");
            System.out.println("3. BRL a Dólar");
            System.out.println("4. Dólar a BRL");
            System.out.println("5. BOB a Dólar");
            System.out.println("6. Dólar a BOB");
            System.out.println("0. Salir");

            opcion = sc.nextByte();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cantidad de Dólares a convertir:");
                    double cantidadUSD = sc.nextDouble();
                    USDtoARS.convert(cantidadUSD);
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad de Pesos Argentinos a convertir:");
                    double cantidadARS = sc.nextDouble();
                    ARStoUSD.convert(cantidadARS);
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad de BRL a convertir:");
                    double cantidadBRL = sc.nextDouble();
                    BRLtoUSD.convert(cantidadBRL);
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad de Dólares a convertir:");
                    double cantidadUSD2 = sc.nextDouble();
                    USDtoBRL.convert(cantidadUSD2);
                    break;
                case 5:
                    System.out.println("Ingrese la cantidad de BOB a convertir:");
                    double cantidadBOB = sc.nextDouble();
                    BOBtoUSD.convert(cantidadBOB);
                    break;
                case 6:
                    System.out.println("Ingrese la cantidad de Dólares a convertir:");
                    double cantidadUSD3 = sc.nextDouble();
                    USDtoBOB.convert(cantidadUSD3);
                    break;
                case 0:
                    System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 0 al 6.");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}