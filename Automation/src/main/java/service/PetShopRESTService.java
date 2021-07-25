package service;

import io.restassured.response.Response;
import model.UserModel;
import org.json.simple.JSONObject;

public interface PetShopRESTService extends RESTService{
    String PET_SHOP_URL = "https://petstore.swagger.io";
    String PATH_PARAM_USERNAME = "username";
    String SERVICE_PATH = "v2";
    String USER_SERVICE_PATH = "user";
    String PET_SERVICE_PATH = "pet";

    public Response createUser(UserModel user);
    public Response createUser(JSONObject user);
    public Response createPet(JSONObject pet);
    public UserModel getUser(String userName);


}
