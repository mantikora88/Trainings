package tests.petshop.rest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import rest.model.UserModel;
import rest.model.UserResponseModel;
import org.testng.annotations.Test;
import rest.service.PetShopRESTService;
import rest.serviceimpl.PetServiceJerseyImpl;
import rest.serviceimpl.PetServiceRestAssureImpl;
import tests.RESTBaseTest;

import static org.assertj.core.api.Assertions.*;

public class TestUserCreation extends RESTBaseTest {

    private final PetShopRESTService<Response> petShopService = new PetServiceRestAssureImpl();
    private final PetShopRESTService<javax.ws.rs.core.Response> petShopServiceJersey = new PetServiceJerseyImpl();

    @Story(value = "Story Pet Shop")
    @Feature("BCMM-2 User in pet shop")
    @Description(value = "Create User using JSON")
    @Test
    public void testUserCreationJSON() {

        Response createUser = petShopService.createUser(getTestData());
        assertThat(createUser.getStatusCode()).isEqualTo(200);
        assertThat(createUser.as(UserResponseModel.class).getMessage()).isEqualTo("33");

        UserModel getUser = petShopService.getUser("UserPetTest");
        assertThat(getUser.getFirstName()).isEqualTo("Johny");
    }

    @Story(value = "Story Pet Shop")
    @Feature("BCMM-2 User in pet shop")
    @Description(value = "Create User using builder")
    @Test
    public void testUserCreationBuilder() {
        Response createUser = petShopService.createUser(UserModel.builder().id(33).username("test33").firstName("test33").
                lastName("test33").email("231dasd@dasdom.com").phone("1234567890").userStatus(1).password("qa").build());

        assertThat(createUser.getStatusCode()).isEqualTo(200);
        assertThat(createUser.as(UserResponseModel.class).getMessage()).isEqualTo("33");
    }

/*    @Story(value = "Story Pet Shop")
    @Feature("BCMM-2 User in pet shop")
    @Description(value = "Create User using builder and Jersey ws")
    @Test
    public void testUserCreationBuilderJaxRs() {
        javax.ws.rs.core.Response createUserResponse = petShopServiceJersey.createUser(UserModel.builder().id(33).username("test38").firstName("test38").
                lastName("test38").email("2381dasd@dasdom.com").phone("1234567898").userStatus(1).password("qa").build());
        UserResponseModel user = createUserResponse.readEntity(UserResponseModel.class);
        assertThat(createUserResponse.getStatus()).isEqualTo(200);
        assertThat(user.getMessage()).isEqualTo("33");
    }*/
}
