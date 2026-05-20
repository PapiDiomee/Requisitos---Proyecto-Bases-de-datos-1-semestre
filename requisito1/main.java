package requisito1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    static ArrayList<person> personas = new ArrayList<>();
    static ArrayList<contrato> contratos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            // La pregunta se imprime al inicio de cada iteración (incluso tras error)
            opcion = leerOpcionMenuPrincipal();

            switch (opcion) {
                case 1: menuPersonas();   break;
                case 2: menuContratos();  break;
            }

        } while (opcion != 0);

        System.out.println("Programa finalizado.");
    }

    // -------------------------------------------------------
    // MÉTODOS DE LECTURA — Patrón: Pregunta → Try → Catch
    // Cada método imprime su propio prompt dentro del bucle,
    // de modo que al fallar se vuelve a mostrar la pregunta.
    // -------------------------------------------------------

    /**
     * Menú principal.
     * Patrón: imprime el menú → intenta leer → captura error → repite desde la impresión.
     */
    public static int leerOpcionMenuPrincipal() {

        while (true) {

            // PASO A — Pregunta / menú completo
            System.out.println("\n¿Que deseas hacer?");
            System.out.println("1) Operaciones de las personas");
            System.out.println("2) Operaciones de los contratos");
            System.out.println("0) Salir");
            System.out.print("Opcion: ");

            // PASO B — Lectura dentro del try
            try {
                int valor = sc.nextInt();
                sc.nextLine(); // limpiar salto de línea residual
                return valor;  // dato válido: salir del bucle

            // PASO C — Captura, mensaje y limpieza de buffer
            } catch (InputMismatchException e) {
                sc.nextLine();                        // descartar la entrada inválida
                System.out.println("Valor incorrecto");
                // el bucle vuelve al PASO A automáticamente
            }
        }
    }

    /**
     * Menú de personas.
     * Misma lógica: menú dentro del bucle para que se repinte tras un error.
     */
    public static int leerOpcionMenuPersonas() {

        while (true) {

            // PASO A
            System.out.println("\n-----MODULO PERSONAS-----");
            System.out.println("1) Crear persona");
            System.out.println("2) Buscar persona por cedula");
            System.out.println("3) Mostrar todas las personas");
            System.out.println("0) Volver al menu principal.");
            System.out.print("Opcion: ");

            // PASO B
            try {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;

            // PASO C
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Valor incorrecto");
            }
        }
    }

    /**
     * Menú de contratos.
     */
    public static int leerOpcionMenuContratos() {

        while (true) {

            // PASO A
            System.out.println("\n-----MODULO CONTRATOS-----");
            System.out.println("1) Crear contrato");
            System.out.println("2) Buscar contrato por ID");
            System.out.println("3) Mostrar todos los contratos");
            System.out.println("4) Mostrar contratos por cedula");
            System.out.println("0) Volver al menu principal.");
            System.out.print("Opcion: ");

            // PASO B
            try {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;

            // PASO C
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Valor incorrecto");
            }
        }
    }

    /**
     * Lee el ID de un contrato (entero positivo).
     * La pregunta se recibe como parámetro para poder reimprimirla en cada intento.
     */
    public static int leerIdContrato(String pregunta) {

        while (true) {

            // PASO A
            System.out.print(pregunta);

            // PASO B
            try {
                int valor = sc.nextInt();
                sc.nextLine();

                if (valor <= 0) {
                    System.out.println("Valor incorrecto");
                    continue; // vuelve al PASO A
                }

                return valor;

            // PASO C
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Valor incorrecto");
            }
        }
    }

    /**
     * Lee un salario (decimal positivo).
     * La pregunta se reimprime en cada intento fallido.
     */
    public static double leerSalario(String pregunta) {

        while (true) {

            // PASO A
            System.out.print(pregunta);

            // PASO B
            try {
                double valor = sc.nextDouble();
                sc.nextLine();

                if (valor <= 0) {
                    System.out.println("Valor incorrecto");
                    continue;
                }

                return valor;

            // PASO C
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Valor incorrecto");
            }
        }
    }

    /**
     * Lee una cadena de texto no vacía.
     * La pregunta se reimprime si el usuario deja el campo en blanco.
     */
    public static String leerTexto(String pregunta) {

        while (true) {

            // PASO A
            System.out.print(pregunta);

            // PASO B — nextLine() no lanza InputMismatchException; se valida manualmente
            String valor = sc.nextLine().trim();

            if (!valor.isEmpty()) {
                return valor;
            }

            // PASO C equivalente para texto vacío
            System.out.println("Valor incorrecto");
        }
    }

    /**
     * Lee una cédula: texto no vacío compuesto solo por dígitos.
     * La pregunta se reimprime en cada intento fallido.
     */
    public static String leerCedula(String pregunta) {

        while (true) {

            // PASO A
            System.out.print(pregunta);

            // PASO B
            String valor = sc.nextLine().trim();

            if (!valor.isEmpty() && valor.matches("\\d+")) {
                return valor;
            }

            // PASO C
            System.out.println("Valor incorrecto");
        }
    }

    // -------------------------------------------------------
    // MENÚS DE NAVEGACIÓN
    // -------------------------------------------------------

    public static void menuPersonas() {

        int op;

        do {
            op = leerOpcionMenuPersonas();

            switch (op) {
                case 1: crearPersona();  break;
                case 2: buscarPersona(); break;
                case 3: mostrarTodas();  break;
            }

        } while (op != 0);
    }

    public static void menuContratos() {

        int op;

        do {
            op = leerOpcionMenuContratos();

            switch (op) {
                case 1: crearContrato();              break;
                case 2: buscarContrato();             break;
                case 3: mostrarContratos();           break;
                case 4: mostrarContratosPorCedula();  break;
            }

        } while (op != 0);
    }

    // -------------------------------------------------------
    // OPERACIONES DE PERSONAS
    // -------------------------------------------------------

    public static void crearPersona() {

        // Cada llamada incluye su propio prompt; si falla, ese prompt se repite
        String nombre   = leerTexto("Nombre: ");
        String cedula   = leerCedula("Cedula: ");
        String genero   = leerTexto("Genero: ");
        String estado   = leerTexto("Estado: ");
        String rh       = leerTexto("RH: ");
        String telefono = leerTexto("Telefono: ");

        personas.add(new person(nombre, cedula, genero, estado, rh, telefono));

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

        String cedula = leerCedula("Cedula: ");
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

    // -------------------------------------------------------
    // OPERACIONES DE CONTRATOS
    // -------------------------------------------------------

    public static void crearContrato() {

        int id        = leerIdContrato("ID del contrato: ");
        String cedula = leerCedula("Cedula de la persona: ");

        person p = buscarPorCedula(cedula);

        if (p == null) {
            System.out.println("\nLa persona no existe. Debes crear una persona.");
            return;
        }

        String tipo    = leerTexto("Tipo de contrato: ");
        double salario = leerSalario("Salario: ");
        String fecha   = leerTexto("Fecha inicio: ");

        contratos.add(new contrato(id, cedula, tipo, salario, fecha));

        System.out.println("Contrato creado correctamente.");
    }

    public static void buscarContrato() {

        int id = leerIdContrato("Ingrese ID del contrato: ");

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
        }
    }

    public static void mostrarContratosPorCedula() {

        String cedula = leerCedula("Ingrese cedula: ");
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