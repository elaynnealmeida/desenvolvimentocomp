
package converter;

import dao.TipoDocumentoDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.SiteTipoArquivo;

/**
 *
 * @author UFT
 */
@FacesConverter(value = "TipoDocumentoConverter")
public class TipoDocumentoConverter implements Converter {
    private TipoDocumentoDAO tpdDao = new TipoDocumentoDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (!string.trim().equals("")) {
            try {
                //System.out.println("valor da string cargo: "+string);
                return (SiteTipoArquivo) tpdDao.buscaPorID(Integer.valueOf(string));
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
            return String.valueOf(((SiteTipoArquivo) o).getId());
        }

    }
    
}
