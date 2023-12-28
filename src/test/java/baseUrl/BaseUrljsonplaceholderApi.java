package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrljsonplaceholderApi {

   protected RequestSpecification specjsonplaceholder;

    @Before
    public void setUp(){
        specjsonplaceholder = new RequestSpecBuilder()
                                  .setBaseUri("https://jsonplaceholder.typicode.com")
                                  .build();
    }


}
