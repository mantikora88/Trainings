package serviceimpl;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.UserModel;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;
import service.PetShopRESTService;


import static io.restassured.RestAssured.*;

public class RestAssureServiceImpl implements PetShopRESTService {

    @Override
    public RequestSpecification authorize() {
        return given().auth().basic("qa", "qa");
    }

    @Override
    public Response createUser(UserModel user) {
        return given().contentType(ContentType.JSON).body(user).post(getURL(PET_SHOP_URL, SERVICE_PATH, USER_SERVICE_PATH));
    }

    public Response createUser(JSONObject user) {
        return given().contentType(ContentType.JSON).body(user.toJSONString()).post(getURL(PET_SHOP_URL, SERVICE_PATH, USER_SERVICE_PATH));
    }

    @Override
    public Response createPet(JSONObject pet) {
        return given().contentType(ContentType.JSON).body(pet.toJSONString()).post(getURL(PET_SHOP_URL, SERVICE_PATH, PET_SERVICE_PATH));
    }

    @Override
    public UserModel getUser(String userName) {
        Response response = given().contentType(ContentType.JSON).pathParam(PATH_PARAM_USERNAME, userName).
                get(getURLWithParameters(PET_SHOP_URL, "username", SERVICE_PATH, USER_SERVICE_PATH));
        Assertions.assertThat(response.getStatusCode()).as("Unable to get user - " + userName).isEqualTo(200);
        return response.as(UserModel.class);
    }
}
