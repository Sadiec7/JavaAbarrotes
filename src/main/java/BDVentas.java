
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Salvador Camacho Pacheco
 */

/*
 * La clase BDVentas representa una colección de ventas.
 */
public class BDVentas implements Iterable<Pedido> {

    private ArrayList<Pedido> tVentas;  // ArrayList para almacenar las ventas

    public BDVentas() {
        tVentas = new ArrayList<>();  // Inicializa el ArrayList de ventas en el constructor
    }

    public Iterator<Pedido> iterator() {
        return tVentas.iterator();  // Devuelve un iterador para el ArrayList de ventas
    }

    public void addVenta(Pedido pedido) {
        tVentas.add(pedido);  // Agrega un objeto Pedido al ArrayList de ventas
    }

    public int getNumVentas() {
        return tVentas.size();  // Devuelve el número de ventas en el ArrayList
    }

    public boolean removeVenta(int noVenta) {
        Iterator<Pedido> iterator = tVentas.iterator(); // Obtiene un iterador para recorrer las ventas
        while (iterator.hasNext()) { // Recorre las ventas utilizando el iterador
            Pedido venta = iterator.next();
            if (venta.getCode() == noVenta) { // Compara el código de venta con el número de venta buscado
                iterator.remove(); // Elimina la venta utilizando el iterador
                return true; // Devuelve true si se encuentra y elimina la venta
            }
        }
        return false; // Devuelve false si no se encuentra ninguna venta con el número buscado
    }

    @Override
    public String toString() {
        String result = "BDVentas {\n";

        for (Pedido venta : tVentas) {  // Recorre las ventas en el ArrayList
            result += "\t" + venta.toString() + "\n";  // Agrega la representación en forma de cadena de cada venta al resultado
        }//En los documentos proporcionados de java, supe cómo utilizar \t

        result += "}";

        return result;  // Devuelve la cadena resultante que representa la base de datos de ventas
    }
}
