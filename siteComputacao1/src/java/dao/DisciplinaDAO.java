
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
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
