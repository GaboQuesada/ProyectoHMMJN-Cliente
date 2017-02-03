package ac.cr.una.frontend.service;

import ac.cr.una.frontend.Constants;
import ac.cr.una.frontend.model.Pacientes;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

public class PacientesService {

    public PacientesService() {
    }

    public Object[][] loadStudentsObjWrapper() throws JsonGenerationException, JsonMappingException, IOException, Exception {

        Pacientes[] students = loadJsonFromWebService();
        Object[][] data = null;

        if (students != null && students.length > 0) {
            data = new Object[students.length][5]; // filas y columnas
            int i = 0;
            for (Pacientes student : students) {
                data[i][0] = checkIfNull(student.getIdPacientes());
                data[i][1] = checkIfNull(student.getName());
                data[i][2] = checkIfNull(student.getTelefono());
                data[i][3] = checkIfNull(student.getDireccion());
                data[i][4] = checkIfNull(student.getFechanacimiento());
                i++;
            }
        }

        return data;
    }
    //GET

    private Pacientes[] loadJsonFromWebService() throws Exception {
        Pacientes[] students;
        String jSonFile;
        ObjectMapper mapper = new ObjectMapper();
        Client client = Client.create();
        WebResource webResource = client.resource(Constants.WS_PACIENTES_GETALL);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        jSonFile = response.getEntity(String.class);
        students = mapper.readValue(jSonFile, Pacientes[].class);
        return students;
    }

    //POST
    public boolean createStudent(Pacientes student) throws JsonGenerationException, JsonMappingException, IOException {

        boolean isCreated = true;
        ObjectMapper mapper = new ObjectMapper();
        Client client = Client.create();
        WebResource webResource = client.resource(Constants.WS_PACIENTES_SAVE);
        String jsonInString = mapper.writeValueAsString(student);

        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, jsonInString);

        if (response.getStatus() != 200) {
            isCreated = false;
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        return isCreated;
    }

    //DELETE
    public boolean deleteStudent(int id) {
        boolean isDeleted = false;

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_PACIENTES_DELETEBYID.concat(String.valueOf(id)));

        //POST del JSON
        ClientResponse response = webResource.delete(ClientResponse.class);

        if (response.getStatus() != 200) {
            isDeleted = false;
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        return isDeleted;
    }

    //PUT
    public boolean UpdateStudent(Pacientes student) throws JsonGenerationException, JsonMappingException, IOException {

        boolean isCreated = true;
        ObjectMapper mapper = new ObjectMapper();
        Client client = Client.create();
        WebResource webResource = client.resource(Constants.WS_PACIENTES_UPDATE);
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
