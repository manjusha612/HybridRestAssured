package tle_testcase;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utilpackage.Util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestCase22_Non_Numerical_ID {
    @Test
    void test22(){
        String id = "abcd";
        String URL = Util.baseURI+id+"/tles";
        System.out.println("URL generated is: "+URL);
        JSONObject request = new JSONObject();
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                get(URL).
        then().
                assertThat().
                statusCode(400).
                body("error", notNullValue(), equalToIgnoringCase("satellite not found")).
                body("status", notNullValue(), equalTo(400)).
                log().all();
    }
}
