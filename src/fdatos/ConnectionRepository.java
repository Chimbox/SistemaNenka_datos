package fdatos;

import java.sql.Connection;
import javax.persistence.EntityManager;

public class ConnectionRepository {
    
    private EntityManager entitityManager;

    public ConnectionRepository(EntityManager entitityManager) {
        this.entitityManager = entitityManager;
    }
    
   
    public Connection getConnection() {
        this.entitityManager.getTransaction().begin();
        java.sql.Connection connection = this.entitityManager.unwrap(java.sql.Connection.class);
        this.entitityManager.getTransaction().commit();
         
        return connection;
    }

}
