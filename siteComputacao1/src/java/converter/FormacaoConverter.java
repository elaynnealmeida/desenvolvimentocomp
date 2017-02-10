
package converter;

import dao.FormacaoDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.SiteFormacao;

/**
 *
 * @author UFT
 */
@FacesConverter(forClass = model.SiteFormacao.class)
public class FormacaoConverter implements Converter {
    private FormacaoDAO formacaoDao = new FormacaoDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (!string.trim().equals("")) {
            try {
                System.out.println("valor da string cargo: "+string);
                return (SiteFormacao) formacaoDao.buscaPorID(Integer.valueOf(string));
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
            return String.valueOf(((SiteFormacao) o).getId());
        }

    }
}
