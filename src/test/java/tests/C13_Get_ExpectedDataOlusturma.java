package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C13_Get_ExpectedDataOlusturma {

    @Test
    public void test() {

        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
        yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz
        Response body :
            {
            "userId": 3,
            "id": 22,
            "title": "dolor sint quo a velit explicabo quia nam",
            "body": "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita ear
            um mollitia molestiae aut atque rem suscipitnam impedit esse"
            }
         */

        // 1-request body ve end-point hazirlama
        String url = "https://jsonplaceholder.typicode.com/posts/22";
        // 2- expected data hazirlama
        JSONObject expData = new JSONObject();
        expData.put("userId", 3);
        expData.put("id", 22);
        expData.put("title", "dolor sint quo a velit explicabo quia nam");
        expData.put("body", "eos qui et ipsum ipsam suscipit autsed omnis non odioexpedita earum mollitia molestiae aut atque rem suscipitnam impedit esse");

        // 3- Request gönderip, dönen response' ı kaydetme
        Response response = given().when().get(url);
        // 4- Assertion

        JsonPath responseJsonPath = response.jsonPath();
        Assert.assertEquals(expData.get("id"),responseJsonPath.get("id"));
        Assert.assertEquals(expData.get("userId"),responseJsonPath.get("userId"));
        Assert.assertEquals(expData.get("title"),responseJsonPath.get("title"));
       // Assert.assertEquals(expData.get("body"),responseJsonPath.get("body"));

    }
}

