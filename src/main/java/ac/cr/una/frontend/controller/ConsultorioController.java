
package ac.cr.una.frontend.controller;

import ac.cr.una.frontend.service.ConsultoriosService;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ac.cr.una.frontend.Constants;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;


public class ConsultorioController {
    
    private JTable Table;

    public ConsultorioController(JTable Table) throws Exception {
        this.Table = Table;
        mostrar();
    }
    
    
    public void  mostrar() throws IOException, JsonMappingException, Exception
    {
        
        ConsultoriosService service = new ConsultoriosService();
        Object [][] consultorios= service.loadStudentsObjWrapper();
        
        Table.setModel(new DefaultTableModel(consultorios,Constants.TABLE_HEADER_CONSULTORIOS ));
        
      
    
    }
    
}
