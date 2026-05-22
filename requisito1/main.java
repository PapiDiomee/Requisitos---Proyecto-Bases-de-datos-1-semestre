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
            
            opcion = leerOpcionMenuPrincipal();

            switch (opcion) {
                case 1: menuPersonas();   break;
                case 2: menuContratos();  break;
            }

        } while (opcion != 0);

        System.out.println("Programa finalizado.");
    }


    public static int leerOpcionMenuPrincipal() {

        while (true) {

            System.out.println("\n¿Que deseas hacer?");
            System.out.println("1) Operaciones de las personas");
            System.out.println("2) Operaciones de los contratos");
            System.out.println("0) Salir");
            System.out.print("Opcion: ");

            
            try {
                int valor = sc.nextInt();
                sc.nextLine(); 
                return valor;  
            } 
            catch (InputMismatchException e) {
                sc.nextLine();                    
                System.out.println("Valor incorrecto");
            }
        }
    }

  
    public static int leerOpcionMenuPersonas() {

        while (true) {

            System.out.println("\n-----MODULO PERSONAS-----");
            System.out.println("1) Crear persona");
            System.out.println("2) Buscar persona por cedula");
            System.out.println("3) Mostrar todas las personas");
            System.out.println("0) Volver al menu principal.");
            System.out.print("Opcion: ");

           
            try {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } 
            catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Valor incorrecto");
            }
        }
    }


    public static int leerOpcionMenuContratos() {

        while (true) {

            System.out.println("\n-----MODULO CONTRATOS-----");
            System.out.println("1) Crear contrato");
            System.out.println("2) Buscar contrato por ID");
            System.out.println("3) Mostrar todos los contratos");
            System.out.println("4) Mostrar contratos por cedula");
            System.out.println("0) Volver al menu principal.");
            System.out.print("Opcion: ");


            try {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;

            } 
            catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Valor incorrecto");
            }
        }
    }

   
    public static int leerIdContrato(String pregunta) {

        while (true) {

            System.out.print(pregunta);

        
            try {
                int valor = sc.nextInt();
                sc.nextLine();

                if (valor <= 0) {
                    System.out.println("Valor incorrecto");
                    continue; 
                }

                return valor;
            } 
            catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Valor incorrecto");
            }
        }
    }

    
    public static double leerSalario(String pregunta) {

        while (true) {

            System.out.print(pregunta);

            
            try {
                double valor = sc.nextDouble();
                sc.nextLine();

                if (valor <= 0) {
                    System.out.println("Valor incorrecto");
                    continue;
                }

                return valor;
            } 
            catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Valor incorrecto");
            }
        }
    }

   
    public static String leerTexto(String pregunta) {

        while (true) {

            System.out.print(pregunta);
            String valor = sc.nextLine().trim();

            if (!valor.isEmpty()) {
                return valor;
            }
            System.out.println("Valor incorrecto");
        }
    }


    public static String leerCedula(String pregunta) {

        while (true) {

            System.out.print(pregunta);
            String valor = sc.nextLine().trim();

            if (!valor.isEmpty() && valor.matches("\\d+")) {
                return valor;
            }
            System.out.println("Valor incorrecto");
        }
    }

    
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


    public static void crearPersona() {

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