package service;

import io.restassured.response.Response;
import model.UserModel;
import org.json.simple.JSONObject;

public interface PetShopRESTService extends RESTService{
    String PET_SHOP_URL = "https://petstore.swagger.io/v2";

    public Response createUser(UserModel user);
    public Response createUser(JSONObject user);
    public Response createPet(JSONObject pet);
    public UserModel getUser(String userName);


}
