package fdatos;

import dominio.Cliente;
import javax.persistence.EntityManager;

/**
 *
 * @author Alfonso Felix
 */
class ClientesRepository extends RepositoryBase<Cliente>{
    
    public ClientesRepository(EntityManager entityManager, Class<Cliente> cls) {
        super(entityManager, cls);
    }
    
}
