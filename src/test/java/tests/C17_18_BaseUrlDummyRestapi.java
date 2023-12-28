package tests;

import baseUrl.BaseUrljsonplaceholderApi;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_18_BaseUrlDummyRestapi extends BaseUrljsonplaceholderApi {

        /*
        Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
        */
    @Test
    public void test(){
        //1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde
        //        donen response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test
        //        edin

        // 1-request body ve end-point hazirlama
        specjsonplaceholder.pathParam("pp1","posts");
             // GET oldugu için request body yok
        // 2- expected data hazirlama
        // 3- Request gönderip, dönen response' ı kaydetme
        Response response = given()
                            .when().spec(specjsonplaceholder)
                            .get("/{pp1}");
        // 4- Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.hasSize(100));

    }
    @Test
    public void test02(){
        //2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde
        //        donen response’un status code’unun 200 oldugunu ve “title” degerinin
        //        “optio dolor molestias sit” oldugunu test edin

        // 1-request body ve end-point hazirlama
        specjsonplaceholder.pathParams("pp1","posts","pp2",44);
        // 2- expected data hazirlama
        // 3- Request gönderip, dönen response' ı kaydetme
        Response response = given()
                .when().spec(specjsonplaceholder)
                .get("/{pp1}/{pp2]");

        //response.then()
        //        .assertThat()
        //        .statusCode(200)
        //        .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }
    @Test
    public void  test03(){
        //3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
        //        gonderdigimizde donen response’un status code’unun 200 oldugunu ve response body’sinin
        //        null oldugunu test edin

        // 1-request body ve end-point hazirlama
        specjsonplaceholder.pathParams("pp1","posts","pp2",50);
        // 2- expected data hazirlama
        // 3- Request gönderip, dönen response' ı kaydetme
        Response response = given()
                .when().spec(specjsonplaceholder)
                .delete("/{pp1}/{pp2}");

        // 4- Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.nullValue());
    }
}
