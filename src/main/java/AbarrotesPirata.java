
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Salvador Camacho Pacheco
 */

/*
* Clase principal de Abarrotes Pirata
 */
public class AbarrotesPirata {

    // Variables de instancia
    private CatalogoClientes catalogoClientes;
    private CatalogoProveedores catalogoProveedores;
    private Inventario inventario;
    private Pedido pedido;
    private Ventas venta;
    private Producto producto;
    private OrderPedido orderPedido;
    private BDVentas bdVentas;
    private Scanner scanner = new Scanner(System.in);
    public int code = 1;

    // Constructor de la clase AbarrotesPirata
    public AbarrotesPirata() {
        bdVentas = new BDVentas();
        catalogoClientes = new CatalogoClientes();
        catalogoProveedores = new CatalogoProveedores();
        inventario = new Inventario();
    }

    // Método para agregar un cliente al catálogo de clientes
    private void agregarCliente() {
        // Manejo de excepciones en caso de errores
        try {
            boolean prueba = true;
            System.out.println("----- Agregar Cliente -----");
            System.out.print("Ingrese la razón social (sin espacios): ");
            String razonSocial = scanner.next();
            System.out.print("Ingrese el RFC: ");
            String rfc = scanner.next();
            System.out.print("Ingrese el teléfono: ");
            String telefono = scanner.next();
            System.out.print("Ingrese el nombre de contacto (sin espacios): ");
            String nombreContacto = scanner.next();
            System.out.print("Ingrese el número de cliente: ");
            int noCliente = scanner.nextInt();
            for (Cliente cliente : catalogoClientes) {// bucle para encontrar clientes existentes
                if (noCliente == cliente.getNoCliente()) {
                    prueba = false;
                    break;
                }
            }

            if (prueba) {
                System.out.print("Ingrese la dirección fiscal: ");
                String direccionFiscal = scanner.next();

                Cliente cliente = new Cliente(razonSocial, rfc, telefono, nombreContacto,
                        noCliente, direccionFiscal);
                catalogoClientes.addCliente(cliente);

                System.out.println("Cliente agregado exitosamente.");
            } else {
                System.out.print("Cliente ya existente, por favor, "
                        + "vuelva a intentarlo ");
            }

        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Asegúrese de ingresar los valores correctos.");
        }
    }

    // Método para agregar un proveedor al catálogo de proveedores
    private void agregarProveedor() {
        // Manejo de excepciones en caso de errores
        try {
            boolean prueba = true;
            System.out.println("----- Agregar Proveedor -----");
            System.out.print("Ingrese la razón social (sin espacios): ");
            String razonSocial = scanner.next();
            System.out.print("Ingrese el RFC: ");
            String rfc = scanner.next();

            for (Proveedor pro : catalogoProveedores) {// bucle para encontrar proveedores existentes
                if (rfc.equals(pro.getRfc())) {
                    prueba = false;
                    break;
                }
            }

            if (prueba) {
                System.out.print("Ingrese el teléfono: ");
                String telefono = scanner.next();
                System.out.print("Ingrese el nombre de contacto (sin espacios): ");
                String nombreContacto = scanner.next();
                System.out.print("Ingrese el fax: ");
                String fax = scanner.next();
                System.out.print("Ingrese la dirección: ");
                String direccion = scanner.next();
                System.out.print("Ingrese el email de contacto: ");
                String emailContacto = scanner.next();
                System.out.print("Ingrese el teléfono de contacto: ");
                String telefonoContacto = scanner.next();

                Proveedor proveedor = new Proveedor(razonSocial, rfc, telefono,
                        nombreContacto, fax, direccion,
                        emailContacto, telefonoContacto);
                catalogoProveedores.addProveedor(proveedor);

                System.out.println("Proveedor agregado exitosamente.");
            } else {
                System.out.print("Proveedor ya existente, por favor, "
                        + "vuelva a intentarlo ");
            }
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Asegúrese de ingresar los valores correctos.");
        }
    }

