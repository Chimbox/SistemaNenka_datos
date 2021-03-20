package fdatos;

import dominio.EntityBase;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

abstract class RepositoryBase<T extends EntityBase> implements Repository<T> {

    protected final EntityManager entityManager;
    protected final Class<T> cls;

    protected RepositoryBase(EntityManager entityManager, Class<T> cls) {
        this.entityManager = entityManager;
        this.cls = cls;
    }

    @Override
    public T find(int id) {
        T entity = this.entityManager.find(cls, id);
        return entity;
    }

    @Override
    public List<T> findAll() {
      //  List lst = this.entityManager.createQuery("SELECT p FROM " + cls.getName() + " p").getResultList();
        CriteriaQuery<T> cq=this.entityManager.getCriteriaBuilder().createQuery(cls);
        Root<T> rootEntry=cq.from(cls);
        CriteriaQuery<T> all=cq.select(rootEntry);
        TypedQuery<T> allQuery=this.entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public T save(T entity) {
        this.ensureTransaction();
        if (entity.getId() == null) {
            this.entityManager.persist(entity);
            commit();
            return entity;
        } else {
            T obj = this.entityManager.merge(entity);
            commit();
            return obj;
        }

    }

    @Override
    public void delete(T entity) {
        this.ensureTransaction();
        this.entityManager.remove(entity);
        commit();
    }

    @Override
    public void commit() {
        EntityTransaction transaction = this.entityManager.getTransaction();
        if (transaction.isActive()) {
            transaction.commit();
        }
    }

    protected void ensureTransaction() {
        EntityTransaction transaction = this.entityManager.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
    }
}
