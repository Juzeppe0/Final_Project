//API 1


package api.tests;

import client.AutomationExerciseClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllProductsListTest {

    @Test
    public void getAllProductsList() {
        AutomationExerciseClient client = new AutomationExerciseClient();

        Response response = client.getProductsList();

        Assert.assertEquals(response.statusCode(), 200);

        JsonPath json = response.jsonPath();

        Assert.assertEquals(json.getInt("responseCode"), 200);

        List<Object> products = json.getList("products");
        Assert.assertNotNull(products);
        Assert.assertTrue(products.size() > 0);
    }
}