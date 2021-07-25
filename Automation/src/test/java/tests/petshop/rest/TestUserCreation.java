package tests.petshop.rest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import model.UserModel;
import model.UserResponseModel;
import org.testng.annotations.Test;
import service.PetShopRESTService;
import serviceimpl.RestAssureServiceImpl;
import tests.RESTBaseTest;

import static org.assertj.core.api.Assertions.*;

public class TestUserCreation extends RESTBaseTest {
    PetShopRESTService petShopService = new RestAssureServiceImpl();

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
        PetShopRESTService petShopService = new RestAssureServiceImpl();

        Response createUser = petShopService.createUser(UserModel.builder().id(33).username("test33").firstName("test33").
                lastName("test33").email("231dasd@dasdom.com").phone("1234567890").userStatus(1).password("qa").build());

        assertThat(createUser.getStatusCode()).isEqualTo(200);
        assertThat(createUser.as(UserResponseModel.class).getMessage()).isEqualTo("33");
    }
}
