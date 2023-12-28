package tests;

import baseUrl.BaseUrlHerokuappApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlHerokuapp extends BaseUrlHerokuappApi {
    @Test
    public void test(){

        /*
        Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin
        1- https://restful-booker.herokuapp.com/booking endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve Response’ta 12 booking oldugunu test
        edin
        Ahmet BULUTLUOZ API FRAMEWORK GELISTIRME
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

        // 2- expected data hazirlama
        // 3- Request gönderip, dönen response' ı kaydetme
        Response response = given()
                .when().spec(specHerokuapp)
                .get("/{pp1}");

        // 4- Assertion
        JsonPath responseJsonPath = response.jsonPath();
        int bookingSayi = responseJsonPath.getList("booking").size();
        System.out.println(bookingSayi);
        response.then()
                .assertThat()
                .statusCode(200)
                .body("booking", Matchers.hasSize(bookingSayi));
        System.out.println(bookingSayi);
    }
}
