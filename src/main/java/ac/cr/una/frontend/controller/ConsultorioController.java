package ac.cr.una.frontend.controller;

import ac.cr.una.frontend.service.ConsultoriosService;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import ac.cr.una.frontend.Constants;
import ac.cr.una.frontend.model.Citas;
import ac.cr.una.frontend.model.Pacientes;
import ac.cr.una.frontend.service.CitasService;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ConsultorioController implements ActionListener {

    private JTable Table;
    private JButton btnAgregar;
    private JButton btnSelecionar;
    private JButton btnconfirmar;
    private JComboBox<String> combodia;
    private JTable tablacitas;
    private JTextField txthora;
    private Pacientes pacientes;
    private Object[][] citas;
    private CitasService citasService;

    public ConsultorioController() {
    }

    public ConsultorioController(JTable Table, JButton btnAgregar, JButton btnSelecionar, JButton btnconfirmar, JComboBox<String> combodia, JTable tablacitas, JTextField txthora, Pacientes pacientes) throws Exception {
        super();
        this.Table = Table;
        this.btnAgregar = btnAgregar;
        this.btnSelecionar = btnSelecionar;
        this.btnconfirmar = btnconfirmar;
        this.combodia = combodia;
        this.tablacitas = tablacitas;
        this.txthora = txthora;
        this.pacientes = pacientes;
        mostrar();
        verporid();
    }

    public void mostrar() throws IOException, JsonMappingException, Exception {

        ConsultoriosService service = new ConsultoriosService();
        Object[][] consultorios = service.loadStudentsObjWrapper();

        Table.setModel(new DefaultTableModel(consultorios, Constants.TABLE_HEADER_CONSULTORIOS));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (btnAgregar.equals(e.getSource())) {
            
            try {
                agendar();
            } catch (IOException ex) {
                Logger.getLogger(ConsultorioController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ConsultorioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (btnSelecionar.equals(e.getSource())) {
        }
        if (btnconfirmar.equals(e.getSource())) {
        }

    }

    public void selecionar() {

    }

    public void agendar() throws JsonMappingException, IOException, Exception {

        Citas cita = new Citas();

        switch (combodia.getSelectedItem().toString()) {

            case "Lunes   CIMA":
                cita.setConsultorio("CIMA");
            case "Martes  CIMA":
                cita.setConsultorio("CIMA");
                break;
            case "Jueves  Centro M del Este":
                cita.setConsultorio("Centro M del Este");
            case "Viernes  Centro M del Este":
                cita.setConsultorio("Centro M del Este");
                break;
            default:
                break;

        }
        switch (combodia.getSelectedItem().toString()) {

            case "Lunes   CIMA":
                cita.setDia("Lunes");
            case "Martes  CIMA":
                cita.setDia("Lunes");
                break;
            case "Jueves  Centro M del Este":
                cita.setDia("Jueves");
            case "Viernes  Centro M del Este":
                cita.setDia("Viernes");
                break;
            default:
                break;

        }

        cita.setIdPaciente(pacientes);
        cita.setHora(txthora.getText());
        citasService = new CitasService();
        citasService.createStudent(cita);
        limpiarTabla();
        verporid();
    
    }

    public void verporid() throws IOException, JsonMappingException, Exception {
        
        
        citasService = new CitasService();
        citas= citasService.loadStudentsByIdObjWrapper(pacientes.getIdPacientes());
        tablacitas.setModel(new DefaultTableModel(citas, Constants.TABLE_HEADER_CITAS));
        

    }

    public void limpiarTabla() {

        Object[][] limpio= {};
        tablacitas.setModel(new DefaultTableModel(limpio, Constants.TABLE_HEADER_CITAS));
    }

    public void confirmar() {
    }

}