    // Método para agregar un producto al inventario
    private void agregarProductoInventario() {
        // Manejo de excepciones en caso de errores
        try {
            boolean prueba = true;
            System.out.println("----- Agregar Producto al Inventario -----");
            System.out.print("Ingrese el número de producto: ");
            int noProducto = scanner.nextInt();
            for (Producto product : inventario) {// bucle para encontrar productos existentes
                if (noProducto == product.getNoProducto()) {
                    System.out.print("Producto ya existente, por favor, "
                            + "vuelva a intentarlo ");
                    prueba = false;
                    break;
                }
            }

            if (prueba) {
                System.out.print("Ingrese la descripción del producto (sin espacios): ");
                String descripcion = scanner.next();
                System.out.print("Ingrese el precio unitario del producto: ");
                double precioUnitario = scanner.nextDouble();
                System.out.print("Ingrese la cantidad del producto: ");
                int cantidad = scanner.nextInt();
                verCatalogoProveedores();
                System.out.print("Ingrese el RFC del proveedor del producto: ");
                String rfcProveedor = scanner.next();
                Proveedor proveedor = catalogoProveedores.getProveedorByRFC(rfcProveedor);
                if (proveedor == null) {
                    System.out.println("El proveedor no se encuentra en el catálogo.");
                    return;
                }

                Producto producto = new Producto(noProducto, descripcion, precioUnitario, cantidad);
                inventario.addProducto(producto);

                System.out.println("Producto agregado al inventario exitosamente.");
            } else {
                System.out.print("Producto ya existente, por favor, "
                        + "vuelva a intentarlo ");
            }

        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Asegúrese de ingresar los valores correctos.");
        }
    }

    // Método para realizar un pedido, el cual permite imprimir factura si así se solicita
    private void realizarPedido() {
        // Manejo de excepciones en caso de errores
        try {
            if (catalogoClientes.getNumClientes() == 0) {
                System.out.println("El catálogo de clientes está vacío. No se puede realizar un pedido.");
            } else if (inventario.getNumProductos() == 0) {
                System.out.println("El inventario de productos está vacío. No se puede realizar un pedido.");
            } else {
                System.out.println("----- Realizar Pedido -----");

                System.out.println("Catálogo de Clientes:");
                verCatalogoClientes();

                System.out.print("Ingrese el número de cliente: ");
                int noCliente = scanner.nextInt();

                Cliente cliente = catalogoClientes.getCliente(noCliente);
                if (cliente == null) {
                    System.out.println("El número de cliente ingresado no es válido.");
                    return;
                }

                LocalDate fechar = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fecharString = fechar.format(formatter);

                Pedido pedido = new Pedido(noCliente, fecharString);

                boolean agregarProductos = true;
                while (agregarProductos) {
                    System.out.println("Catálogo de Productos:");
                    verInventarioProductos();

                    System.out.print("Ingrese el número de producto: ");
                    int noProducto = scanner.nextInt();

                    Producto producto = inventario.getProductoByNumero(noProducto);
                    if (producto == null) {
                        System.out.println("El número de producto ingresado no es válido.");
                        return;
                    }

                    System.out.print("Ingrese la cantidad del producto: ");
                    int cantidad = scanner.nextInt();

                    if (cantidad <= 0 || cantidad > producto.getCantidad()) {
                        System.out.println("La cantidad ingresada no es válida o no hay "
                                + "suficiente stock disponible." + producto.getCantidad());
                        return;
                    }

                    OrderPedido orderPedido = new OrderPedido(producto, cantidad);

                    pedido.addPed(orderPedido, code);

                    producto.setNewCantidad(cantidad);
                    
                   
                     
                    System.out.print("¿Desea agregar más productos al pedido? (S/N): ");
                    String respuesta = scanner.next();
                    agregarProductos = respuesta.equalsIgnoreCase("S");
                }
                bdVentas.addVenta(pedido);
                code++;//registro de numero de ventas
                System.out.println("Pedido realizado exitosamente.");

                System.out.print("¿Desea imprimir la factura? (S/N)");
                String impFacto = scanner.next();

                if (impFacto.equalsIgnoreCase("S")) {

                    System.out.println("FACTURA no." + pedido.getCode());
                    System.out.println("--------------------");
                    System.out.println("Fecha: " + fecharString);
                    System.out.println("Cliente: " + cliente.getNombreContacto());
                    System.out.println("RFC Cliente: " + cliente.getRfc());
                    System.out.println("Dirección Fiscal Cliente: " + cliente.getDireccionFiscal());
                    System.out.println("Productos:");

                    int numPedido = 1;
                    double totalSinImpuestos = 0.0;
                    double totalConImpuestos = 0.0;
                    Iterator<OrderPedido> pedidoIterator = pedido.iterator();

                    while (pedidoIterator.hasNext()) {
                        OrderPedido orderPedido = pedidoIterator.next();
                        Producto producto = orderPedido.getProducto();
                        int cantidad = orderPedido.getCantidad();
                        double subtotal = producto.getPrecioUnitario() * cantidad;

                        System.out.println("Producto Pedido #" + numPedido);
                        System.out.println("Producto: " + producto.getDescripcion());
                        System.out.println("Cantidad: " + cantidad);
                        System.out.println("Precio Unitario: $" + producto.getPrecioUnitario());
                        System.out.println("Subtotal: $" + subtotal);
                        System.out.println("--------------------");

                        totalSinImpuestos += subtotal;
                        totalConImpuestos += subtotal * 1.16;

                        numPedido++;
                    }

                    System.out.println("--------------------");
                    System.out.println("Total sin impuestos: $" + totalSinImpuestos);
                    System.out.println("Total con impuestos: $" + totalConImpuestos);

                }

            }
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Asegúrese de ingresar los valores correctos." + e);
        }
    }

