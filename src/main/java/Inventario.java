
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Salvador Camacho Pacheco
 */

/*
 * La clase Inventario representa una colección de productos.
 */
public class Inventario implements Iterable<Producto> {

    private ArrayList<Producto> productos;  // Lista de productos

    public Inventario() {
        productos = new ArrayList<>();  // Inicializa la lista de productos en el constructor
    }

    public void addProducto(Producto producto) {
        productos.add(producto);  // Agrega un producto a la lista
    }

    public Producto getProduct(Producto producto) {
        for (Producto p : productos) {
            if (p.equals(producto)) {
                return p;  // Devuelve el producto especificado si se encuentra en la lista
            }
        }
        return null;  // Si no se encuentra el producto, devuelve null
    }

    public Iterator<Producto> iterator() {
        return productos.iterator();  // Devuelve un iterador para recorrer los productos
    }

    public int getNumProductos() {
        return productos.size();  // Devuelve el número de productos en la lista
    }

    public boolean removeProducto(int numeroProducto) {
        Iterator<Producto> iterator = productos.iterator();
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            if (producto.getNoProducto() == numeroProducto) {
                iterator.remove();
                return true;  // Si se encuentra y elimina el producto, devuelve true
            }
        }
        return false;  // Si no se encuentra el producto, devuelve false
    }

    public Producto getProductoByNumero(int numeroArticulo) {
        for (Producto producto : productos) {
            if (producto.getNoProducto() == numeroArticulo) {
                return producto;  // Devuelve el producto con el número de artículo especificado
            }
        }
        return null;  // Si no se encuentra el producto, devuelve null
    }
}
