//API 9

package api.tests;

import client.AutomationExerciseClient;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteVerifyLoginTest {

    @Test
    public void deleteVerifyLogin() {
        AutomationExerciseClient client = new AutomationExerciseClient();
        Response response = client.deleteVerifyLogin();

        Assert.assertEquals(response.statusCode(), 200);

        JsonPath json = response.jsonPath();

        Assert.assertEquals(json.getInt("responseCode"), 405);
        Assert.assertTrue(
                json.getString("message").toLowerCase().contains("not supported")
        );
    }
}