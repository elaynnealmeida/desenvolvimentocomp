
package converter;

import dao.DisciplinaDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.TbDisciplina;

/**
 *
 * @author UFT
 */
@FacesConverter(value = "DisciplinaConverter")
public class DisciplinaConverter implements Converter {
    private DisciplinaDAO disciplinaDao = new DisciplinaDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (!string.trim().equals("")) {
            try {
                //System.out.println("valor da string: "+string);
                return (TbDisciplina) disciplinaDao.buscaPorID2(Integer.valueOf(string));
            } catch (NumberFormatException e) {
                throw new ConverterException("Erro de conversão: " + e.getMessage());
            }

        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null || o.equals("")) {
            return "";
        } else {
            return String.valueOf(((TbDisciplina) o).getId());
        }

    }
    
    
}
