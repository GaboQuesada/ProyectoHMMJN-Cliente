
package ac.cr.una.frontend.service;
import ac.cr.una.frontend.Constants;
import ac.cr.una.frontend.model.Enfermedades;
import ac.cr.una.frontend.model.Pacientes;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;
public class EnfermedadesService {
    
      //GET

    
     public EnfermedadesService() {
    }

    public Object[][] loadStudentsObjWrapper(int id) throws JsonGenerationException, JsonMappingException, IOException, Exception {
        Enfermedades[] students = loadJsonFromWebService(id);
        Object[][] data = null;

        if (students != null && students.length > 0) {
            data = new Object[students.length][2]; // filas y columnas
            int i = 0;
            for (Enfermedades student : students) {
                data[i][0] = checkIfNull(student.getIdEnfermedades());
                data[i][1] = checkIfNull(student.getEnfermedad());
                i++;
            }
        }

        return data;
    }
    
    
    private Enfermedades[] loadJsonFromWebService(int id) throws Exception {
        Enfermedades[] students;
        String jSonFile;
        ObjectMapper mapper = new ObjectMapper();
        Client client = Client.create();
        WebResource webResource = client.resource(Constants.WS_ENFERMEDADES_GETALL.concat(String.valueOf(id)));
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        jSonFile = response.getEntity(String.class);
        students = mapper.readValue(jSonFile, Enfermedades[].class);
        return students;
    }
    
    //POST
    public boolean createStudent(Enfermedades student) throws JsonGenerationException, JsonMappingException, IOException {

        boolean isCreated = true;
        ObjectMapper mapper = new ObjectMapper();
        Client client = Client.create();
        WebResource webResource = client.resource(Constants.WS_ENFERMEDADES_SAVE);
        String jsonInString = mapper.writeValueAsString(student);

        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, jsonInString);

        if (response.getStatus() != 200) {
            isCreated = false;
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        return isCreated;
    }
    
    //PUT
    public boolean UpdateStudent(Enfermedades student) throws JsonGenerationException, JsonMappingException, IOException {

        boolean isCreated = true;
        ObjectMapper mapper = new ObjectMapper();
        Client client = Client.create();
        WebResource webResource = client.resource(Constants.WS_ENFERMEDADES_UPDATE);
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
