package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {

    @Test
    public void test(){

        /*
      https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
      gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
      POST REQUEST, RESPONSE BODY BILGILERINI ASSERT YAPARKEN JSONPATH KULLANMA
      Response Body
        {
        "bookingid": 24,
        "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
        "checkin": "2021-06-01",
        "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
        }
        }
     Request body
        {
        "firstname" : "Ahmet",
        "lastname" : “Bulut",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
                            "checkin" : "2021-06-01",
                            "checkout" : "2021-06-10"
                         },
        "additionalneeds" : "wi-fi"
        }
             */

        // 1-request body ve end-point hazirlama
        String url = "https://restful-booker.herokuapp.com/booking";
        JSONObject requestBody = new JSONObject();
        JSONObject tarihData = new JSONObject();
        tarihData.put("checkin" , "2021-06-01");
        tarihData.put("checkout" , "2021-06-10");
        requestBody.put("firstname" , "Ahmet");
        requestBody.put("lastname" , "Bulut");
        requestBody.put("totalprice" , 500);
        requestBody.put("depositpaid" , false);
        requestBody.put("bookingdates",tarihData);
        requestBody.put("additionalneeds" , "wi-fi");

        /*
        {
        "bookingid": 24,
        "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
                        "checkin": "2021-06-01",
                        "checkout": "2021-06-10"
                        },
        "additionalneeds": "wi-fi"
        }
         */
        // 2- expected data hazirlama
        JSONObject expData = new JSONObject();
        expData.put("bookingid", 24);
        expData.put("booking",requestBody);
        // 3- Request gönderip, dönen response' ı kaydetme
        Response response = given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);
        // 4- Assertion
        // ilk yazılan expected ====> olusturdugumuz JSONObject : expData
        // ikinci yazılan actual ====> olusturdugumuz response : responseJsonPath
        JsonPath responseJsonPath = response.jsonPath();
        Assert.assertEquals(expData.getJSONObject("booking").get("firstname"),
                            responseJsonPath.get("booking.firstname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("lastname"),
                            responseJsonPath.get("booking.lastname"));
        Assert.assertEquals(expData.getJSONObject("booking").get("totalprice"),
                            responseJsonPath.get("booking.totalprice"));
        Assert.assertEquals(expData.getJSONObject("booking").get("depositpaid"),
                            responseJsonPath.get("booking.depositpaid"));
        Assert.assertEquals(expData.getJSONObject("booking").get("additionalneeds"),
                            responseJsonPath.get("booking.additionalneeds"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                            responseJsonPath.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                            responseJsonPath.get("booking.bookingdates.checkout"));

    }
}
