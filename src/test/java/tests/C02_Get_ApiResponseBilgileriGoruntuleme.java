package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ApiResponseBilgileriGoruntuleme {

    @Test
    public void test01(){

        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
            gonderdigimizde donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin Cowboy,
            ve status Line’in HTTP/1.1 200 OK
            ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz
     */
        // 1-request body ve end-point hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";
        // 2- expected data hazirlama
        // 3- Request gönderip, dönen response' ı kaydetme
        /*
        Olusturdugumuz response objesi ile kullanilabilecegimiz methodlar :
        response.prettyPrint : Response’u yazdirir
        response.getStatusCode( ) : Response’un status kodunu verir
        response.getHeaders( ) : Response’un tum basliklarini (headers) verir
        response.getHeader("Server") : Response’un istenen basliginin(header) degerini verir
        response.getContentType( ) : Response’un Content Type’ini verir
        response.getStatusLine( ) : Response’un Status Line degerini verir
        response.getTime( ) : Response’un gerceklesme suresini milisaniye olarak verir
         */
        Response response = given().when().get(url);
        System.out.println("status code: " + response.getStatusCode()+
                "\ncontent type: " + response.getContentType() +
                "\nServer Header degeri" + response.getHeader("Server") +
                "\nstatus Line " + response.getStatusLine() +
                "\nresponse suresi: " + response.getTime());

        // 4- Assertion

    }

}
