package UI.day08;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAPITest {
    @Test
    public void testGetApi() {
        RestAssured.baseURI = "https://reqres.in/";

        Response response = given()
                //.param("2")
                .header("Authorization", "Bearer uiopojhvbnm")
                .when()
                .get("api/users?page=2")
                .then()
                .statusCode(200)
                .extract()
                .response();

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        //Kiem tra so trang
        Assertions.assertEquals(2, response.jsonPath().getInt("page"));
        //Kiem tra so luong nguoi dung trong trang
        int totalUsers = response.jsonPath().getList("data").size();
        Assertions.assertEquals(6, totalUsers);

        //Kiem tra data tra ve
        Assertions.assertEquals(7, response.jsonPath().getInt("data[0].id"));
        Assertions.assertEquals("michael.lawson@reqres.in", response.jsonPath().getString("data[0].email"));
        Assertions.assertEquals("Michael1", response.jsonPath().getString("data[0].first_name"));
        Assertions.assertEquals("Lawson", response.jsonPath().getString("data[0].last_name"));
    }
}