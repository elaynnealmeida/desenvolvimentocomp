package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author UFT
 */
public class GenericDAO<T> implements Serializable {

    //  Session session;
    // Transaction transaction;
    private EntityManager em;
    private Class<T> entityClass;

    public GenericDAO(Class<T> entity) {
        this.entityClass = entity;

    }

    public EntityManager getEM() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("siteComputacao1PU");

        return factory.createEntityManager();
    }

    public void beginTransaction() {
        em = getEM();
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }

    public void rollback() {
        em.getTransaction().rollback();
    }

    public void closeTransaction() {
        em.close();
    }

    public void commitAndCloseTransaction() {
        commit();
        closeTransaction();
    }

    public void flush() {
        em.flush();
    }

    public void joinTransaction() {
        em = getEM();
        em.joinTransaction();
    }

    public void salvar(T t) {
        EntityManager em1 = getEM();

        try {
            em1.getTransaction().begin();
            em1.persist(t);
            em1.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            em1.close();
        }
    }

    public T atualizar(T t) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            t = em.merge(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e);
            em.close();
        }
        return t;
    }

    public void deletar(T t) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(t));
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e);
            em.close();
        }
    }

    public List<T> listarTodos() {
        System.out.println("entrou no dao listar-----------");
        System.out.println("entidade:  " + entityClass.getName());
        List<T> result = new ArrayList<T>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        try {
            CriteriaQuery cq = em1.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            result = em1.createQuery(cq).getResultList();
            em1.close();
        } catch (Exception e) {
            System.out.println("Erro no listar Todos: " + e);
            em1.close();
        }
        return result;
    }

    public T buscaPorID(int entityID) {
        System.out.println("entrou no dao buscaPorID-----------");
        System.out.println("entidade:  " + entityClass.getName());
        EntityManager em1 = getEM();
        try {
            em1.getTransaction().begin();
            T result = em1.find(entityClass, entityID);
            em1.close();
            return result;
        } catch (Exception e) {
            System.out.println("Erro no listar Todos: " + e);
            em1.close();
        }
        return null;
    }

    public T buscaPorID2(long entityID) {
        System.out.println("entrou no dao buscaPorID-----------");
        System.out.println("entidade:  " + entityClass.getName());
        EntityManager em1 = getEM();
        try {
            em1.getTransaction().begin();
            T result = em1.find(entityClass, entityID);
            em1.close();
            return result;
        } catch (Exception e) {
            System.out.println("Erro no listar Todos: " + e);
            em1.close();
        }
        return null;
    }

}
