package fdatos;

import dominio.Empleado;
import javax.persistence.EntityManager;

/**
 *
 * @author Alfonso Felix
 */
class EmpleadosRepository extends RepositoryBase<Empleado>{
    
    public EmpleadosRepository(EntityManager entityManager, Class<Empleado> cls) {
        super(entityManager, cls);
    }
    
}
