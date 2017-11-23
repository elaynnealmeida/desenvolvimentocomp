
package converter;

import dao.TbProfessoresDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.TbProfessores;

/**
 *
 * @author UFT
 */
@FacesConverter(value = "ProfessorConverter")
public class ProfessorConverter implements Converter {
    private TbProfessoresDAO dao = new TbProfessoresDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (!string.trim().equals("")) {
            try {
                //System.out.println("valor da string professor: "+string);
                return (TbProfessores) dao.buscaPorID2(Long.parseLong(string));
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
            return String.valueOf(((TbProfessores) o).getId());
        }

    }
    
    
}
