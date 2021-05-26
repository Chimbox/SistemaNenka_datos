package fdatos;

import dominio.Categoria;
import dominio.Cliente;
import dominio.Empleado;
import dominio.Producto;
import dominio.Proveedor;
import dominio.Venta;
import java.sql.Connection;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Alfonso Felix
 */
class FDatos implements IDatos{

    private static EntityManager em;
    private static ProductosRepository productosRep;
    private static VentasRepository ventasRep;
    private static ClientesRepository clientesRep;
    private static ProveedorRepository proveedorRep;
    private static CategoriaRepository categRep;
    private static EmpleadosRepository empleadosRep;
    private static ConnectionRepository connectionRep;
    

    public FDatos(EntityManager em) {
        FDatos.em = em;
    }

    public static ProductosRepository getProductosRep() {
        if(productosRep==null){
            productosRep=new ProductosRepository(em, Producto.class);
        }
        return productosRep;
    }
    
    public static CategoriaRepository getCategoriaRep() {
        if(categRep==null){
            categRep=new CategoriaRepository(em, Categoria.class);
        }
        return categRep;
    }
    
    public static ProveedorRepository getProveedorRep() {
        if(proveedorRep==null){
            proveedorRep = new ProveedorRepository(em, Proveedor.class);
        }
        return proveedorRep;
    }

    public static VentasRepository getVentasRep() {
        if(ventasRep==null){
            ventasRep=new VentasRepository(em, Venta.class);
        }
        return ventasRep;
    }

    public static ClientesRepository getClientesRep() {
        if(clientesRep==null){
            clientesRep=new ClientesRepository(em, Cliente.class);
        }
        return clientesRep;
    }

    public static EmpleadosRepository getEmpleadosRep() {
        if(empleadosRep==null){
            empleadosRep=new EmpleadosRepository(em, Empleado.class);
        }
        return empleadosRep;
    }
    
    public static ConnectionRepository getConnectionRep() {
        if(connectionRep==null){
            connectionRep=new ConnectionRepository(em);
        }
        return connectionRep;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return getProductosRep().save(producto);
    }

    @Override
    public Venta guardarVenta(Venta venta) {
        return getVentasRep().save(venta);
    }

    @Override
    public List<Producto> obtenerProductos() {
        return getProductosRep().findAll();
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return getClientesRep().findAll();
    }
    
    @Override
    public List<Categoria> obtenerCategorias(){
        return getCategoriaRep().findAll();
    }
    
    @Override
    public List<Proveedor> obtenerProveedores(){
        return getProveedorRep().findAll();
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        return getEmpleadosRep().findAll();
    }

    @Override
    public Producto buscarProducto(int id) {
        return getProductosRep().find(id);
    }

    @Override
    public List<Producto> buscarProductos(String parametro) {
        return getProductosRep().buscarProducto(parametro);
    }

    @Override
    public Empleado buscarEmpleado(String usuario, String contrasena) {
        return getEmpleadosRep().buscarEmpleado(usuario, contrasena);
    }

    @Override
    public List<Producto> buscarProductoCategoria(String categoria) {
        return getProductosRep().buscarProductoCategoria(categoria);
    }

    @Override
    public Connection getConnnection(){
        return getConnectionRep().getConnection();
    }   
}
