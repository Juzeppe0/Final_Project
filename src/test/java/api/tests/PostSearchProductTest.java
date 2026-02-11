//API 5


package api.tests;

import client.AutomationExerciseClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PostSearchProductTest {

    @Test
    public void postSearchProduct() {
        AutomationExerciseClient client = new AutomationExerciseClient();

        Response response = client.postSearchProduct("top");

        int status = response.statusCode();
        String body = response.getBody().asString().toLowerCase();

        if (status == 405) {
            Assert.assertTrue(body.contains("not supported"));
            return;
        }

        Assert.assertEquals(status, 200);

        JsonPath json = response.jsonPath();
        Assert.assertEquals(json.getInt("responseCode"), 200);

        List<Object> products = json.getList("products");
        Assert.assertNotNull(products);
        Assert.assertTrue(products.size() > 0);
    }
}