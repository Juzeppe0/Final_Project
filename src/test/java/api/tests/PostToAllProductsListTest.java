//API 2


package api.tests;

import client.AutomationExerciseClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostToAllProductsListTest {

    @Test
    public void postToAllProductsList() {
        AutomationExerciseClient client = new AutomationExerciseClient();

        Response response = client.postProductsList();

        int status = response.statusCode();
        String body = response.getBody().asString().toLowerCase();

        Assert.assertTrue(status == 200 || status == 405);
        Assert.assertTrue(body.contains("not supported"));
    }
}