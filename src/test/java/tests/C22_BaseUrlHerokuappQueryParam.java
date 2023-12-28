package tests;

import baseUrl.BaseUrlHerokuappApi;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C22_BaseUrlHerokuappQueryParam extends BaseUrlHerokuappApi {

    @Test
    public void test(){

        /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini
        yazarak “firstname” degeri “Susan” ve “lastname” degeri “Jones” olan rezervasyon
        oldugunu test edecek bir GET request gonderdigimizde, donen response’un status
        code’unun 200 oldugunu ve “Susan Jones” ismine sahip  booking olmadığını test
        edin
         */
        // 1-request body ve end-point hazirlama
        specHerokuapp
                .pathParam("pp1","booking")
                .queryParams("firstname","Susan","lastname","Jones");
        // 2- expected data hazirlama
        // 3- Request gönderip, dönen response' ı kaydetme
        Response response = given().
                when().spec(specHerokuapp)
                .get("/{pp1}");

        // 4- Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(0));
    }
}
