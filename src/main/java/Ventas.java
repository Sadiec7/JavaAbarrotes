import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Salvador Camacho Pacheco
 */

/*
La clase Ventas proporciona métodos para agregar un pedido, obtener el número de 
la nota de venta, obtener un iterador para recorrer los pedidos, obtener el costo 
total de los impuestos sobre los pedidos
*/
public class Ventas {
    
    private ArrayList<Pedido> pedidos;
    private int noNotaVenta = 0;

    /**
     * Constructor de la clase Ventas.
     * Inicializa la lista de pedidos.
     */
    public Ventas() {
        pedidos = new ArrayList<>();
    }

    /**
     * Agrega un pedido a la lista de pedidos y actualiza el número de nota de venta.
     * @param pedido El pedido a agregar.
     */
    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
        noNotaVenta++;
    }
    
    /**
     * Retorna el número actual de nota de venta.
     * @return El número de nota de venta.
     */
    public int retornarNoVenta(){
        return noNotaVenta;
    }

    /**
     * Obtiene un iterador para recorrer los pedidos.
     * @return Un iterador de pedidos.
     */
    public Iterator<Pedido> iterator() {
        return pedidos.iterator();
    }

    /**
     * Obtiene el número de la nota de venta.
     * @return El número de la nota de venta.
     */
    public int getNoNotaVenta() {
        return noNotaVenta;
    }

    /**
     * Calcula el costo total de los impuestos sobre los pedidos.
     * @return El costo total de los impuestos.
     */
    public double getCostoImpuestos() {
        double costoImpuestos = 0.0;
        for (Pedido pedido : pedidos) {
            costoImpuestos += pedido.getCostoTotal() * 0.16; // Puse un impuesto del 16%
        }
        return costoImpuestos;
    }
    
    /**
     * Calcula el costo total sin impuestos de los pedidos.
     * @return El costo total sin impuestos.
     */
    public double getCostoSinImpuestos() {
        double costoSinImpuestos = 0.0;
        for (Pedido pedido : pedidos) {
            costoSinImpuestos += pedido.getCostoTotal();
        }
        return costoSinImpuestos;
    }

    /**
     * Retorna una representación en forma de cadena de la clase Ventas.
     * @return La representación en forma de cadena de la clase Ventas.
     */
    @Override
    public String toString() {
        return "Ventas{" + "pedidos=" + pedidos + ", noNotaVenta=" + noNotaVenta + '}';
    }
}
