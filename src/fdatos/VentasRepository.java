package fdatos;

import dominio.Venta;
import javax.persistence.EntityManager;

/**
 *
 * @author Alfonso Felix
 */
public class VentasRepository extends RepositoryBase<Venta>{
    
    public VentasRepository(EntityManager entityManager, Class<Venta> cls) {
        super(entityManager, cls);
    }
    
}
