package client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import util.RequestSpecFactory;
import io.restassured.http.ContentType;

public class AutomationExerciseClient {

    public Response getProductsList() {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.defaultSpec())
                .when()
                .get("/api/productsList")
                .andReturn();
    }

    public Response postProductsList() {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.defaultSpec())
                .when()
                .post("/api/productsList")
                .andReturn();
    }

    public Response getBrandsList() {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.defaultSpec())
                .when()
                .get("/api/brandsList")
                .andReturn();
    }

    public Response putBrandsList() {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.defaultSpec())
                .when()
                .put("/api/brandsList")
                .andReturn();
    }

    public Response postSearchProduct(String keyword) {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.defaultSpec())
                .param("search_product", keyword)
                .when()
                .post("/api/searchProduct")
                .andReturn();
    }

    public Response postSearchProductWithoutParam() {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.defaultSpec())
                .when()
                .post("/api/searchProduct")
                .andReturn();
    }

    public Response postVerifyLogin(String email, String password) {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.defaultSpec())
                .contentType(ContentType.URLENC)
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post("/api/verifyLogin")
                .andReturn();
    }

    public Response postVerifyLoginWithoutEmail(String password) {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.defaultSpec())
                .contentType(ContentType.URLENC)
                .formParam("password", password)
                .when()
                .post("/api/verifyLogin")
                .andReturn();
    }

    public Response deleteVerifyLogin() {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.defaultSpec())
                .when()
                .delete("/api/verifyLogin")
                .andReturn();
    }

    public Response postVerifyLoginInv(String email, String password) {
        return RestAssured
                .given()
                .spec(RequestSpecFactory.defaultSpec())
                .contentType(ContentType.URLENC)
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post("/api/verifyLogin")
                .andReturn();
    }

}