package requisito1;

public class contrato {

    public int id;
    public String personaCedula;
    public String tipo;
    public double salario;
    public String fechaInicio;

    public contrato(
        int id,
        String personaCedula,
        String tipo,
        double salario,
        String fechaInicio
    ) {

        this.id = id;
        this.personaCedula = personaCedula;
        this.tipo = tipo;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
    }

    public void mostrarInfo() {

        System.out.println("ID Contrato: " + id);
        System.out.println("Cedula Persona: " + personaCedula);
        System.out.println("Tipo: " + tipo);
        System.out.println("Salario: " + salario);
        System.out.println("Fecha Inicio: " + fechaInicio);
    }
}