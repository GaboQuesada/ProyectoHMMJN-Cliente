
package ac.cr.una.frontend.controller;

import ac.cr.una.frontend.view.PacientesView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Gabo Quesada
 */
public class PrincipalMenuController implements ActionListener {
    
    private JButton jButton1;
    private JButton jButton2;

    public PrincipalMenuController() {
    }

    public PrincipalMenuController(JButton jButton1, JButton jButton2) {
        this.jButton1 = jButton1;
        this.jButton2 = jButton2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
        if(jButton1.equals(e.getSource())){try {
            new PacientesView().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(PrincipalMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
}
        
        
    }
    
    
    
    
}
