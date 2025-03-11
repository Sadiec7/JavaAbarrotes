import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Salvador Camacho Pacheco
 */

/*
* La clase Pedido representa un pedido de productos realizado.
*/
public class Pedido implements Iterable<OrderPedido> {
    
    private ArrayList<OrderPedido> orderPedidos;
    private int numeroCliente;
    private LocalDate fecha;
    private int code = 0;
    LocalDate fechas = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String fechasString = fechas.format(formatter);
    
    /*
     * Constructor de la clase Pedido.
     * Inicializa la lista de OrderPedido.
     * numeroCliente El número de cliente asociado al pedido.
     * fecha La fecha del pedido en formato "dd/MM/yyyy".
     */
    public Pedido(int numeroCliente, String fecha) {
        orderPedidos = new ArrayList<>();
        this.numeroCliente = numeroCliente;
        this.fecha = LocalDate.parse(fecha, formatter);
    }

    /**
     * Agrega un OrderPedido a la lista de pedidos y actualiza el código del pedido.
     * orderPedido El OrderPedido a agregar.
     * newCode El nuevo código del pedido.
     */
    public void addPed(OrderPedido orderPedido, int newCode) {
        orderPedidos.add(orderPedido);
        code = newCode;
    }

    /*
     * Remueve un OrderPedido de la lista de pedidos.
     * orderPedido El OrderPedido a remover.
     */
    public void removePed(OrderPedido orderPedido) {
        orderPedidos.remove(orderPedido);
    }

    /*
     * Obtiene un OrderPedido basado en el producto asociado.
     * producto El producto asociado al OrderPedido.
     * @return El OrderPedido correspondiente al producto, o null si no se encuentra.
     */
    public OrderPedido getPed(Producto producto) {
        for (OrderPedido orderPedido : orderPedidos) {
            if (orderPedido.getProducto().equals(producto)) {
                return orderPedido;
            }
        }
        return null;
    }

    /*
     * Obtiene un iterador para recorrer los OrderPedido del pedido.
     * @return Un iterador de OrderPedido.
     */
    public Iterator<OrderPedido> iterator() {
        return orderPedidos.iterator();
    }

    /*
     * Obtiene el número total de OrderPedido en el pedido.
     * @return El número total de OrderPedido.
     */
    public int getNumOfPedidos() {
        return orderPedidos.size();
    }

    /*
     * Calcula el costo total del pedido sumando el valor de cada OrderPedido.
     * @return El costo total del pedido.
     */
    public double getCostoTotal() {
        double costoTotal = 0.0;
        for (OrderPedido orderPedido : orderPedidos) {
            costoTotal += orderPedido.getValor();
        }
        return costoTotal;
    }
    
    /*
     * Obtiene el código del pedido.
     * @return El código del pedido.
     */
    public int getCode() {
        return code;
    }

    /*
     * Establece el código del pedido.
     * @param code El nuevo código del pedido.
     */
    public void setCode(int code) {
        this.code = code;
    }
    
    /*
     * Obtiene el OrderPedido basado en el número de pedido.
     * numeroPedido El número de pedido.
     * @return El OrderPedido correspondiente al número de pedido, o null si no se encuentra.
     */
    public OrderPedido getPedido(int numeroPedido) {
        for (OrderPedido pedido : orderPedidos) {
            if (pedido.getProducto().equals(numeroPedido)) {
                return pedido;
            }
        }
        return null;
    }
    
    /*
     * Obtiene el número de cliente asociado al pedido.
     * @return El número de cliente.
     */
    public int getNumeroCliente() {
        return numeroCliente;
    }
    
    /*
     * Obtiene la fecha del pedido.
     * @return La fecha del pedido.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /*
     * Retorna una representación en forma de cadena del pedido.
     * @return La representación en forma de cadena del pedido.
     */
    @Override
    public String toString() {
        String result = "FACTURA no." + code + "\n";
        result += "--------------------\n";
        result += "Fecha: " + fechasString + "\n";
       
        result += "Productos:\n";

        int numPedido = 1;
        double totalSinImpuestos = 0.0;
        double totalConImpuestos = 0.0;
        Iterator<OrderPedido> pedidoIterator = orderPedidos.iterator();

        while (pedidoIterator.hasNext()) {
            OrderPedido orderPedido = pedidoIterator.next();
            Producto producto = orderPedido.getProducto();
            int cantidad = orderPedido.getCantidad();
            double subtotal = producto.getPrecioUnitario() * cantidad;

            result += "Producto Pedido #" + numPedido + "\n";
            result += "Producto: " + producto.getDescripcion() + "\n";
            result += "Cantidad: " + cantidad + "\n";
            result += "Precio Unitario: $" + producto.getPrecioUnitario() + "\n";
            result += "Subtotal: $" + subtotal + "\n";
            result += "--------------------\n";

            totalSinImpuestos += subtotal;
            totalConImpuestos += subtotal * 1.16;

            numPedido++;
        }

        result += "--------------------\n";
        result += "Total sin impuestos: $" + totalSinImpuestos + "\n";
        result += "Total con impuestos: $" + totalConImpuestos + "\n";

        return result;
    }
}