
package dao;

import static antlr.build.ANTLR.root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import model.SiteConselho;
import model.SiteDocumento;
import model.SitePublicacao;
import model.SiteTipoArquivo;

/**
 *
 * @author UFT
 */
public class SiteDocumentoDAO extends GenericDAO<SiteDocumento>{
    
    public SiteDocumentoDAO(){
        super(SiteDocumento.class);
    }
    
    public List<SiteDocumento> listarPorData() {
        System.out.println("entrou no dao listar documentos");
        List<SiteDocumento> result = new ArrayList<SiteDocumento>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteDocumento.class);
        Root root = query.from(SiteDocumento.class);       
        query.orderBy(builder.desc(root.get("hora")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    
    public List<SiteDocumento> listarConsuni() {
        System.out.println("entrou no dao listar listarConsuni");
        List<SiteDocumento> result = new ArrayList<SiteDocumento>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteDocumento.class);
        Root root = query.from(SiteDocumento.class);
        Join<SiteDocumento, SitePublicacao> join =  root.join("publicacaoId", JoinType.INNER);
        Join<SitePublicacao, SiteConselho> join2 = join.join("conselhoId", JoinType.INNER);
        query.equals(join2.get("id"));
        query.where(builder.equal(join2.get("id"),"1"));   //Consuni
        query.orderBy(builder.desc(root.get("hora")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    
    public List<SiteDocumento> listarEnade() {
        System.out.println("entrou no dao listar Enade");
        List<SiteDocumento> result = new ArrayList<SiteDocumento>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteDocumento.class);
        Root root = query.from(SiteDocumento.class);
        Join<SiteDocumento, SiteTipoArquivo> join =  root.join("tipoDocumento", JoinType.INNER);
       // Join<SitePublicacao, SiteConselho> join2 = join.join("conselhoId", JoinType.INNER);
        query.equals(join.get("id"));
        query.where(builder.equal(join.get("id"),"8"));   //Enade
        query.orderBy(builder.desc(root.get("hora")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    
    public List<SiteDocumento> listarConsepe() {
        System.out.println("entrou no dao listar listarConsepe");
        List<SiteDocumento> result = new ArrayList<SiteDocumento>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteDocumento.class);
        Root root = query.from(SiteDocumento.class);
        Join<SiteDocumento, SitePublicacao> join =  root.join("publicacaoId", JoinType.INNER);
        Join<SitePublicacao, SiteConselho> join2 = join.join("conselhoId", JoinType.INNER);
        query.equals(join2.get("id"));
        query.where(builder.equal(join2.get("id"),"2"));   //Consepe
        query.orderBy(builder.desc(root.get("hora")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    public List<SiteDocumento> listarDocentes() {
        System.out.println("entrou no dao listar listarDocentes");
        List<SiteDocumento> result = new ArrayList<SiteDocumento>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteDocumento.class);
        Root root = query.from(SiteDocumento.class);
        Join<SiteDocumento, SitePublicacao> join =  root.join("publicacaoId", JoinType.INNER);
       Join<SitePublicacao, SiteConselho> join2 = join.join("conselhoId", JoinType.INNER);
        query.equals(join2.get("id"));
        query.where(builder.equal(join2.get("id"),"4"));   //Docentes
        query.orderBy(builder.desc(root.get("hora")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    public List<SiteDocumento> listarCondir() {
        System.out.println("entrou no dao listar listarCondir");
        List<SiteDocumento> result = new ArrayList<SiteDocumento>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteDocumento.class);
        Root root = query.from(SiteDocumento.class);
        Join<SiteDocumento, SitePublicacao> join =  root.join("publicacaoId", JoinType.INNER);
        Join<SitePublicacao, SiteConselho> join2 = join.join("conselhoId", JoinType.INNER);
        query.equals(join2.get("id"));
        query.where(builder.equal(join2.get("id"),"5"));   //Condir
        query.orderBy(builder.desc(root.get("hora")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    public List<SiteDocumento> listarCoordenacao() {
        System.out.println("entrou no dao listar listarCoordenacao");
        List<SiteDocumento> result = new ArrayList<SiteDocumento>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteDocumento.class);
        Root root = query.from(SiteDocumento.class);
        Join<SiteDocumento, SitePublicacao> join =  root.join("publicacaoId", JoinType.INNER);
        Join<SitePublicacao, SiteConselho> join2 = join.join("conselhoId", JoinType.INNER);
        query.equals(join2.get("id"));
        query.where(builder.equal(join2.get("id"),"6"));   //Coordenacao
        query.orderBy(builder.desc(root.get("hora")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    public List<SiteDocumento> listarNDE() {
        System.out.println("entrou no dao listar listarNDE");
        List<SiteDocumento> result = new ArrayList<SiteDocumento>();
        EntityManager em1 = getEM();
        em1.getTransaction().begin();
        CriteriaBuilder builder = em1.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SiteDocumento.class);
        Root root = query.from(SiteDocumento.class);
        Join<SiteDocumento, SitePublicacao> join =  root.join("publicacaoId", JoinType.INNER);
        Join<SitePublicacao, SiteConselho> join2 = join.join("conselhoId", JoinType.INNER);
        query.equals(join2.get("id"));
        query.where(builder.equal(join2.get("id"),"7"));   //nde
        query.orderBy(builder.desc(root.get("hora")));
        result = em1.createQuery(query).getResultList();
        em1.close();
        return result;
    }
    
}
