package api.tests;

import client.AutomationExerciseClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostVerifyLoginInvalidTest {

    @Test
    public void postVerifyLoginInvalid() {
        AutomationExerciseClient client = new AutomationExerciseClient();

        Response response = client.postVerifyLoginInv("0123@ibsu.edu.ge", "123");

        int status = response.statusCode();
        String body = response.getBody().asString();

        if (status == 404 || status == 200) {
            JsonPath json = response.jsonPath();
            int responseCode = json.getInt("responseCode");
            String message = json.getString("message");

            Assert.assertEquals(responseCode, 404);
            Assert.assertTrue(message.toLowerCase().contains("user not found"));
            return;
        }

        if (status == 405) {
            Assert.assertTrue(body.toLowerCase().contains("not supported"));
            return;
        }

        Assert.fail("Unexpected HTTP status: " + status + " Body: " + body);
    }
}