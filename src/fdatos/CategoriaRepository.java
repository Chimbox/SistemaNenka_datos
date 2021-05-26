/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdatos;

import dominio.Categoria;
import dominio.Cliente;
import javax.persistence.EntityManager;

/**
 *
 * @author laura
 */
public class CategoriaRepository extends RepositoryBase<Categoria>{
    
    public CategoriaRepository(EntityManager entityManager, Class<Categoria> cls) {
        super(entityManager, cls);
    }
}
