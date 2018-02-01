
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.TbProfessores;
import model.TbUsersystem;
/**
 *
 * @author suporte
 */
public class TbProfessoresDAO extends GenericDAO<TbProfessores> {

    public TbProfessoresDAO() {
        super(TbProfessores.class);
    }
    
    public TbProfessores buscaProf(TbUsersystem prof) {
        TbProfessores result = new TbProfessores();
       // System.out.println("Email: "+prof.getEmail());
        
        try {
            EntityManager em1 = getEM();
            em1.getTransaction().begin();
            CriteriaBuilder builder = em1.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery(TbProfessores.class);
            EntityType type = em1.getMetamodel().entity(TbProfessores.class);
            Root root = query.from(TbProfessores.class);
            query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("email", String.class)), prof.getEmail()));
            result = (TbProfessores) em1.createQuery(query).getSingleResult();
           // System.out.println("Result 2: "+result.getNome());
            em1.close();
            return result;
        } catch (Exception e) {
            System.out.println("Erro no busca prof: "+e);
            return null;
        }

    }
    
      public List<TbProfessores> listarProfessores() {
        //System.out.println("Id do professor: " + id);
        List<TbProfessores> result = new ArrayList<TbProfessores>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(TbProfessores.class);
        EntityType type = em1.getMetamodel().entity(TbProfessores.class);
        Root root = query.from(TbProfessores.class);
        query.orderBy(builder.asc(root.get("nome")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    
}
