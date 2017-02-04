package ac.cr.una.frontend;

public class Constants {

    //TABLAS
    public static final Object[] TABLE_HEADER_USUARIOS = {"Id", "Name", "Password"};
    public static final Object[] TABLE_HEADER_PACIENTES = {"Código", "Nombre", "Teléfono", "Dirección", "Fecha Nacimiento"};
    public static final Object[] TABLE_HEADER_ENFERMEDADES = {"Código", "Enfermedad"};
    public static final Object[] TABLE_HEADER_OBSERVACIONES = {"Código", "Observación"};
    public static final Object[] TABLE_HEADER_CONSULTORIOS = {"Código", "Nombre", "Teléfono", "Horario"};
    public static final Object[] TABLE_HEADER_CITAS = {"Código", "Paciente", "Consultorio", "Día","Hora","confirmado"};
    
    
    //PACIENTES WEBSERVICE
    public static final String WS_USUARIOS_GETALL = "http://localhost:8180/ProyectoServer/rest/usuarios/all";
    public static final String WS_USUARIOS_SAVE = "http://localhost:8180/ProyectoServer/rest/usuarios/";
    public static final String WS_USUARIOS_DELETEBYID = "http://localhost:8180/ProyectoServer/rest/usuarios/delete";
    public static final String WS_USUARIOS_UPDATE = "http://localhost:8180/ProyectoServer/rest/usuarios/update";
    public static final String WS_PACIENTES_GETALL = "http://localhost:8180/ProyectoServer/rest/pacientes/all";
    public static final String WS_PACIENTES_SAVE = "http://localhost:8180/ProyectoServer/rest/pacientes/";
    public static final String WS_PACIENTES_DELETEBYID = "http://localhost:8180/ProyectoServer/rest/pacientes/delete";
    public static final String WS_PACIENTES_UPDATE = "http://localhost:8180/ProyectoServer/rest/pacientes/update";
    
    //OBSERVACIONES WEBSERVICE
    public static final String WS_OBSERVACIONES_GETALL ="http://localhost:8180/ProyectoServer/rest/observaciones/allByid";
    public static final String WS_OBSERVACIONES_UPDATE = "http://localhost:8180/ProyectoServer/rest/observaciones/update";
    public static final String WS_OBSERVACIONES_SAVE = "http://localhost:8180/ProyectoServer/rest/observaciones/";
    //ENFERMEDADES WEBSERVICE
    public static final String WS_ENFERMEDADES_GETALL = "http://localhost:8180/ProyectoServer/rest/enfermedades/allByid";
    public static final String WS_ENFERMEDADES_UPDATE = "http://localhost:8180/ProyectoServer/rest/enfermedades/update";
    public static final String WS_ENFERMEDADES_SAVE = "http://localhost:8180/ProyectoServer/rest/enfermedades/";
    
    //CONSULTORIO WEBSERVICE
    public static final String WS_CONSULTORIOS_GETALL = "http://localhost:8180/ProyectoServer/rest/consultorios/all";
    
    //CITAS WEBSERVICE
    public static final String WS_CITAS_GETALL = "http://localhost:8180/ProyectoServer/rest/citas/all";
    public static final String WS_CITAS_GETALLBYID ="http://localhost:8180/ProyectoServer/rest/citas/allByid";
    public static final String WS_CITAS_UPDATE = "http://localhost:8180/ProyectoServer/rest/citas/update";
    public static final String WS_CITAS_SAVE = "http://localhost:8180/ProyectoServer/rest/citas/";

}
