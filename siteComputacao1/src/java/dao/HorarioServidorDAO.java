
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteHorarioServidor;
import model.TbProfessores;

/**
 *
 * @author UFT
 */
public class HorarioServidorDAO extends GenericDAO<SiteHorarioServidor>{
    
    public HorarioServidorDAO() {
        super(SiteHorarioServidor.class);
    }
    
     public List<SiteHorarioServidor> listarHorarioPorProfessor(TbProfessores id) {

        List<SiteHorarioServidor> result = new ArrayList<SiteHorarioServidor>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteHorarioServidor.class);
        EntityType type = em1.getMetamodel().entity(SiteHorarioServidor.class);
        Root root = query.from(SiteHorarioServidor.class);
        query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("servidorId", TbProfessores.class)), id));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    
      public List<SiteHorarioServidor> listarTodosAtivos() {

        System.out.println("entrou no dao listar estagiarios ativos-----------");
        List<SiteHorarioServidor> result = new ArrayList<SiteHorarioServidor>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteHorarioServidor.class);
        EntityType type = em1.getMetamodel().entity(SiteHorarioServidor.class);
        Root root = query.from(SiteHorarioServidor.class);
        query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("ativo", Boolean.class)), "true"));
        query.orderBy(builder.asc(root.get("id")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
}
