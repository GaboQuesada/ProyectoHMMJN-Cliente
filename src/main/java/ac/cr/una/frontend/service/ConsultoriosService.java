
package ac.cr.una.frontend.service;

import ac.cr.una.frontend.Constants;
import ac.cr.una.frontend.model.Consultorios;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;
public class ConsultoriosService {

    public ConsultoriosService() {
    }
    
        public Object[][] loadStudentsObjWrapper() throws JsonGenerationException, JsonMappingException, IOException, Exception {

        Consultorios[] students = loadJsonFromWebService();
        Object[][] data = null;

        if (students != null && students.length > 0) {
            data = new Object[students.length][4]; // filas y columnas
            int i = 0;
            for (Consultorios student : students) {
                data[i][0] = checkIfNull(student.getIdConsultorio());
                data[i][1] = checkIfNull(student.getName());
                data[i][2] = checkIfNull(student.getTelefono());
                data[i][3] = checkIfNull(student.getFechayhora());
        
                i++;
            }
        }

        return data;
    }
    //GET

    private Consultorios[] loadJsonFromWebService() throws Exception {
        Consultorios[] students;
        String jSonFile;
        ObjectMapper mapper = new ObjectMapper();
        Client client = Client.create();
        WebResource webResource = client.resource(Constants.WS_CONSULTORIOS_GETALL);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        jSonFile = response.getEntity(String.class);
        students = mapper.readValue(jSonFile, Consultorios[].class);
        return students;
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
