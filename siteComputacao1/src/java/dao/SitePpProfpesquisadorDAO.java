
package dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SitePpProfpesquisador;
import model.SiteProjPesquisa;
import model.TbProfessores;

/**
 *
 * @author UFT
 */
public class SitePpProfpesquisadorDAO extends GenericDAO<SitePpProfpesquisador>{
    
    public SitePpProfpesquisadorDAO() {
        super(SitePpProfpesquisador.class);
    }
    
    public SitePpProfpesquisador pppesquisador(SiteProjPesquisa pp, TbProfessores c) {
        SitePpProfpesquisador result = new SitePpProfpesquisador();
        try {
            EntityManager em1 = getEM();
            em1.getTransaction().begin();
            CriteriaBuilder builder = em1.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery(SitePpProfpesquisador.class);
            EntityType type = em1.getMetamodel().entity(SitePpProfpesquisador.class);
            Root root = query.from(SitePpProfpesquisador.class);
            query.where(builder.and(builder.equal(root.get(type.getDeclaredSingularAttribute("pp", SiteProjPesquisa.class)), pp),
                    builder.equal(root.get(type.getDeclaredSingularAttribute("prof_pesquisador", TbProfessores.class)), c)));
            result = (SitePpProfpesquisador) em1.createQuery(query).getSingleResult();
            em1.close();
            return result;
        } catch (Exception e) {
            return null;
        }

    }
}
