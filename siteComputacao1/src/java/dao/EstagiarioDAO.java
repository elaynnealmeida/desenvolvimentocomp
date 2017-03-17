
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteEstagiarios;

/**
 *
 * @author UFT
 */
public class EstagiarioDAO extends GenericDAO<SiteEstagiarios>{
    
    public EstagiarioDAO() {
        super(SiteEstagiarios.class);
    }
    
     public List<SiteEstagiarios> listarTodosAtivos() {

        System.out.println("entrou no dao listar estagiarios ativos-----------");
        List<SiteEstagiarios> result = new ArrayList<SiteEstagiarios>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteEstagiarios.class);
        EntityType type = em1.getMetamodel().entity(SiteEstagiarios.class);
        Root root = query.from(SiteEstagiarios.class);
        query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("ativo", Boolean.class)), "true"));
        query.orderBy(builder.asc(root.get("id")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
     public List<SiteEstagiarios> listarHorarioAtual() {
        
        List<SiteEstagiarios> result = new ArrayList<SiteEstagiarios>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteEstagiarios.class);
        EntityType type = em1.getMetamodel().entity(SiteEstagiarios.class);
        Root root = query.from(SiteEstagiarios.class);
        query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("ativo", Boolean.class)), "true"));
        query.orderBy(builder.asc(root.get("id")));
        result = em1.createQuery(query).getResultList();
        HorarioDAO dao = new HorarioDAO();
        for(int i=0; i<result.size(); i++){
            result.get(i).setSiteHorarioList(dao.listarHorarioAtual(result.get(i)));
        }
        em1.close();
        return result;
    }
     

    
}
