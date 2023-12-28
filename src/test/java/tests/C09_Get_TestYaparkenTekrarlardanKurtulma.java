package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_TestYaparkenTekrarlardanKurtulma {

    @Test
    public void test01(){
            /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
       donen Response’un,
        status code’unun 200,
        ve content type’inin application-json,
        ve response body’sindeki
        "firstname“in, "Mark",
        ve "lastname“in, "Smith",
        ve "totalprice“in,1000den küçük olduğu,
        ve ""depositpaid"“in, false,
        ve "additionalneeds“in, "boş bırakılmadığı"
       oldugunu test edin
       */

        // 1-request body ve end-point hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";
        // 2- expected data hazirlama
        // 3- Request gönderip, dönen response' ı kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();
        // 4- Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Jim"),
                        "lastname",equalTo("Jackson"),
                        "totalprice",lessThan(1000),
                       "depositpaid",equalTo(false) ,
                        "additionalneeds",notNullValue());
    }
}
