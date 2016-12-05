package dao;

import model.SiteNoticia;

/**
 *
 * @author UFT
 */
public class SiteNoticiaDAO extends GenericDAO<SiteNoticia> {

    public SiteNoticiaDAO() {
        super(SiteNoticia.class);
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
