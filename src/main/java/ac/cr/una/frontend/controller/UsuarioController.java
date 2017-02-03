package ac.cr.una.frontend.controller;

import ac.cr.una.frontend.Constants;
import ac.cr.una.frontend.model.Usuario;
import ac.cr.una.frontend.service.UsuarioService;
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

public class UsuarioController implements ActionListener {

    private JButton BtnBuscarAll;
    private JButton btnBuscar;
    private JButton btneditar;
    private JButton btneliminar;
    private JButton btneliminarall;
    private JButton btninfo;
    private JButton BtnAgregar;
    private JButton BtnLimpiar;
    private JTable table;
    private JTextField txtBuscar;
    private JTextField txtnombre;
    private JTextField txtpassword;
    private UsuarioService usuarioService;
    private Object[][] usuarios;

    public UsuarioController(JButton BtnBuscarAll, JButton btnBuscar, JButton btneditar, JButton btneliminar, JButton btneliminarall, JButton btninfo, JButton BtnAgregar, JTable table, JTextField txtBuscar, JTextField txtnombre, JTextField txtpassword, JButton BtnLimpiar) throws IOException, JsonMappingException, Exception {
        super();
        this.BtnBuscarAll = BtnBuscarAll;
        this.btnBuscar = btnBuscar;
        this.btneditar = btneditar;
        this.btneliminar = btneliminar;
        this.btneliminarall = btneliminarall;
        this.btninfo = btninfo;
        this.BtnAgregar = BtnAgregar;
        this.table = table;
        this.txtBuscar = txtBuscar;
        this.txtnombre = txtnombre;
        this.txtpassword = txtpassword;
        this.BtnLimpiar = BtnLimpiar;

        cargarTabla();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (BtnBuscarAll.equals(e.getSource())) {
            try {
                cargarTabla();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (BtnLimpiar.equals(e.getSource())) {
            limpiarTabla();
        }
        if (BtnAgregar.equals(e.getSource())) {
            try {
                crearUsuario();
            } catch (IOException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         if (btneliminar.equals(e.getSource())) {
            try {
                deletebyid();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
          if (btneditar.equals(e.getSource())){
          
            try {
                updateUsuario();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
          }

    }

    public void limpiarTabla() {

        Object[][] vacido = {};
        table.setModel(new DefaultTableModel(vacido, Constants.TABLE_HEADER_USUARIOS));
    }

    public void cargarTabla() throws IOException, JsonMappingException, Exception {

        usuarioService = new UsuarioService();
        usuarios = usuarioService.loadStudentsObjWrapper();

        table.setModel(new DefaultTableModel(usuarios, Constants.TABLE_HEADER_USUARIOS));
    }

    public void crearUsuario() throws JsonMappingException, IOException, Exception {

        Usuario nuevoRegistro = new Usuario();
        nuevoRegistro.setName(txtnombre.getText());
        nuevoRegistro.setPassword(txtpassword.getText());
        txtnombre.setText("");
        txtpassword.setText("");
        usuarioService.createStudent(nuevoRegistro);

        limpiarTabla();
        cargarTabla();

    }

    public void updateUsuario() throws JsonMappingException, IOException, Exception
    {
    
        Usuario updateRegistro = new Usuario();
        updateRegistro.setIdUsuario(Integer.parseInt((String)table.getValueAt(table.getSelectedRow(), 0)));
        updateRegistro.setName((String)table.getValueAt(table.getSelectedRow(), 1));
        updateRegistro.setPassword((String)table.getValueAt(table.getSelectedRow(), 2));
        usuarioService.UpdateStudent(updateRegistro);
        JOptionPane.showMessageDialog(null,"Actualizado");
        limpiarTabla();
        cargarTabla();
        
    }
    
    
    public void deletebyid() throws Exception {

        String id = (String) table.getValueAt(table.getSelectedRow(), 0);
        usuarioService.deleteStudent(Integer.parseInt(id));
        JOptionPane.showMessageDialog(null,"Eliminado");
        limpiarTabla();
        cargarTabla();

    }

}
