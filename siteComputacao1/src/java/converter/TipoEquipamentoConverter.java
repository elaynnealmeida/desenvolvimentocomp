
package converter;

import dao.TipoEquipamentoDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.SiteTipoEquipamento;

/**
 *
 * @author UFT
 */
@FacesConverter(value = "TipoEquipamentoConverter")
public class TipoEquipamentoConverter implements Converter {
    private TipoEquipamentoDAO dao = new TipoEquipamentoDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (!string.trim().equals("")) {
            try {
                //System.out.println("valor da string cargo: "+string);
                return (SiteTipoEquipamento) dao.buscaPorID(Integer.valueOf(string));
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
            return String.valueOf(((SiteTipoEquipamento) o).getId());
        }

    }
    
    
}
