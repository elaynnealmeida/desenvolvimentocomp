
package converter;

import dao.SiteTagDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.SiteTags;

/**
 *
 * @author UFT
 */

//@FacesConverter(forClass = model.SiteTags.class)
@FacesConverter(value = "tagConverter") 
public class SiteTagConverter implements Converter {

    private SiteTagDAO tagDao = new SiteTagDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string != null && string.trim().length() > 0) {
            try {
                return (SiteTags) tagDao.buscaPorID(Integer.valueOf(string));
                        
            } catch (NumberFormatException e) {
                System.out.println("ERRO de conversão de Tag: "+e);
                throw new ConverterException("ArquivoImportacao não encontrado. Mensagem: " + e.getMessage());
            }

        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null || o.equals("")) {
            return "";
        } else {
            return String.valueOf(((SiteTags) o).getId());
        }

    }
    
}
