package ac.cr.una.frontend.controller;

import ac.cr.una.frontend.Constants;
import ac.cr.una.frontend.model.Enfermedades;
import ac.cr.una.frontend.model.Observaciones;
import ac.cr.una.frontend.model.Pacientes;
import ac.cr.una.frontend.service.EnfermedadesService;
import ac.cr.una.frontend.service.ObservacionesService;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InfoPacienteController implements ActionListener {

    private JButton BtnVolver;
    private JButton btnactenf;
    private JButton btnactob;
    private JButton btnguardarEnfermedad;
    private JButton btnguardarObservacion;
    private JTable tablaenfermedades;
    private JTable tablaobservaciones;
    private JTextField txtEnfermedades;
    private JTextField txtObservaciones;
    private Object[][] Observaciones;
    private Object[][] Enfermedades;
    private EnfermedadesService enfermedadesService;
    private ObservacionesService observacionesService;
    private Pacientes pacientes;

    public InfoPacienteController() {
    }

    public InfoPacienteController(JButton BtnVolver, JButton btnactenf, JButton btnactob, JButton btnguardarEnfermedad, JButton btnguardarObservacion, JTable tablaenfermedades, JTable tablaobservaciones, JTextField txtEnfermedades, JTextField txtObservaciones, Pacientes pacientes) throws Exception {
        super();
        this.BtnVolver = BtnVolver;
        this.btnactenf = btnactenf;
        this.btnactob = btnactob;
        this.btnguardarEnfermedad = btnguardarEnfermedad;
        this.btnguardarObservacion = btnguardarObservacion;
        this.tablaenfermedades = tablaenfermedades;
        this.tablaobservaciones = tablaobservaciones;
        this.txtEnfermedades = txtEnfermedades;
        this.txtObservaciones = txtObservaciones;
        this.pacientes = pacientes;

        JOptionPane.showMessageDialog(null, "Datos para: " + this.pacientes.getName());
        getallobservaciones();
        getallenfermedades();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (BtnVolver.equals(e.getSource())) {
        }
        
        if(btnguardarObservacion.equals(e.getSource()))
        {
        
            try {
                createObservacion();
            } catch (Exception ex) {
                Logger.getLogger(InfoPacienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(btnactob.equals(e.getSource())){
        
            try {
                updateObservacion();
            } catch (Exception ex) {
                Logger.getLogger(InfoPacienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(btnactenf.equals(e.getSource())){
        
            try {
                updateenfermedad();
            } catch (Exception ex) {
                Logger.getLogger(InfoPacienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(btnguardarEnfermedad.equals(e.getSource()))
        {
        
            try {
                createEnfermedad();
            } catch (Exception ex) {
                Logger.getLogger(InfoPacienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  

    }

    public void getallobservaciones() throws IOException, JsonMappingException, Exception {
        observacionesService = new ObservacionesService();
        Observaciones = observacionesService.loadStudentsObjWrapper(this.pacientes.getIdPacientes());

        tablaobservaciones.setModel(new DefaultTableModel(Observaciones, Constants.TABLE_HEADER_OBSERVACIONES));
    }

    ;
    public void getallenfermedades() throws IOException, JsonMappingException, Exception {

        enfermedadesService = new EnfermedadesService();
        Enfermedades = enfermedadesService.loadStudentsObjWrapper(this.pacientes.getIdPacientes());

        tablaenfermedades.setModel(new DefaultTableModel(Enfermedades, Constants.TABLE_HEADER_ENFERMEDADES));

    }

    ;
    public void updateenfermedad() throws JsonMappingException, IOException, Exception {
        
        Enfermedades nuevo = new Enfermedades();
        nuevo.setIdEnfermedades(Integer.parseInt((String) tablaenfermedades.getValueAt(tablaenfermedades.getSelectedRow(), 0)));
        nuevo.setEnfermedad((String) tablaenfermedades.getValueAt(tablaenfermedades.getSelectedRow(), 1));
        nuevo.setIdPacientes(this.pacientes);

        enfermedadesService.UpdateStudent(nuevo);
        limpiarTablaenfermedades();
        getallenfermedades();

    }

    ;
    public void updateObservacion() throws JsonMappingException, IOException, Exception {
        
         Observaciones nuevo = new Observaciones();
        nuevo.setIdObservaciones(Integer.parseInt((String) tablaobservaciones.getValueAt(tablaobservaciones.getSelectedRow(), 0)));
        nuevo.setObservacion((String) tablaobservaciones.getValueAt(tablaobservaciones.getSelectedRow(), 1));
        nuevo.setIdPacientes(this.pacientes);

        observacionesService.UpdateStudent(nuevo);
        limpiarTablaobservaciones();
        getallobservaciones();
    }

    ;
    
    
    public void createObservacion() throws JsonMappingException, IOException, Exception {

        Observaciones nuevo = new Observaciones();
      
        nuevo.setObservacion(txtObservaciones.getText());
        nuevo.setIdPacientes(this.pacientes);

        observacionesService.createStudent(nuevo);
        limpiarTablaobservaciones();
        getallobservaciones();

    }

    ;
    public void createEnfermedad() throws JsonMappingException, IOException, Exception {

        Enfermedades nuevo = new Enfermedades();
       
        nuevo.setEnfermedad(txtEnfermedades.getText());
        nuevo.setIdPacientes(this.pacientes);

        enfermedadesService.createStudent(nuevo);
        limpiarTablaenfermedades();
        getallenfermedades();

    }

    ;
    
    public void limpiarTablaobservaciones() {

        Object[][] vacido = {};
        tablaobservaciones.setModel(new DefaultTableModel(vacido, Constants.TABLE_HEADER_OBSERVACIONES));
    }

    ;
    
    public void limpiarTablaenfermedades() {

        Object[][] vacido = {};
        tablaenfermedades.setModel(new DefaultTableModel(vacido, Constants.TABLE_HEADER_ENFERMEDADES));
    }
;

}
