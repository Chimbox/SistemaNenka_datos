package fdatos;

import dominio.Producto;
import dominio.Venta;
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

    public FDatos(EntityManager em) {
        FDatos.em = em;
    }

    public static ProductosRepository getProductosRep() {
        if(productosRep==null){
            productosRep=new ProductosRepository(em, Producto.class);
        }
        return productosRep;
    }

    public static VentasRepository getVentasRep() {
        if(ventasRep==null){
            ventasRep=new VentasRepository(em, Venta.class);
        }
        return ventasRep;
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
}