    /*
    Método que imprime el catálogo de clientes almacenado en la variable catalogoClientes. 
    Comprueba si hay clientes en el catálogo y, si los hay, itera sobre cada cliente e 
    imprime su representación en forma de cadena.
     */
    public void verCatalogoClientes() {
        System.out.println("----- Catálogo de Clientes -----");
        if (catalogoClientes.getNumClientes() > 0) {
            for (Cliente cliente : catalogoClientes) {
                System.out.println(cliente.toString());
            }
        } else {
            System.out.println("No hay clientes en el catálogo.");
        }
    }

    /*
    Método que muestra el catálogo de proveedores almacenado en la variable catalogoProveedores. 
    Verifica si hay proveedores en el catálogo y, si los hay, itera sobre cada proveedor 
    e imprime su representación en forma de cadena.
     */
    public void verCatalogoProveedores() {
        System.out.println("----- Catálogo de Proveedores -----");
        if (catalogoProveedores.getNumProveedores() > 0) {
            for (Proveedor proveedor : catalogoProveedores) {
                System.out.println(proveedor.toString());
            }
        } else {
            System.out.println("No hay proveedores en el catálogo.");
        }
    }

    /*
    Este método muestra el inventario de productos almacenado en la variable inventario. 
    Verifica si hay productos en el inventario y, si los hay, itera sobre cada producto e 
    imprime su representación en forma de cadena.
     */
    public void verInventarioProductos() {
        System.out.println("----- Inventario de Productos -----");
        if (inventario.getNumProductos() > 0) {
            for (Producto producto : inventario) {
                System.out.println(producto.toString());
            }
        } else {
            System.out.println("No hay productos en el inventario.");
        }
    }

    /*
    Método  que muestra las ventas realizadas. Recorre la lista bdVentas y muestra 
    la representación en formato de cadena de cada objeto Pedido utilizando el 
    método toString(). Si no hay ventas registradas, muestra un 
    mensaje indicando que no hay ventas.
     */
    private void verVentas() {
        System.out.println("----- VENTAS -----");
        if (bdVentas.getNumVentas() > 0) {
            for (Pedido ven : bdVentas) {
                System.out.println(ven.toString());
            }
        } else {
            System.out.println("No hay ventas registradas.");
        }
    }

    /*
    Este método permite eliminar un producto del inventario. Solicita al usuario 
    ingresar el número de producto a eliminar y luego utiliza el método removeProducto(numeroProducto) 
    de la lista inventario para eliminar el producto. Muestra el inventario antes 
    y después de la eliminación del producto.
     */
    public void borrarProducto() {
        // Manejo de excepciones en caso de errores
        try {
            System.out.println("Inventario antes de eliminar un producto:");
            for (Producto producto : inventario) {
                System.out.println(producto);
            }

            System.out.print("Ingrese el número de producto a eliminar: ");
            int numeroProducto = scanner.nextInt();

            boolean eliminado = inventario.removeProducto(numeroProducto);

            if (eliminado == true) {
                System.out.println("El producto ha sido eliminado del inventario.");
            } else {
                System.out.println("El producto no se encontraba en el inventario.");
            }

            System.out.println("Inventario después de eliminar un producto:");  // para mostrar inventario después de eliminar un producto
            for (Producto producto : inventario) {
                System.out.println(producto);
            }
        } catch (Exception ex) {
            System.out.println("Error al eliminar el producto de la orden: " + ex.getMessage());
        }
    }

