package fdatos;

import dominio.Producto;
import javax.persistence.EntityManager;

/**
 *
 * @author Alfonso Felix
 */
public class ProductosRepository extends RepositoryBase<Producto>{
    
    public ProductosRepository(EntityManager entityManager, Class<Producto> cls) {
        super(entityManager, cls);
    }
    
}
