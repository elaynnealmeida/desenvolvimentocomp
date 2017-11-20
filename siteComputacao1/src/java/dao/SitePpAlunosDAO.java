
package dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteAluno;
import model.SitePpAlunos;
import model.SiteProjPesquisa;

/**
 *
 * @author UFT
 */
public class SitePpAlunosDAO extends GenericDAO<SitePpAlunos>{
    
    public SitePpAlunosDAO() {
        super(SitePpAlunos.class);
    }
    
    public SitePpAlunos ppaluno(SiteProjPesquisa pp, SiteAluno c) {
        SitePpAlunos result = new SitePpAlunos();
        try {
            EntityManager em1 = getEM();
            em1.getTransaction().begin();
            CriteriaBuilder builder = em1.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery(SitePpAlunos.class);
            EntityType type = em1.getMetamodel().entity(SitePpAlunos.class);
            Root root = query.from(SitePpAlunos.class);
            query.where(builder.and(builder.equal(root.get(type.getDeclaredSingularAttribute("pp", SiteProjPesquisa.class)), pp),
                    builder.equal(root.get(type.getDeclaredSingularAttribute("aluno", SiteAluno.class)), c)));
            result = (SitePpAlunos) em1.createQuery(query).getSingleResult();
            em1.close();
            return result;
        } catch (Exception e) {
            return null;
        }

    }
}
