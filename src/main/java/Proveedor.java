/**
 *
 * @author Salvador Camacho Pacheco
 */

/*
 * La clase Proveedor representa a un proveedor en el sistema.
 */
public class Proveedor {
    
    private String razonSocial;
    private String rfc;
    private String telefono;
    private String nombreContacto;
    private String fax;
    private String direccion;
    private String emailContac;
    private String telefonoContac;

    /*
    Constructor de proveedores
    razonSocial: una cadena que representa la razón social del proveedor.
    rfc: una cadena que representa el Registro Federal de Contribuyentes (RFC) del proveedor.
    telefono: una cadena que representa el número de teléfono del proveedor.
    nombreContacto: una cadena que representa el nombre del contacto del proveedor.
    fax: una cadena que representa el número de fax del proveedor.
    direccion: una cadena que representa la dirección del proveedor.
    emailContac: una cadena que representa el correo electrónico de contacto del proveedor.
    telefonoContac: una cadena que representa el número de teléfono de contacto del proveedor.
    */
    public Proveedor(String razonSocial, String rfc, String telefono, 
            String nombreContacto, String fax, String direccion, 
            String emailContac, String telefonoContac) {
        this.razonSocial = razonSocial;
        this.rfc = rfc;
        this.telefono = telefono;
        this.nombreContacto = nombreContacto;
        this.fax = fax;
        this.direccion = direccion;
        this.emailContac = emailContac;
        this.telefonoContac = telefonoContac;
    }
    
    // Métodos para obtener y establecer el fax del proveedor
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    // Métodos para obtener y establecer la dirección del proveedor
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Métodos para obtener y establecer el email de contacto del proveedor
    public String getEmailContac() {
        return emailContac;
    }

    public void setEmailContac(String emailContac) {
        this.emailContac = emailContac;
    }

    // Métodos para obtener y establecer el teléfono de contacto del proveedor
    public String getTelefonoContac() {
        return telefonoContac;
    }

    public void setTelefonoContac(String telefonoContac) {
        this.telefonoContac = telefonoContac;
    }

    @Override
    public String toString() {
        // Devuelve una representación en cadena del proveedor
        return  "RFC: " + rfc + ", Razon Social: " + razonSocial + ", "
                + "Telefono: " + telefono + ", Nombre Contacto: " + nombreContacto 
                + ", Fax: " + fax + ", Direccion: " + direccion + ", Email Contaco: " 
                + emailContac + ", Telefono Contaco: " + telefonoContac;
    }

    // Métodos para obtener y establecer la razón social del proveedor
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    // Métodos para obtener y establecer el RFC del proveedor
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    // Métodos para obtener y establecer el teléfono del proveedor
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Métodos para obtener y establecer el nombre de contacto del proveedor
    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
}
