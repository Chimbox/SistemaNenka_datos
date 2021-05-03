package fdatos;

import dominio.Producto;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Alfonso Felix
 */
public class ProductosRepository extends RepositoryBase<Producto> {

    public ProductosRepository(EntityManager entityManager, Class<Producto> cls) {
        super(entityManager, cls);
    }

    public List<Producto> buscarProducto(String parametro) {
        return this.entityManager.createNativeQuery(String.format("SELECT * FROM productos p WHERE p.nombre LIKE '%%%s%%' OR p.codigo LIKE '%%%s%%'", parametro, parametro, parametro, parametro), Producto.class).getResultList();
// return this.entityManager.createQuery("SELECT p FROM " + cls + " p WHERE p.nombre LIKE ").setParameter("restaurant", restaurante).getResultList();
    }
    
    public List<Producto> buscarProductoCategoria(String categoria){
        return this.entityManager.createNativeQuery(String.format("SELECT * FROM productos p INNER JOIN (categorias c) ON (p.id_categoria = c.id) WHERE c.nombre LIKE '%%%s%%'", categoria), Producto.class).getResultList();
    }
}
