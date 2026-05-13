package requisito1;

public class person {

    String name;
    String document_id;
    String gender;
    String state;
    String rh;
    String phone;
    boolean active;

    public person(
        String nombre,
        String cedula,
        String gender,
        String state,
        String rh,
        String phone,
        boolean active
    ) {

        this.name = nombre;
        this.document_id = cedula;
        this.gender = gender;
        this.state = state;
        this.rh = rh;
        this.phone = phone;
        this.active = active;
    }

    public String getDocument_id() {
        return document_id;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {

        return "Nombre: " + name +
               ", Cedula: " + document_id +
               ", Genero: " + gender +
               ", Estado: " + state +
               ", RH: " + rh +
               ", Telefono: " + phone +
               ", Activo: " + active;
    }
}