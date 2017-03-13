package converter;

import dao.SiteCargoDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import model.SiteCargo;

/**
 *
 * @author UFT
 */
@FacesConverter(value = "CargoConverter")
public class SiteCargoConverter implements Converter {

    private SiteCargoDAO cargoDao = new SiteCargoDAO();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (!string.trim().equals("")) {
            try {
                System.out.println("valor da string cargo: "+string);
                return (SiteCargo) cargoDao.buscaPorID(Integer.valueOf(string));
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
            return String.valueOf(((SiteCargo) o).getId());
        }

    }
}
