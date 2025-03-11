
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Salvador Camacho Pacheco
 */

/*
 * La clase CatalogoClientes representa una colección de clientes.
 */
public class CatalogoClientes implements Iterable<Cliente> {

    private ArrayList<Cliente> clientes;  // Lista de clientes

    public CatalogoClientes() {
        clientes = new ArrayList<>();  // Inicializa la lista de clientes en el constructor
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);  // Agrega un cliente a la lista
    }

    public Cliente getCliente(int noCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNoCliente() == noCliente) {
                return cliente;  // Devuelve el cliente con el número de cliente especificado
            }
        }
        return null;  // Si no se encuentra el cliente, devuelve null
    }

    public Iterator<Cliente> iterator() {
        return clientes.iterator();  // Devuelve un iterador para recorrer los clientes
    }

    public int getNumClientes() {
        return clientes.size();  // Devuelve el número de clientes en la lista
    }

    public Cliente getClienteByNombre(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombreContacto().equalsIgnoreCase(nombre)) {
                return cliente;  // Devuelve el cliente con el nombre de contacto especificado (ignorando mayúsculas y minúsculas)
            }
        }
        return null;  // Si no se encuentra el cliente, devuelve null
    }

    public boolean removeCliente(int noCliente) {
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getNoCliente() == noCliente) {
                iterator.remove();
                return true;  // Si se encuentra y elimina el cliente, devuelve true
            }
        }
        return false;  // Si no se encuentra el cliente, devuelve false
    }

    public Cliente getClienteByNumero(int noCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getNoCliente() == noCliente) {
                return cliente;  // Devuelve el cliente con el número de cliente especificado
            }
        }
        return null;  // Si no se encuentra el cliente, devuelve null
    }
}
