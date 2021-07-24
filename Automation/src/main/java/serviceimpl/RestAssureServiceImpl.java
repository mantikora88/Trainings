package serviceimpl;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.UserModel;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;
import service.PetShopRESTService;


import static io.restassured.RestAssured.*;

public class RestAssureServiceImpl implements PetShopRESTService {

    @Override
    public void authorize() {
    }

    @Override
    public Response createUser(UserModel user) {
        Response response = given().contentType(ContentType.JSON).body(user).post(getURL(PET_SHOP_URL, "user"));
        return response;
    }

    public Response createUser(JSONObject user) {
        Response response = given().contentType(ContentType.JSON).body(user.toJSONString()).post(getURL(PET_SHOP_URL, "user"));
        return response;
    }

    @Override
    public Response createPet(JSONObject pet) {
        Response response = given().contentType(ContentType.JSON).body(pet.toJSONString()).post(getURL(PET_SHOP_URL, "pet"));
        return response;
    }

    @Override
    public UserModel getUser(String userName) {
        Response response = given().contentType(ContentType.JSON).pathParam("username", "UserPetTest").
                get(getURL(PET_SHOP_URL, "user/{username}"));
        Assertions.assertThat(response.getStatusCode()).as("Unable to get user - " + userName).isEqualTo(200);
        return response.as(UserModel.class);
    }
}
