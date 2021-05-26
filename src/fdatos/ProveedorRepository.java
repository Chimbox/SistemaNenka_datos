/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdatos;

import dominio.Cliente;
import dominio.Proveedor;
import javax.persistence.EntityManager;

/**
 *
 * @author laura
 */
public class ProveedorRepository extends RepositoryBase<Proveedor>{
    
    public ProveedorRepository(EntityManager entityManager, Class<Proveedor> cls) {
        super(entityManager, cls);
    }
}
