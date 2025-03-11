/**
 *
 * @author Salvador Camacho Pacheco
 */

/*
 * La clase Producto representa un producto de la tienda con su información asociada.
 */
public class Producto {
    
    public double impuestos; // Los impuestos asociados al producto (no se utiliza en el código provisto)
    private int noProducto; // El número de identificación del producto
    private String descripcion; // La descripción del producto
    private double precioUnitario; // El precio unitario del producto
    private int cantidad; // La cantidad disponible del producto
    private Proveedor proveedor; // El proveedor del producto

    /**
     * Crea un nuevo Producto con el número, descripción, precio unitario y cantidad especificados.
     * noProducto El número de identificación del producto
     * descripcion La descripción del producto
     * precioUnitario El precio unitario del producto
     * cantidad La cantidad disponible del producto
     */
    public Producto(int noProducto, String descripcion, double precioUnitario, int cantidad) {
        this.noProducto = noProducto;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    /*
     * Establece el número de identificación del producto.
     * noProducto El nuevo número de identificación del producto
     */
    public void setNoProducto(int noProducto) {
        this.noProducto = noProducto;
    }

    /*
     * Establece la descripción del producto.
     * descripcion La nueva descripción del producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*
     * Establece el precio unitario del producto.
     * precioUnitario El nuevo precio unitario del producto
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /*
     * Establece la cantidad disponible del producto.
     * cantidad La nueva cantidad disponible del producto
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /*
     * Establece el proveedor del producto.
     * proveedor El nuevo proveedor del producto
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
   
    /*
     * Obtiene el número de identificación del producto.
     * @return El número de identificación del producto
     */
    public int getNoProducto() {
        return noProducto;
    }

    /*
     * Obtiene la descripción del producto.
     * @return La descripción del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /*
     * Obtiene el precio unitario del producto.
     * @return El precio unitario del producto
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /*
     * Obtiene la cantidad disponible del producto.
     * @return La cantidad disponible del producto
     */
    public int getCantidad() {
        return cantidad;
    }
    
    /**
     * Aumenta o disminuye la cantidad disponible del producto en función de una nueva cantidad.catidad La cantidad a sumar o restar a la cantidad actual del producto
     * @param catidad
    */
    public void setNewCantidad(int cant){
        cantidad = cantidad - cant; // Aumenta o disminuye la cantidad según la nueva cantidad
    }

    /**
     * Obtiene el proveedor del producto. 
     * @return El proveedor del producto
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    //Métodos para hacer comparaciones entre productos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Producto other = (Producto) obj;
        return noProducto == other.noProducto;
    }
    
    /* Coniverte los valores a una cadena de caracteres
     * @return La cadena de caracteres
     */
    @Override
    public String toString() {
        return "Numero de Producto: " + noProducto + ", Descripcion: " + 
                descripcion + ", Precio Unitario: " + precioUnitario
                + ", Cantidad: " + cantidad;
    }
    
    /*
     * Obtiene los impuestos asociados al producto.
     * @return Los impuestos asociados al producto
     */
    public double getImpuestos() {
        return impuestos;
    }
}