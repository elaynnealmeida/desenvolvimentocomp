package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SitePerfilUsuario;
import model.TbUsersystem;

/**
 *
 * @author UFT
 */
public class SitePerfilUsuarioDAO extends GenericDAO<SitePerfilUsuario> {

    public SitePerfilUsuarioDAO() {
        super(SitePerfilUsuario.class);
    }

    public List<SitePerfilUsuario> listarTodosAtivos() {
        System.out.println("entrou no dao listar-----------");
        List<SitePerfilUsuario> result = new ArrayList<SitePerfilUsuario>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        boolean ativo = true;
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SitePerfilUsuario.class);
        EntityType type = em1.getMetamodel().entity(SitePerfilUsuario.class);
        Root root = query.from(SitePerfilUsuario.class);
        query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("ativo", Boolean.class)), ativo));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }

}
