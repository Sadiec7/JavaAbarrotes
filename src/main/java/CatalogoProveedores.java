
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Salvador Camacho Pacheco
 */

/*
 * La clase CatalogoProveedores representa una colección de proveedores.
 */
public class CatalogoProveedores implements Iterable<Proveedor> {
    private ArrayList<Proveedor> proveedores;  // Lista de proveedores

    public CatalogoProveedores() {
        proveedores = new ArrayList<>();  // Inicializa la lista de proveedores en el constructor
    }

    public void addProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);  // Agrega un proveedor a la lista
    }

    public Proveedor getProveedor(String rfc) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getRfc().equals(rfc)) {
                return proveedor;  // Devuelve el proveedor con el RFC especificado
            }
        }
        return null;  // Si no se encuentra el proveedor, devuelve null
    }

    public Iterator<Proveedor> iterator() {
        return proveedores.iterator();  // Devuelve un iterador para recorrer los proveedores
    }

    public int getNumProveedores() {
        return proveedores.size();  // Devuelve el número de proveedores en la lista
    }

    public boolean removeProveedor(String rfc) {
        Iterator<Proveedor> iterator = proveedores.iterator();
        while (iterator.hasNext()) {
            Proveedor proveedor = iterator.next();
            if (proveedor.getRfc().equals(rfc)) {
                iterator.remove();
                return true;  // Devuelve true si se elimina el proveedor con el RFC especificado
            }
        }
        return false; // Devuelve false si no se encuentra el proveedor con el RFC especificado
    }

    public Proveedor getProveedorByRFC(String rfc) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getRfc().equals(rfc)) {
                return proveedor;  // Devuelve el proveedor con el RFC especificado
            }
        }
        return null;  // Si no se encuentra el proveedor, devuelve null
    }
}
