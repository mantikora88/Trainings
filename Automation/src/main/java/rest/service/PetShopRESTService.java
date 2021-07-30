package rest.service;

import rest.model.UserModel;
import org.json.simple.JSONObject;

public interface PetShopRESTService<R> extends RESTService {

    String PET_SHOP_URL = "https://petstore.swagger.io";
    String PATH_PARAM_USERNAME = "username";
    String SERVICE_PATH = "v2";
    String USER_SERVICE_PATH = "user";
    String PET_SERVICE_PATH = "pet";

     R createUser(UserModel user);

     R createUser(JSONObject user);

     R createPet(JSONObject pet);

    UserModel getUser(String userName);


}
