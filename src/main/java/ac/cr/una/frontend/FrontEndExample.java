
package ac.cr.una.frontend;

import ac.cr.una.frontend.view.PacientesView;
import ac.cr.una.frontend.view.PrincipalMenu;
import ac.cr.una.frontend.view.UsuarioView;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import javax.swing.SwingUtilities;


public class FrontEndExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();

                } catch (JsonGenerationException e) {
                    System.err.println(e);
                } catch (JsonMappingException e) {
                    System.err.println(e);
                } catch (IOException e) {
                    System.err.println(e);
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        });
    }

  
    public static void createAndShowGUI() throws Exception {
       new PrincipalMenu().setVisible(true);
     //  new UsuarioView().setVisible(true);
    }
}
