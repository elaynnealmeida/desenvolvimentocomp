package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteMatriz;

/**
 *
 * @author UFT
 */
public class SiteMatrizDAO extends GenericDAO<SiteMatriz> {

    public SiteMatrizDAO() {
        super(SiteMatriz.class);
    }

    public List<SiteMatriz> listarMatriz() {
        List<SiteMatriz> result = new ArrayList<SiteMatriz>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        try {
            //CriteriaQuery cq = em1.getCriteriaBuilder().createQuery();
           // cq.select(cq.from(SiteMatriz.class));
           // result = em1.createQuery(cq).getResultList();
            CriteriaBuilder builder = em1.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery(SiteMatriz.class);
            //EntityType type = em1.getMetamodel().entity(SiteNoticia.class);
            Root root = query.from(SiteMatriz.class);
            query.orderBy(builder.asc(root.get("posicao")));
            result = em1.createQuery(query).getResultList();
            em1.close();
           
        } catch (Exception e) {
            System.out.println("Erro no listar Todos: " + e);
            em1.close();
        }
        return result;
    }
    
    public SiteMatriz buscaPorApelido(String apelido) {
        System.out.println("entrou no dao buscaPorApelido-----------");
        System.out.println("entidade:  " + SiteMatriz.class.getName());
        EntityManager em1 = getEM();
        try {
            em1.getTransaction().begin();
           
            CriteriaBuilder builder = em1.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery(SiteMatriz.class);
            EntityType type = em1.getMetamodel().entity(SiteMatriz.class);
            Root root = query.from(SiteMatriz.class);
            query.where(builder.equal(root.get("apelido"), apelido));
            //query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("apelido", TbProfessores.class)), apelido));
            SiteMatriz result = (SiteMatriz) em1.createQuery(query).getSingleResult();
            
            em1.close();
            return result;
        } catch (Exception e) {
            System.out.println("Erro no buscar por apelido: " + e);
            em1.close();
        }
        return null;
    }
}
