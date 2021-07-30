package tests.petshop.rest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import rest.model.PetModel;
import org.testng.annotations.Test;
import rest.service.PetShopRESTService;
import rest.serviceimpl.PetServiceRestAssureImpl;
import tests.RESTBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class TestPetCreation extends RESTBaseTest {

    @Story(value = "Story Pet Shop")
    @Feature("BCMM-2 Pet creation")
    @Description(value = "Create pet using JSON")
    @Test
    public void testPetCreation() {
        PetShopRESTService<Response> petShopService = new PetServiceRestAssureImpl();
        Response catResponse = petShopService.createPet(getTestData());
        assertThat(catResponse.getStatusCode()).isEqualTo(200);
        assertThat(catResponse.as(PetModel.class).getName()).isEqualTo("Leo");
    }
}
