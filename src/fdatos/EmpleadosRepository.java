package fdatos;

import dominio.Empleado;
import javax.persistence.EntityManager;

/**
 *
 * @author Alfonso Felix
 */
class EmpleadosRepository extends RepositoryBase<Empleado> {

    public EmpleadosRepository(EntityManager entityManager, Class<Empleado> cls) {
        super(entityManager, cls);
    }

    public Empleado buscarEmpleado(String usuario, String contrasena) {
        try {
            return (Empleado) this.entityManager.createNativeQuery(String.format("SELECT * FROM empleados e WHERE e.username == '%s' AND e.contrasena == '%s'", usuario, contrasena), Empleado.class).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
