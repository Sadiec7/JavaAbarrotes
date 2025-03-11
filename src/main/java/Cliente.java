/**
 *
 * @author Salvador Camacho Pacheco
 */

/*
 * La clase Cliente representa a un cliente en el sistema.
 */
public class Cliente {

    private String razonSocial;
    private String rfc;
    private String telefono;
    private String nombreContacto;
    private int noCliente;
    private String direccionFiscal;

    /*
     * Constructor de Cliente
     * razonSocial La razón social del cliente.
     * rfc El RFC (Registro Federal de Contribuyentes) del cliente.
     * telefono El número de teléfono del cliente.
     * nombreContacto El nombre del contacto del cliente.
     * noCliente El número de cliente asignado.
     * direccionFiscal La dirección fiscal del cliente.
     */
    public Cliente(String razonSocial, String rfc, String telefono,
            String nombreContacto, int noCliente, String direccionFiscal) {
        this.razonSocial = razonSocial;
        this.rfc = rfc;
        this.telefono = telefono;
        this.nombreContacto = nombreContacto;
        this.noCliente = noCliente;
        this.direccionFiscal = direccionFiscal;
    }

    /**
     * Obtiene el número de cliente.
     *
     * @return El número de cliente.
     */
    public int getNoCliente() {
        return noCliente;
    }

    /**
     * Establece el número de cliente. noCliente El número de cliente a
     * establecer.
     */
    public void setNoCliente(int noCliente) {
        this.noCliente = noCliente;
    }

    /**
     * Obtiene la dirección fiscal del cliente.
     *
     * @return La dirección fiscal del cliente.
     */
    public String getDireccionFiscal() {
        return direccionFiscal;
    }

    /**
     * Establece la dirección fiscal del cliente. direccionFiscal La dirección
     * fiscal a establecer.
     */
    public void setDireccionFiscal(String direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }

    /**
     * Devuelve una representación en cadena del objeto Cliente.
     *
     * @return Una cadena que representa al cliente.
     */
    @Override
    public String toString() {
        return "Numero Cliente: " + noCliente + " ,Razon Social: " + razonSocial
                + ", RFC:" + rfc + ", " + "Telefono: " + telefono + ", Nombre Contacto: "
                + nombreContacto + ", Direccion Fiscal: " + direccionFiscal;
    }

    /**
     * Obtiene la razón social del cliente.
     *
     * @return La razón social del cliente.
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Establece la razón social del cliente. razonSocial La razón social a
     * establecer.
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * Obtiene el RFC del cliente.
     *
     * @return El RFC del cliente.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC del cliente. rfc El RFC a establecer.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene el número de teléfono del cliente. El número de teléfono del
     * cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del cliente. telefono El número de
     * teléfono a establecer.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el nombre del contacto del cliente. El nombre del contacto del
     * cliente.
     */
    public String getNombreContacto() {
        return nombreContacto;
    }

    /**
     * Establece el nombre del contacto del cliente. nombreContacto El nombre
     * del contacto a establecer.
     */
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
}
