//API 3

package api.tests;

import client.AutomationExerciseClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllBrandsListTest {

    @Test
    public void getAllBrandsList() {
        AutomationExerciseClient client = new AutomationExerciseClient();

        Response response = client.getBrandsList();

        Assert.assertEquals(response.statusCode(), 200);

        JsonPath json = response.jsonPath();

        Assert.assertEquals(json.getInt("responseCode"), 200);

        List<Object> brands = json.getList("brands");
        Assert.assertNotNull(brands);
        Assert.assertTrue(brands.size() > 0);
    }
}