    /*
    Este método permite eliminar un cliente del catálogo. Solicita al usuario ingresar 
    el número de cliente a eliminar y luego utiliza el método removeCliente(numeroCliente) 
    de la lista catalogoClientes para eliminar el cliente. Muestra el catálogo antes y 
    después de la eliminación del cliente.
     */
    public void borrarCliente() {
        try {
            System.out.println("Lista de Clientes antes de eliminar:");
            for (Cliente cliente : catalogoClientes) {
                System.out.println(cliente.toString());
            }

            System.out.print("Ingrese el número de cliente a eliminar: ");
            int numeroCliente = scanner.nextInt();

            boolean eliminado = catalogoClientes.removeCliente(numeroCliente);

            if (eliminado == true) {
                System.out.println("\nEl cliente ha sido eliminado del catálogo.\n");
            } else {
                System.out.println("\nEl cliente no se encontraba en el catálogo.\n");
            }

            System.out.println("Catálogo después de eliminar al cliente:");
            for (Cliente cliente : catalogoClientes) {
                System.out.println(cliente.toString());
            }
        } catch (Exception ex) {
            System.out.println("Error al eliminar el cliente: " + ex.getMessage());
        }
    }

    /*
    Este método permite eliminar un proveedor del catálogo. Solicita al usuario ingresar 
    el RFC del proveedor a eliminar y luego utiliza el método removeProveedor(rfc) 
    de la lista catalogoProveedores para eliminar el proveedor. Muestra el catálogo antes y 
    después de la eliminación del proveedor.
     */
    public void borrarProveedor() {
        // Manejo de excepciones en caso de errores
        String rfc;
        try {
            System.out.println("Lista de Proveedores antes de eliminar un proveedor:");
            for (Proveedor proveedor : catalogoProveedores) {
                System.out.println(proveedor.toString());
            }

            System.out.print("Ingrese el RFC del proveedor a eliminar: ");
            rfc = scanner.next();

            boolean eliminado = catalogoProveedores.removeProveedor(rfc);

            if (eliminado) {
                System.out.println("\nEl proveedor ha sido eliminado del catálogo.\n");
            } else {
                System.out.println("\nEl proveedor no se encontraba en el catálogo.\n");
            }

            System.out.println("Catálogo después de eliminar al proveedor:");
            for (Proveedor proveedor : catalogoProveedores) {
                System.out.println(proveedor.toString());
            }
        } catch (Exception ex) {
            System.out.println("Error al eliminar proveedor: " + ex.getMessage());
        }
    }

    /*
    Este método permite eliminar una venta de la base de datos. Solicita al usuario 
    ingresar el número de venta a eliminar y luego utiliza el método removeVenta(numeroVenta) 
    de la lista bdVentas para eliminar la venta. Muestra la lista de ventas 
    antes y después de la eliminación.
     */
    public void borrarVenta() {
        // Manejo de excepciones en caso de errores
        try {
            System.out.println("Lista de ventas antes de eliminar un producto:");
            verVentas();

            System.out.print("Ingrese el Número de Venta a eliminar: ");
            int numeroVenta = scanner.nextInt();

            boolean eliminado = bdVentas.removeVenta(numeroVenta);

            if (eliminado == true) {
                System.out.println("\nLa venta ha sido eliminada del catálogo.\n");
            } else {
                System.out.println("\nLa venta no se encontraba en el catálogo.-\n");
            }

            System.out.println("Base de datos después de eliminar a la venta:");
            verVentas();

        } catch (Exception ex) {
            System.out.println("Error al eliminar venta: " + ex.getMessage());
        }
    }

