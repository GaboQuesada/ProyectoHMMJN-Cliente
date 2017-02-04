package ac.cr.una.frontend.controller;

import ac.cr.una.frontend.Constants;
import ac.cr.una.frontend.model.Pacientes;
import ac.cr.una.frontend.service.PacientesService;
import ac.cr.una.frontend.view.ConsultoriosView;
import ac.cr.una.frontend.view.InfoPacientes;
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

public class PacientesController implements ActionListener {

    private JButton BtnAgregar;
    private JButton BtnBuscarAll;
    private JButton BtnLimpiar;
    private JButton btnBuscar;
    private JButton btnVolver;
    private JButton btneditar;
    private JButton btneliminar;
    private JButton btninfo;
    private JButton btnCitas;
    private JButton btnConsultorios;
    private JTable table;
    private JTextField txtBuscar;
    private JTextField txtdireccion;
    private JTextField txtfechanacimiento;
    private JTextField txtnombre;
    private JTextField txttelefono;
    private PacientesService usuarioService;
    private Object[][] usuarios;

    public PacientesController(JButton btnCitas,JButton btnConsultorios,JButton BtnAgregar, JButton BtnBuscarAll, JButton BtnLimpiar, JButton btnBuscar, JButton btnVolver, JButton btneditar, JButton btneliminar, JButton btninfo, JTable table, JTextField txtBuscar, JTextField txtdireccion, JTextField txtfechanacimiento, JTextField txtnombre, JTextField txttelefono) throws Exception {
        super();
        this.btnCitas = btnCitas;
        this.btnConsultorios = btnConsultorios;
        this.BtnAgregar = BtnAgregar;
        this.BtnBuscarAll = BtnBuscarAll;
        this.BtnLimpiar = BtnLimpiar;
        this.btnBuscar = btnBuscar;
        this.btnVolver = btnVolver;
        this.btneditar = btneditar;
        this.btneliminar = btneliminar;
        this.btninfo = btninfo;
        this.table = table;
        this.txtBuscar = txtBuscar;
        this.txtdireccion = txtdireccion;
        this.txtfechanacimiento = txtfechanacimiento;
        this.txtnombre = txtnombre;
        this.txttelefono = txttelefono;
        cargarTabla();
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {

        if(btnConsultorios.equals(e.getSource())){
        
            try {
                new ConsultoriosView().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (btninfo.equals(e.getSource())) { try {
            verinfo();
            } catch (Exception ex) {
                Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
            }
}
        
        if (BtnBuscarAll.equals(e.getSource())) {
            try {
                cargarTabla();
            } catch (Exception ex) {
                Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (BtnLimpiar.equals(e.getSource())) {
            limpiarTabla();
        }
        if (BtnAgregar.equals(e.getSource())) {
            try {
                crearUsuario();
            } catch (IOException ex) {
                Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (btneliminar.equals(e.getSource())) {
            try {
                deletebyid();
            } catch (Exception ex) {
                Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (btneditar.equals(e.getSource())) {

            try {
                updateUsuario();
            } catch (Exception ex) {
                Logger.getLogger(PacientesController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void limpiarTabla() {

        Object[][] vacido = {};
        table.setModel(new DefaultTableModel(vacido, Constants.TABLE_HEADER_PACIENTES));
    }

    public void cargarTabla() throws IOException, JsonMappingException, Exception {

        usuarioService = new PacientesService();
        usuarios = usuarioService.loadStudentsObjWrapper();

        table.setModel(new DefaultTableModel(usuarios, Constants.TABLE_HEADER_PACIENTES));
    }

    public void crearUsuario() throws JsonMappingException, IOException, Exception {

        Pacientes nuevoRegistro = new Pacientes();
     
        nuevoRegistro.setName(txtnombre.getText());
        nuevoRegistro.setTelefono(txttelefono.getText());
        nuevoRegistro.setDireccion(txtdireccion.getText());
        nuevoRegistro.setFechanacimiento(txtfechanacimiento.getText());
     
        usuarioService.createStudent(nuevoRegistro);

        limpiarTabla();
        cargarTabla();

    }

    public void updateUsuario() throws JsonMappingException, IOException, Exception {

        Pacientes updateRegistro = new Pacientes();
        updateRegistro.setIdPacientes(Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0)));
        updateRegistro.setName((String) table.getValueAt(table.getSelectedRow(), 1));
        updateRegistro.setTelefono((String) table.getValueAt(table.getSelectedRow(), 2));
        updateRegistro.setDireccion((String) table.getValueAt(table.getSelectedRow(), 3));
        updateRegistro.setFechanacimiento((String) table.getValueAt(table.getSelectedRow(), 4));
        usuarioService.UpdateStudent(updateRegistro);
        JOptionPane.showMessageDialog(null, "Actualizado");
        limpiarTabla();
        cargarTabla();

    }

    public void deletebyid() throws Exception {

        String id = (String) table.getValueAt(table.getSelectedRow(), 0);
        usuarioService.deleteStudent(Integer.parseInt(id));
        JOptionPane.showMessageDialog(null, "Eliminado");
        limpiarTabla();
        cargarTabla();

    }
    
    public void verinfo() throws Exception
    {
    
        Pacientes updateRegistro = new Pacientes();
        updateRegistro.setIdPacientes(Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0)));
        updateRegistro.setName((String) table.getValueAt(table.getSelectedRow(), 1));
        updateRegistro.setTelefono((String) table.getValueAt(table.getSelectedRow(), 2));
        updateRegistro.setDireccion((String) table.getValueAt(table.getSelectedRow(), 3));
        updateRegistro.setFechanacimiento((String) table.getValueAt(table.getSelectedRow(), 4));
        
        InfoPacientes nuevo = new InfoPacientes(updateRegistro);
        nuevo.setVisible(true);
    
    }

}
