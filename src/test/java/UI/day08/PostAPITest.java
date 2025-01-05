package UI.day08;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostAPITest {
    @Test
    public void testCreatePost() {
        // Dữ liệu JSON gửi trong yêu cầu POST
        String requestBody = "{\n" +
                "    \"title\": \"foo\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1\n" +
                "}";


        // Thiết lập RestAssured
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Thực hiện yêu cầu POST
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)  // Kiểm tra mã trạng thái HTTP là 201 (Created)
                .extract()
                .response();

        // Kiểm tra phản hồi trả về
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        // Kiểm tra một số giá trị trong phản hồi
        Assertions.assertEquals("foo", response.jsonPath().getString("title"));
        Assertions.assertEquals("bar", response.jsonPath().getString("body"));
        Assertions.assertEquals(1, response.jsonPath().getInt("userId"));
    }
}