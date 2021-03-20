package fdatos;

import dominio.Producto;
import dominio.Venta;
import java.util.List;

/**
 *
 * @author Alfonso Felix
 */
public interface IDatos {
    
    public Producto guardarProducto(Producto producto);
    public Venta guardarVenta(Venta venta);
    public List<Producto> obtenerProductos();
    
}
