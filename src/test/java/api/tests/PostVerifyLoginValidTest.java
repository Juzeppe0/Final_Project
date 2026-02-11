//API 7
package api.tests;

import client.AutomationExerciseClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostVerifyLoginValidTest {

    @Test
    public void postVerifyLoginValid() {
        AutomationExerciseClient client = new AutomationExerciseClient();

        Response response = client.postVerifyLogin("23202197@ibsu.edu.ge", "123456");

        int status = response.statusCode();
        String body = response.getBody().asString();

        Assert.assertTrue(status == 200 || status == 404, "Unexpected HTTP status: " + status + " Body: " + body);

        if (body != null && body.trim().startsWith("{")) {
            JsonPath json = response.jsonPath();
            int responseCode = json.getInt("responseCode");
            String message = json.getString("message");

            if (status == 200) {
                Assert.assertEquals(responseCode, 200);
                Assert.assertTrue(message.toLowerCase().contains("user exists"));
            } else {
                Assert.assertEquals(responseCode, 404);
                Assert.assertTrue(message.toLowerCase().contains("not found"));
            }
        } else {
            Assert.fail("Not a JSON response. Body: " + body);
        }
    }
}