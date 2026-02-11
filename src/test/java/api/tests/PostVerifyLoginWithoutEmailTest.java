//API 8


package api.tests;

import client.AutomationExerciseClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostVerifyLoginWithoutEmailTest {

    @Test
    public void postVerifyLoginWithoutEmail() {
        AutomationExerciseClient client = new AutomationExerciseClient();
        Response response = client.postVerifyLoginWithoutEmail("123456");

        int status = response.statusCode();
        String body = response.getBody().asString().toLowerCase();

        if (status == 400) {
            JsonPath json = response.jsonPath();
            Assert.assertEquals(json.getInt("responseCode"), 400);
            Assert.assertTrue(json.getString("message").toLowerCase().contains("missing"));
            return;
        }

        Assert.assertEquals(status, 405);
        Assert.assertTrue(body.contains("not supported"));
    }
}