/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author saldi
 */
public class Persona {
    
    private String razonSocial;
    private String rfc;
    private String telefono;
    private String nombreContacto;

    public Persona(String razonSocial, String rfc, String telefono, String nombreContacto) {
        this.razonSocial = razonSocial;
        this.rfc = rfc;
        this.telefono = telefono;
        this.nombreContacto = nombreContacto;
    }
    
    public String getRazonSocial() {
        return razonSocial;
    }

    public String getRfc() {
        return rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

   
}
