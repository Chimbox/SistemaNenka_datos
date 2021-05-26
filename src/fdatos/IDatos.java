package fdatos;

import dominio.Categoria;
import dominio.Cliente;
import dominio.Empleado;
import dominio.Producto;
import dominio.Proveedor;
import dominio.Venta;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Alfonso Felix
 */
public interface IDatos {
    
    public Producto guardarProducto(Producto producto);
    public Venta guardarVenta(Venta venta);
    public List<Producto> buscarProductos(String parametro);
    public List<Producto> buscarProductoCategoria(String categoria);
    public List<Producto> obtenerProductos();
    public List<Cliente> obtenerClientes();
    public List<Categoria> obtenerCategorias();
    public List<Proveedor> obtenerProveedores();
    public List<Empleado> obtenerEmpleados();
    public Producto buscarProducto(int id);
    public Empleado buscarEmpleado(String usuario, String contrasena);
    public Connection getConnnection();
    
}
