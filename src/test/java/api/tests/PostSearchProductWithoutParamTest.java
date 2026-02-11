//API 6


package api.tests;

import client.AutomationExerciseClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostSearchProductWithoutParamTest {

    @Test
    public void postSearchProductWithoutParam() {
        AutomationExerciseClient client = new AutomationExerciseClient();
        Response response = client.postSearchProductWithoutParam();

        int status = response.statusCode();
        String body = response.getBody().asString().toLowerCase();

        Assert.assertTrue(status == 400 || status == 200);

        if (status == 400) {
            Assert.assertTrue(body.contains("bad request") || body.contains("missing"));
        }
    }
}