
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteProfessorFormacao;
import model.TbProfessores;

/**
 *
 * @author UFT
 */
public class ProfessorFormacaoDAO extends GenericDAO<SiteProfessorFormacao>{
    
    public ProfessorFormacaoDAO(){
        super(SiteProfessorFormacao.class);
    }
    
     public List<SiteProfessorFormacao> listarFormacaoPorProfessor(TbProfessores id) {

        System.out.println("Id do professor: "+id);
        List<SiteProfessorFormacao> result = new ArrayList<SiteProfessorFormacao>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteProfessorFormacao.class);
        EntityType type = em1.getMetamodel().entity(SiteProfessorFormacao.class);
        Root root = query.from(SiteProfessorFormacao.class);
        query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("professorId", TbProfessores.class)), id));
        query.orderBy(builder.desc(root.get("dtFim2")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
}
