import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RA {

    @Test
    public void testGetRequest() {
        RestAssured.baseURI = "https://petstore.swagger.io/";
        Response response = given()
                .when().log().all()
                .get("v2/pet/3123124")
                .then().log().all()
                .assertThat().body("message", equalTo("Pet not found"))
                .extract().response();

        int statusCode = response.getStatusCode();
        assertEquals(404, statusCode);
    }

}

