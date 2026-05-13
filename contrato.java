package requisito;
public class contrato {

    private String idContrato;
    private String cedulaPersona;

    public contrato(String idContrato, String cedulaPersona) {
        this.idContrato = idContrato;
        this.cedulaPersona = cedulaPersona;
    }

    public String getIdContrato() {
        return idContrato;
    }

    public String getCedulaPersona() {
        return cedulaPersona;
    }

    
    public String toString() {
        return "ID: " + idContrato + ", Cedula: " + cedulaPersona;
    }
}