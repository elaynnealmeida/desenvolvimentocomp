package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.SiteNoticia;
import model.TbUsersystem;

/**
 *
 * @author UFT
 */
public class SiteNoticiaDAO extends GenericDAO<SiteNoticia> {

    public SiteNoticiaDAO() {
        super(SiteNoticia.class);
    }

    public List<SiteNoticia> listarPorData() {
        System.out.println("entrou no dao listar noticias");
        List<SiteNoticia> result = new ArrayList<SiteNoticia>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteNoticia.class);
        //EntityType type = em1.getMetamodel().entity(SiteNoticia.class);
        Root root = query.from(SiteNoticia.class);
        query.orderBy(builder.desc(root.get("hora2")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    
    public List<SiteNoticia> listarPorUsuario(TbUsersystem id) {
        System.out.println("entrou no dao listar noticias");
        List<SiteNoticia> result = new ArrayList<SiteNoticia>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteNoticia.class);
        EntityType type = em1.getMetamodel().entity(SiteNoticia.class);
        Root root = query.from(SiteNoticia.class);
        query.where(builder.equal(root.get(type.getDeclaredSingularAttribute("usuarioId", TbUsersystem.class)), id));
        query.orderBy(builder.desc(root.get("hora2")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }

    /* @Override
    public List<SiteNoticia> listarTodos() {
        System.out.println("entrou no dao listar noticias");
        List<SiteNoticia> result = new ArrayList<SiteNoticia>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaQuery cq = em1.getCriteriaBuilder().createQuery();
        cq.select(cq.from(SiteNoticia.class));
        result = em1.createQuery(cq).getResultList();
        
        result = recuperaImagem(result);
        em1.close();
        return result;
    }
    
    private List<SiteNoticia> recuperaImagem(List<SiteNoticia> noticia) {
        for (int i = 0; i < noticia.size(); i++) {
            if (noticia.get(i).getImgCapa() != null) {
                byte[] image = noticia.get(i).getImgCapa();
               noticia.get(i).setImgCapa(image);
            } 
        }
        return noticia;
    }*/
}
