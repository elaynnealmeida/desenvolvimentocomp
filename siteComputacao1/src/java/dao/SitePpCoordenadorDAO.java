
package dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SitePpCoordenador;
import model.SiteProjPesquisa;
import model.TbProfessores;

/**
 *
 * @author UFT
 */
public class SitePpCoordenadorDAO extends GenericDAO<SitePpCoordenador>{
    
    public SitePpCoordenadorDAO() {
        super(SitePpCoordenador.class);
    }
    
    public SitePpCoordenador ppcoordenador(SiteProjPesquisa pp, TbProfessores c) {
        SitePpCoordenador result = new SitePpCoordenador();
        try {
            EntityManager em1 = getEM();
            em1.getTransaction().begin();
            CriteriaBuilder builder = em1.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery(SitePpCoordenador.class);
            EntityType type = em1.getMetamodel().entity(SitePpCoordenador.class);
            Root root = query.from(SitePpCoordenador.class);
            query.where(builder.and(builder.equal(root.get(type.getDeclaredSingularAttribute("pp", SiteProjPesquisa.class)), pp),
                    builder.equal(root.get(type.getDeclaredSingularAttribute("coordenador", TbProfessores.class)), c)));
            result = (SitePpCoordenador) em1.createQuery(query).getSingleResult();
            em1.close();
            return result;
        } catch (Exception e) {
            return null;
        }

    }
    
}
