package tests;

import baseUrl.BaseUrlHerokuappApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C20_BaseUrlHerokuappQueryParam extends BaseUrlHerokuappApi {

    @Test
    public void test(){

        /*

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
        2- https://restful-booker.herokuapp.com/booking
        endpointine yandaki body’ye sahip bir POST request
        gonderdigimizde donen response’un status code’unun
        200 oldugunu ve “firstname” degerinin “Ahmet”
        oldugunu test edin
         */
        // 1-request body ve end-point hazirlama
        specHerokuapp.pathParam("pp1","booking");
        JSONObject requestBody = new JSONObject();
        JSONObject rezervasyonTarihleri = new JSONObject();
        rezervasyonTarihleri.put("checkin" , "2021-06-01");
        rezervasyonTarihleri.put("checkout" , "2021-06-10");
        requestBody.put("firstname" , "Ahmet");
        requestBody.put("lastname" , "Bulut");
        requestBody.put("totalprice" , 500);
        requestBody.put("depositpaid" , false);
        requestBody.put("bookingdates",rezervasyonTarihleri);
        requestBody.put("additionalneeds" , "wi-fi");

        // 2- expected data hazirlama
        // 3- Request gönderip, dönen response' ı kaydetme
        Response response = given().contentType(ContentType.JSON)
                .when()
                .spec(specHerokuapp).body(requestBody.toString())
                .post("/{pp1}");
        // 4- Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .body("booking.firstname", Matchers.equalTo("Ahmet"));
    }
}
