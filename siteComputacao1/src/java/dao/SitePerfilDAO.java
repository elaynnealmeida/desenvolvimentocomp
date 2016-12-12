package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.SitePerfil;

/**
 *
 * @author UFT
 */
public class SitePerfilDAO extends GenericDAO<SitePerfil> {

    public SitePerfilDAO() {
        super(SitePerfil.class);
    }

    public List<SitePerfil> listarTodosAtivos() {

        System.out.println("entrou no dao listar-----------");
        EntityManager em1 = getEM();
        try {
            List<SitePerfil> result = new ArrayList<SitePerfil>();
            em1.getTransaction().begin();
            Query query = em1.createQuery("SELECT s FROM SitePerfil s WHERE s.ativo = :ativo");
            query.setParameter("ativo", true);
            result = query.getResultList();
            em1.close();
            return result;
        } catch (Exception e) {
            System.out.println("Erro no listar Perfis Ativos: " + e);
            em1.close();
            return null;
        }
    }

}
