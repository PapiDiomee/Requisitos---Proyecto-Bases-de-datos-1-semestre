package requisito1;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static ArrayList<person> personas = new ArrayList<>();
    static ArrayList<contrato> contratos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n¿Que deseas hacer?");
            System.out.println("1) operaciones de las personas");
            System.out.println("2) operaciones de los contratos");
            System.out.println("0) salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> menuPersonas();
                case 2 -> menucontratos();
            }

        } while (opcion != 0);
    }

    private static void menucontratos() {
        System.out.println("Módulo de contratos aún no implementado.");
    }

    public static void menuPersonas() {
        int op;

        do {
            System.out.println("\n1) crear persona");
            System.out.println("2) buscar persona por cedula");
            System.out.println("3) mostrar a todas las personas registradas");
            System.out.println("4) mostrar a todas las personas activas");
            System.out.println("5) mostrar a todas las personas inactivas");
            System.out.println("0) volver");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    crearPersona();
                    break;
                case 2:
                    buscarPersona();
                    break;
                case 3:
                    mostrarTodas();
                    break;
                case 4:
                    mostrarActivas(); 
                    break;
                case 5:
                    mostrarInactivas(); 
                    break;
            }

        } while (op != 0);
    }

    private static void mostrarActivas() {
        boolean hay = false;

        for (person p : personas) {
            if (p.isActive()) {
                System.out.println(p);
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay personas activas.");
        }
    }

    private static void mostrarInactivas() {
        boolean hay = false;

        for (person p : personas) {
            if (!p.isActive()) {
                System.out.println(p);
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay personas inactivas.");
        }
    }

    public static void crearPersona() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Cedula: ");
        String cedula = sc.nextLine();

        System.out.print("Genero: ");
        String genero = sc.nextLine();

        System.out.print("Estado: ");
        String estado = sc.nextLine();

        System.out.print("RH: ");
        String rh = sc.nextLine();

        System.out.print("Telefono: ");
        String telefono = sc.nextLine();

        System.out.print("Activo (true/false): ");
        boolean activo = sc.nextBoolean();

        personas.add(new person(nombre, cedula, genero, estado, rh, telefono, activo));
        System.out.println("Persona creada.");
    }

    public static person buscarPorCedula(String cedula) {
        for (person p : personas) {
            if (p.getDocument_id().equals(cedula)) {
                return p;
            }
        }
        return null;
    }

    public static void buscarPersona() {
        System.out.print("Cedula: ");
        String cedula = sc.nextLine();

        person p = buscarPorCedula(cedula);

        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    public static void mostrarTodas() {
        for (person p : personas) {
            System.out.println(p);
        }
    }
}