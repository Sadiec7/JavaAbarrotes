
/**
 *
 * @author Salvador Camacho Pacheco
 */

/*
 * La clase OrderPedido representa un pedido de un producto específico con una cantidad determinada.
 */
public class OrderPedido {

    private Producto producto; // El producto asociado al pedido
    private int cantidad; // La cantidad de unidades solicitadas del producto
    private double costo; // El costo total del pedido

    /*
     * Crea un nuevo OrderPedido con el producto y la cantidad especificados.
     * producto El producto asociado al pedido
     * cantidad La cantidad de unidades solicitadas del producto
     */
    public OrderPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.costo = producto.getPrecioUnitario() * cantidad; // Calcula el costo multiplicando el precio unitario por la cantidad
    }

    /*
     * Obtiene el producto asociado al pedido.
     * @return El producto asociado al pedido
     */
    public Producto getProducto() {
        return producto;
    }

    /*
     * Obtiene la cantidad de unidades solicitadas del producto.
     * @return La cantidad de unidades solicitadas del producto
     */
    public int getCantidad() {
        return cantidad;
    }

    /*
     * Establece la cantidad de unidades solicitadas del producto.
     * Actualiza el costo total del pedido en base a la nueva cantidad.
     * newCantidad La nueva cantidad de unidades solicitadas del producto
     */
    public void setCantidad(int newCantidad) {
        cantidad = newCantidad;
        costo = producto.getPrecioUnitario() * cantidad; // Actualiza el costo al modificar la cantidad
    }

    /*
     * Obtiene el costo total del pedido.
     * @return El costo total del pedido
     */
    public double getCosto() {
        return costo;
    }

    /*
     * Coniverte los valores a una cadena de caracteres
     * @return La cadena de caracteres
     */
    @Override
    public String toString() {
        return "Producto: " + producto + ", Cantidad: " + cantidad + ", Costo: " + costo;
    }

    /*
     * Obtiene el valor del pedido sin considerar impuestos u otros costos adicionales.
     * @return El valor del pedido (precio unitario del producto multiplicado por la cantidad)
     */
    public double getValor() {
        return producto.getPrecioUnitario() * cantidad;
    }

}
