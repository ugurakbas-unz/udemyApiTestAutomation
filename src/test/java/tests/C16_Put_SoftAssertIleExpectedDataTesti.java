package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C16_Put_SoftAssertIleExpectedDataTesti {
    @Test
    public void test(){

        /*
        http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
        request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Request Body
                {
                "status": "success",
                "data": {
                        "name": “Ahmet",
                        "salary": "1230",
                        "age": "44",
                        "id": 40
                        }
                }
        Response Body
                {
                "status": "success",
                "data": {
                    "status": "success",
                    "data": {
                            "name": “Ahmet",
                            "salary": "1230",
                            "age": "44",
                            "id": 40
                            }
                },
                 "message": "Successfully! Record has been updated."
             }
         */

        // 1-request body ve end-point hazirlama
        String url = "http://dummy.restapiexample.com/api/v1/update/21";
        JSONObject requestBody = new JSONObject();
        JSONObject dataBilgileri = new JSONObject();
        dataBilgileri.put("name", "Ahmet");
        dataBilgileri.put("salary", "1230");
        dataBilgileri.put("age", "44");
        dataBilgileri.put("id", 40);
        requestBody.put("status", "success");
        requestBody.put("data", dataBilgileri);

        // 2- expected data hazirlama
        JSONObject expData = new JSONObject();
        expData.put("status", "success");
        expData.put("data",requestBody);
        expData.put("message","Successfully! Record has been updated.");
        // 3- Request gönderip, dönen response' ı kaydetme
       Response response = given().contentType(ContentType.JSON)
                           .when().body(requestBody.toString())
                           .put(url);

        // 4- Assertion
        SoftAssert softAssert = new SoftAssert();
        JsonPath responseJsonPath = response.jsonPath();
        /*
        {
                "status": "success",
                "data": {
                    "status": "success",
                    "data": {
                            "name": “Ahmet",
                            "salary": "1230",
                            "age": "44",
                            "id": 40
                            }
                },
                 "message": "Successfully! Record has been updated."
             }
         */
        softAssert.assertEquals(responseJsonPath.get("status"),
                                expData.get("status"));
        softAssert.assertEquals(responseJsonPath.get("data.status"),
                                expData.getJSONObject("data").get("status"));
        softAssert.assertEquals(responseJsonPath.get("data.data.name"),
                                expData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(responseJsonPath.get("data.data.salary"),
                                expData.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(responseJsonPath.get("data.data.age"),
                                 expData.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(responseJsonPath.get("data.data.id"),
                                expData.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonPath.get("message"),
                                expData.get("message"));
        softAssert.assertAll();
    }
}
