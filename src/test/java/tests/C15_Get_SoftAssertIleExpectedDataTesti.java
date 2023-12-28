package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C15_Get_SoftAssertIleExpectedDataTesti {

    @Test
    public void test(){

        /*
        SOFT ASSERT
        ● SoftAssert doğrulama (verification) olarak da bilinir.
        ● SoftAssert kullanabilmemiz için object create etmemiz gerekir.
        • 1.Adım: SoftAssert objesi olusturalim
                 SoftAssert softAssert = new SoftAssert( );
        • 2.Adım: Istedigimiz verification’lari yapalim
                 softAssert.assertTrue( );
        • 3.Adım: SoftAssert’in durumu raporlamasini isteyelim
                 softAssert.assertAll( );

        http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
        gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
            {
            "status": "success",
            "data": {
                    "id": 3,
                    "employee_name": "Ashton Cox",
                    "employee_salary": 86000,
                    "employee_age": 66,
                    "profile_image": ""
                    },
           "message": "Successfully! Record has been fetched."
           }

         */
        // 1-request body ve end-point hazirlama
        String url = "http://dummy.restapiexample.com/api/v1/employee/3";
        // 2- expected data hazirlama
        JSONObject expData = new JSONObject();
        JSONObject innerData = new JSONObject();
        innerData.put("id", 3);
        innerData.put("employee_name", "Ashton Cox");
        innerData.put("employee_salary", 86000);
        innerData.put("employee_age", 66);
        innerData.put("profile_image", "");
        expData.put("status", "success");
        expData.put("data",innerData);
        expData.put("message", "Successfully! Record has been fetched.");
        // 3- Request gönderip, dönen response' ı kaydetme
        Response response = given().when().get(url);
        // 4- Assertion
        SoftAssert softAssert = new SoftAssert();
        JsonPath responseJsonPath = response.jsonPath();
        softAssert.assertEquals(responseJsonPath.get("status"),
                                expData.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"),
                                expData.get("message"));
        softAssert.assertEquals(responseJsonPath.get("data.id"),
                                expData.getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_name"),
                                expData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_salary"),
                                expData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_age"),
                                expData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(responseJsonPath.get("data.profile_image"),
                                expData.getJSONObject("data").get("profile_image"));

        softAssert.assertAll();
    }
}
