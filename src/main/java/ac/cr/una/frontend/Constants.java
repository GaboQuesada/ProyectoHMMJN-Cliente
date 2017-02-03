package ac.cr.una.frontend;

public class Constants {

    public static final Object[] TABLE_HEADER_USUARIOS = {"Id", "Name", "Password"};
    public static final Object[] TABLE_HEADER_PACIENTES = {"Código", "Nombre", "Teléfono", "Dirección", "Fecha Nacimiento"};
    public static final String WS_USUARIOS_GETALL = "http://localhost:8180/ProyectoServer/rest/usuarios/all";
    public static final String WS_USUARIOS_SAVE = "http://localhost:8180/ProyectoServer/rest/usuarios/";
    public static final String WS_USUARIOS_DELETEBYID = "http://localhost:8180/ProyectoServer/rest/usuarios/delete";
    public static final String WS_USUARIOS_UPDATE = "http://localhost:8180/ProyectoServer/rest/usuarios/update";
    public static final String WS_PACIENTES_GETALL = "http://localhost:8180/ProyectoServer/rest/pacientes/all";
    public static final String WS_PACIENTES_SAVE = "http://localhost:8180/ProyectoServer/rest/pacientes/";
    public static final String WS_PACIENTES_DELETEBYID = "http://localhost:8180/ProyectoServer/rest/pacientes/delete";
    public static final String WS_PACIENTES_UPDATE = "http://localhost:8180/ProyectoServer/rest/pacientes/update";

}
