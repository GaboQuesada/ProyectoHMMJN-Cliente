package ac.cr.una.frontend.service;

import ac.cr.una.frontend.model.Citas;
import ac.cr.una.frontend.Constants;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Gabo Quesada
 */
public class CitasService {

    public CitasService() {
    }
    
    
     public Object[][] loadStudentsObjWrapper() throws JsonGenerationException, JsonMappingException, IOException, Exception {
        Citas[] students = loadJsonFromWebService();
        Object[][] data = null;

        if (students != null && students.length > 0) {
            data = new Object[students.length][5]; // filas y columnas
            int i = 0;
            for (Citas student : students) {
                data[i][0] = checkIfNull(student.getIdCita());
                data[i][1] = checkIfNull(student.getIdPaciente().getName());
                data[i][2] = checkIfNull(student.getConsultorio());
                data[i][3] = checkIfNull(student.getDia());
                data[i][4] = checkIfNull(student.getHora());
                i++;
            }
        }

        return data;
    }
     
      public Object[][] loadStudentsByIdObjWrapper(int id) throws JsonGenerationException, JsonMappingException, IOException, Exception {
        Citas[] students = loadJsonFromWebServicebyid( id);
        Object[][] data = null;

    if (students != null && students.length > 0) {
            data = new Object[students.length][5]; // filas y columnas
            int i = 0;
            for (Citas student : students) {
                data[i][0] = checkIfNull(student.getIdCita());
                data[i][1] = checkIfNull(student.getIdPaciente().getName());
                data[i][2] = checkIfNull(student.getConsultorio());
                data[i][3] = checkIfNull(student.getDia());
                data[i][4] = checkIfNull(student.getHora());
                i++;
            }
        }

        return data;
    }

    private Citas[] loadJsonFromWebServicebyid(int id) throws Exception {
        Citas[] students;
        String jSonFile;
        ObjectMapper mapper = new ObjectMapper();
        Client client = Client.create();
        WebResource webResource = client.resource(Constants.WS_CITAS_GETALLBYID.concat(String.valueOf(id)));
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        jSonFile = response.getEntity(String.class);
        students = mapper.readValue(jSonFile, Citas[].class);
        return students;
    }

    //GET
    private Citas[] loadJsonFromWebService() throws Exception {
        Citas[] students;
        String jSonFile;
        ObjectMapper mapper = new ObjectMapper();
        Client client = Client.create();
        WebResource webResource = client.resource(Constants.WS_CITAS_GETALL);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        jSonFile = response.getEntity(String.class);
        students = mapper.readValue(jSonFile, Citas[].class);
        return students;
    }
    //POST

    public boolean createStudent(Citas student) throws JsonGenerationException, JsonMappingException, IOException {

        boolean isCreated = true;
        ObjectMapper mapper = new ObjectMapper();
        Client client = Client.create();
        WebResource webResource = client.resource(Constants.WS_CITAS_SAVE);
        String jsonInString = mapper.writeValueAsString(student);

        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, jsonInString);

        if (response.getStatus() != 200) {
            isCreated = false;
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        return isCreated;
    }
    //PUT

    public boolean UpdateStudent(Citas student) throws JsonGenerationException, JsonMappingException, IOException {

        boolean isCreated = true;
        ObjectMapper mapper = new ObjectMapper();
        Client client = Client.create();
        WebResource webResource = client.resource(Constants.WS_CITAS_UPDATE);
        String jsonInString = mapper.writeValueAsString(student);

        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE).put(ClientResponse.class, jsonInString);

        if (response.getStatus() != 200) {
            isCreated = false;
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        return isCreated;
    }

    private String checkIfNull(Object obj) {
        String text;
        if (obj == null) {
            text = "";
        } else {
            text = obj.toString();
        }
        return text;
    }
}
