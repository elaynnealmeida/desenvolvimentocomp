
package converter;

import dao.EquipamentoDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.SiteEquipamento;

/**
 *
 * @author UFT
 */
@FacesConverter(value = "EquipamentoConverter")
public class EquipamentoConverter implements Converter {

    private EquipamentoDAO dao = new EquipamentoDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (!string.trim().equals("")) {
            try {
                System.out.println("valor da string: " + string);
                return (SiteEquipamento) dao.buscaPorID(Integer.valueOf(string));
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
            return String.valueOf(((SiteEquipamento) o).getId());
        }

    }
    
}
