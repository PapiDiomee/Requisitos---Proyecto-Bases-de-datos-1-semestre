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
            System.out.println("1) Operaciones de las personas");
            System.out.println("2) Operaciones de los contratos");
            System.out.println("0) Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {

                case 1:
                    menuPersonas();
                    break;

                case 2:
                    menuContratos();
                    break;
            }

        } while (opcion != 0);

        System.out.println("Programa finalizado.");
    }

    public static void menuPersonas() {

        int op;

        do {

            System.out.println("\n-----MODULO PERSONAS-----");
            System.out.println("1) Crear persona");
            System.out.println("2) Buscar persona por cedula");
            System.out.println("3) Mostrar todas las personas");
            System.out.println("4) Mostrar personas activas");
            System.out.println("5) Mostrar personas inactivas");
            System.out.println("0) Volver al menú principal.");

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

    public static void menuContratos() {

        int op;

        do {

            System.out.println("\n-----MODULO CONTRATOS-----");
            System.out.println("1) Crear contrato");
            System.out.println("2) Buscar contrato por ID");
            System.out.println("3) Mostrar todos los contratos");
            System.out.println("4) Mostrar contratos por cedula");
            System.out.println("0) Volver al menú principal.");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    crearContrato();
                    break;

                case 2:
                    buscarContrato();
                    break;

                case 3:
                    mostrarContratos();
                    break;

                case 4:
                    mostrarContratosPorCedula();
                    break;
            }

        } while (op != 0);
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
        sc.nextLine();

        personas.add(
            new person(
                nombre,
                cedula,
                genero,
                estado,
                rh,
                telefono,
                activo
            )
        );

        System.out.println("\nPersona creada.");
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
            System.out.println("\nPersona no encontrada.");
        }
    }

    public static void mostrarTodas() {

        if (personas.isEmpty()) {
            System.out.println("\nNo hay personas registradas.");
            return;
        }

        for (person p : personas) {
            System.out.println(p);
        }
    }

    public static void mostrarActivas() {

        boolean hay = false;

        for (person p : personas) {

            if (p.isActive()) {
                System.out.println(p);
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("\nNo hay personas activas.");
        }
    }

    public static void mostrarInactivas() {

        boolean hay = false;

        for (person p : personas) {

            if (!p.isActive()) {
                System.out.println(p);
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("\nNo hay personas inactivas.");
        }
    }

    public static void crearContrato() {

        System.out.print("ID del contrato: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Cedula de la persona: ");
        String cedula = sc.nextLine();

        person p = buscarPorCedula(cedula);

        if (p == null) {

            System.out.println("\nLa persona no existe. Debes crear una persona.");
            return;
        }

        System.out.print("Tipo de contrato: ");
        String tipo = sc.nextLine();

        System.out.print("Salario: ");
        double salario = sc.nextDouble();
        sc.nextLine();

        System.out.print("Fecha inicio: ");
        String fecha = sc.nextLine();

        contratos.add(
            new contrato(
                id,
                cedula,
                tipo,
                salario,
                fecha
            )
        );

        System.out.println("Contrato creado correctamente.");
    }

    public static void buscarContrato() {

        System.out.print("Ingrese ID del contrato: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (contrato c : contratos) {

            if (c.id == id) {

                c.mostrarInfo();
                return;
            }
        }

        System.out.println("Contrato no encontrado.");
    }

    public static void mostrarContratos() {

        if (contratos.isEmpty()) {

            System.out.println("\nNo hay contratos registrados.");
            return;
        }

        for (contrato c : contratos) {

            c.mostrarInfo();
            System.out.println("---------------------");
        }
    }

    public static void mostrarContratosPorCedula() {

        System.out.print("Ingrese cedula: ");
        String cedula = sc.nextLine();

        boolean encontrado = false;

        for (contrato c : contratos) {

            if (c.personaCedula.equals(cedula)) {

                c.mostrarInfo();
                System.out.println("---------------------");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("\nNo existen contratos para esa persona.");
        }
    }
}