    /*
    Este método permite modificar los detalles de un cliente en el catálogo. Solicita 
    al usuario ingresar el número de cliente a modificar y luego utiliza el método 
    getClienteByNumero(numeroCliente) de la lista `catalogo.
     */
    private void modificarProducto() {
        // Manejo de excepciones en caso de errores
        try {
            System.out.println("----- Modificar Artículo del Inventario -----");
            System.out.println("\nInventario:");
            for (Producto producto : inventario) {
                System.out.println(producto);
            }

            System.out.print("\nIngrese el número de artículo a modificar: ");
            int numeroArticulo = scanner.nextInt();

            Producto producto = inventario.getProductoByNumero(numeroArticulo);
            if (producto != null) {
                System.out.println("Datos actuales del artículo:");
                System.out.println(producto.toString());

                System.out.print("Ingrese la nueva descripción del artículo: ");
                String descripcion = scanner.next();
                producto.setDescripcion(descripcion);

                System.out.print("Ingrese el nuevo precio unitario del artículo: ");
                double precioUnitario = scanner.nextDouble();
                producto.setPrecioUnitario(precioUnitario);

                System.out.print("Ingrese la nueva cantidad en inventario del artículo: ");
                int cantidadInventario = scanner.nextInt();
                producto.setCantidad(cantidadInventario);

                System.out.println("Artículo modificado exitosamente.");
            } else {
                System.out.println("El artículo no se encontraba en el inventario.");
            }
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Asegúrese de ingresar los valores correctos.");
        }
    }

    /*
    Método que permite modificar los detalles de un cliente en el catálogo. 
    Solicita al usuario ingresar el número de cliente a modificar y luego utiliza el método 
    getClienteByNumero(numeroCliente) de la lista catalogoClientes para obtener 
    el cliente correspondiente. A continuación, solicita al usuario ingresar los 
    nuevos detalles del cliente y los actualiza en el objeto Cliente. Si el cliente 
    no se encuentra en el catálogo, muestra un mensaje indicando que no se encontraba 
    en el catálogo.
     */
    private void modificarCliente() {
        // Manejo de excepciones en caso de errores
        try {
            System.out.println("----- Modificar Cliente -----");
            System.out.println("\nLista de Cliente");
            for (Cliente cliente : catalogoClientes) {
                System.out.println(cliente.toString());
            }

            System.out.print("\nIngrese el número de cliente a modificar: ");
            int numeroCliente = scanner.nextInt();

            Cliente cliente = catalogoClientes.getClienteByNumero(numeroCliente);
            if (cliente != null) {
                System.out.println("Datos actuales del cliente:");
                System.out.println(cliente.toString());

                System.out.print("Ingrese la nueva razón social: ");
                String razonSocial = scanner.next();
                cliente.setRazonSocial(razonSocial);

                System.out.print("Ingrese el nuevo RFC: ");
                String rfc = scanner.next();
                cliente.setRfc(rfc);

                System.out.print("Ingrese el nuevo teléfono: ");
                String telefono = scanner.next();
                cliente.setTelefono(telefono);

                System.out.print("Ingrese el nuevo nombre de contacto: ");
                String nombreContacto = scanner.next();
                cliente.setNombreContacto(nombreContacto);

                System.out.print("Ingrese la nueva dirección fiscal: ");
                String direccionFiscal = scanner.next();
                cliente.setDireccionFiscal(direccionFiscal);

                System.out.println("Cliente modificado exitosamente.");
            } else {
                System.out.println("El cliente no se encontraba en el catálogo.");
            }
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Asegúrese de ingresar los valores correctos.");
        }
    }

