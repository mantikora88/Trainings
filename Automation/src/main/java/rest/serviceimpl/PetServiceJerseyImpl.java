package rest.serviceimpl;

import rest.model.UserModel;
import org.json.simple.JSONObject;
import rest.service.PetShopRESTService;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PetServiceJerseyImpl implements PetShopRESTService<Response> {

    /*Client jaxClient = ClientBuilder.newClient();*/

    @Override
    public Response createUser(UserModel user) {
        Client jaxClient = ClientBuilder.newClient();
        WebTarget target = jaxClient.target(PET_SHOP_URL).path(SERVICE_PATH).path(USER_SERVICE_PATH);
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(user));
        return null;
    }

    @Override
    public Response createUser(JSONObject user) {
        return null;
    }

    @Override
    public Response createPet(JSONObject pet) {
        return null;
    }

    @Override
    public UserModel getUser(String userName) {
        return null;
    }

    @Override
    public <T> T authorize() {
        return null;
    }
}
