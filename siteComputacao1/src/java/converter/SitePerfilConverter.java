
package converter;

import dao.SitePerfilDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.SitePerfil;

/**
 *
 * @author UFT
 */
@FacesConverter(forClass = model.SitePerfil.class)
public class SitePerfilConverter implements Converter {

    private SitePerfilDAO perfilDao = new SitePerfilDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string != null && string.trim().length() > 0) {
            try {
                System.out.println("valor da string: "+string);
                return (SitePerfil) perfilDao.buscaPorID(Integer.valueOf(string));
                        //(SitePerfil) uic.getAttributes().get(string);
                //(SitePerfil) perfilDao.buscaPorID(Integer.valueOf(string));
            } catch (NumberFormatException e) {
                System.out.println("ERRO de conversão de perfil: "+e);
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
            return String.valueOf(((SitePerfil) o).getId());
        }

    }
    
}