    /*
    Método que olicita al usuario ingresar el RFC del proveedor a modificar y luego 
    utiliza el método getProveedorByRFC(rfc) de la lista catalogoProveedores para 
    obtener el proveedor correspondiente. A continuación, solicita al usuario ingresar 
    los nuevos detalles del proveedor y los actualiza en el objeto Proveedor. 
    Si el proveedor no se encuentra en el catálogo, muestra un mensaje indicando 
    que no se encontraba en el catálogo.
     */
    private void modificarProveedor() {
        // Manejo de excepciones en caso de errores
        try {
            System.out.println("----- Modificar Proveedor -----");
            System.out.println("\nLista de Proveedores");
            for (Proveedor proveedor : catalogoProveedores) {
                System.out.println(proveedor.toString());
            }

            System.out.print("\nIngrese el RFC del proveedor a modificar: ");
            String rfc = scanner.next();

            Proveedor proveedor = catalogoProveedores.getProveedorByRFC(rfc);
            if (proveedor != null) {
                System.out.println("Datos actuales del proveedor:");
                System.out.println(proveedor.toString());

                System.out.print("Ingrese la nueva razón social: ");
                String razonSocial = scanner.next();
                proveedor.setRazonSocial(razonSocial);

                System.out.print("Ingrese el nuevo teléfono: ");
                String telefono = scanner.next();
                proveedor.setTelefono(telefono);

                System.out.print("Ingrese el nuevo nombre de contacto: ");
                String nombreContacto = scanner.next();
                proveedor.setNombreContacto(nombreContacto);

                System.out.print("Ingrese el nuevo fax: ");
                String fax = scanner.next();
                proveedor.setFax(fax);

                System.out.print("Ingrese la nueva dirección: ");
                String direccion = scanner.next();
                proveedor.setDireccion(direccion);

                System.out.print("Ingrese el nuevo email de contacto: ");
                String emailContacto = scanner.next();
                proveedor.setEmailContac(emailContacto);

                System.out.print("Ingrese el nuevo teléfono de contacto: ");
                String telefonoContacto = scanner.next();
                proveedor.setTelefonoContac(telefonoContacto);

                System.out.println("Proveedor modificado exitosamente.");
            } else {
                System.out.println("El proveedor no se encontraba en el catálogo.");
            }
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Asegúrese de ingresar los valores correctos.");
        }
    }

    /*
    Método que muestra un menú con varias opciones y solicita al usuario ingresar 
    una opción. Dependiendo de la opción seleccionada, invoca los métodos correspondientes
     */
    public void mostrarMenu() {
        // Manejo de excepciones en caso de errores
        try {
            String opcion;

            do {
                System.out.println("===== ABARROTES PIRATA =====");
                System.out.println("----- MENÚ -----");
                System.out.println("1. Agregar Cliente");
                System.out.println("2. Agregar Proveedor");
                System.out.println("3. Agregar Producto al Inventario");
                System.out.println("4. Realizar Pedido");
                System.out.println("5. Ver Catálogo de Clientes");
                System.out.println("6. Ver Catálogo de Proveedores");
                System.out.println("7. Ver Inventario de Productos");
                System.out.println("8. Borrar Producto");
                System.out.println("9. Borrar Cliente");
                System.out.println("10. Borrar Proveedor");
                System.out.println("11. Modificar Cliente");
                System.out.println("12. Modificar Proveedor");
                System.out.println("13. Modificar Producto");
                System.out.println("14. Ver Ventas");
                System.out.println("15. Borrar Venta");
                System.out.println("0. Salir");
                System.out.print("Ingrese una opción: ");
                opcion = scanner.next();

                switch (opcion) {
                    case "1":
                        agregarCliente();
                        break;
                    case "2":
                        agregarProveedor();
                        break;
                    case "3":
                        agregarProductoInventario();
                        break;
                    case "4":
                        realizarPedido();
                        break;
                    case "5":
                        verCatalogoClientes();
                        break;
                    case "6":
                        verCatalogoProveedores();
                        break;
                    case "7":
                        verInventarioProductos();
                        break;
                    case "8":
                        borrarProducto();
                        break;
                    case "9":
                        borrarCliente();
                        break;
                    case "10":
                        borrarProveedor();
                        break;
                    case "11":
                        modificarCliente();
                        break;
                    case "12":
                        modificarProveedor();
                        break;
                    case "13":
                        modificarProducto();
                        break;
                    case "14":
                        verVentas();
                        break;
                    case "15":
                        borrarVenta();
                        break;
                    case "0":
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }

                System.out.println();

            } while (!"0".equals(opcion));
        } catch (Exception e) {
            System.out.println("Error: Entrada inválida. Asegúrese de ingresar los valores correctos.");
        }
    }

    public static void main(String[] args) {
        AbarrotesPirata menu = new AbarrotesPirata();//instanciar
        menu.mostrarMenu();
    }
    
}
