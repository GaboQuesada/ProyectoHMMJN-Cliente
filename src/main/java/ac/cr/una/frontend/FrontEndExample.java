
package ac.cr.una.frontend;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import javax.swing.SwingUtilities;
import ac.cr.una.frontend.view.UsuarioView;

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
       new UsuarioView().setVisible(true);
    }
}
