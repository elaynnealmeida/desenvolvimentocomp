package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.TbUsersystem;

/**
 *
 * @author UFT
 */
public class UsuarioDAO extends GenericDAO<TbUsersystem> {

    public UsuarioDAO() {
        super(TbUsersystem.class);
    }

    public List<TbUsersystem> listarTodosAtivos(String nome) {

        System.out.println("entrou no dao listar-----------");
        List<TbUsersystem> result = new ArrayList<TbUsersystem>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(TbUsersystem.class);
        EntityType type = em1.getMetamodel().entity(TbUsersystem.class);
        Root root = query.from(TbUsersystem.class);
        query.where(builder.and(builder.equal(root.get(type.getDeclaredSingularAttribute("status", String.class)), "ATIVO"),
                builder.like(builder.lower(root.get(type.getDeclaredSingularAttribute("nomecompleto", String.class))), "%" + nome.toLowerCase() + "%")));
        query.orderBy(builder.asc(root.get("nomecompleto")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }

    public TbUsersystem login(TbUsersystem login) {
        TbUsersystem result = new TbUsersystem();
        System.out.println("Login: "+login.getRoles());
        System.out.println("senha: "+login.getPassword());
        try {
            EntityManager em1 = getEM();
            em1.getTransaction().begin();
            CriteriaBuilder builder = em1.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery(TbUsersystem.class);
            EntityType type = em1.getMetamodel().entity(TbUsersystem.class);
            Root root = query.from(TbUsersystem.class);
            query.where(builder.and(builder.equal(root.get(type.getDeclaredSingularAttribute("roles", String.class)), login.getRoles()),
                    builder.equal(root.get(type.getDeclaredSingularAttribute("password", String.class)), login.getPassword())));
            result = (TbUsersystem) em1.createQuery(query).getSingleResult();
            em1.close();
            return result;
        } catch (Exception e) {
            System.out.println("Erro no login: "+e);
            return null;
        }

    }
}
