
package converter;

import dao.UsuarioDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.TbUsersystem;

/**
 *
 * @author UFT
 */
@FacesConverter(forClass = model.TbUsersystem.class)
public class UsuarioConverter implements Converter {

    private UsuarioDAO userDao = new UsuarioDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string != null && string.trim().length() > 0) {
            try {
                //(TbUsersystem) userDao.buscaPorID(Integer.valueOf(string));
                return (TbUsersystem) userDao.buscaPorID2(Long.valueOf(string));
                        //userDao.buscaPorID2(Long.valueOf(string));
                        //(TbUsersystem) uic.getAttributes().get(string);
            } catch (NumberFormatException e) {
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
            return String.valueOf(((TbUsersystem) o).getId());
        }

    }
}
