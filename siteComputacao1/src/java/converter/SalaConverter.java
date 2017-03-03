
package converter;

import dao.SalaDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.TbSala;

/**
 *
 * @author UFT
 */
@FacesConverter(value = "SalaConverter")
public class SalaConverter implements Converter {
    private SalaDAO salaDao = new SalaDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (!string.trim().equals("")) {
            try {
                System.out.println("valor da string cargo: "+string);
                return (TbSala) salaDao.buscaPorID2(Integer.valueOf(string));
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
            return String.valueOf(((TbSala) o).getId());
        }

    }
    
}
