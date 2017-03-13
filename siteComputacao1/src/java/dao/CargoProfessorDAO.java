package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteCargoProfessor;
import model.TbProfessores;

/**
 *
 * @author UFT
 */
public class CargoProfessorDAO extends GenericDAO<SiteCargoProfessor>{
    
    public CargoProfessorDAO() {
        super(SiteCargoProfessor.class);
    }
    
    public List<SiteCargoProfessor> listarCargoPorProfessor(TbProfessores id) {

        System.out.println("Id do professor: "+id);
        List<SiteCargoProfessor> result = new ArrayList<SiteCargoProfessor>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteCargoProfessor.class);
        EntityType type = em1.getMetamodel().entity(SiteCargoProfessor.class);
        Root root = query.from(SiteCargoProfessor.class);
        query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("professorId", TbProfessores.class)), id));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
}
