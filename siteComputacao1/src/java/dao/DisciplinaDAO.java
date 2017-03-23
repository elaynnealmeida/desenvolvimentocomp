
package dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import model.TbDisciplina;

/**
 *
 * @author UFT
 */
public class DisciplinaDAO extends GenericDAO<TbDisciplina>{
    public DisciplinaDAO() {
        super(TbDisciplina.class);
    }
}
