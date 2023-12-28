package baseUrl;

import baseUrl.BaseUrljsonplaceholderApi;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlHerokuappApi  {
   protected RequestSpecification specHerokuapp;

    @Before
    public void setUp(){
        specHerokuapp = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();
    }
}
