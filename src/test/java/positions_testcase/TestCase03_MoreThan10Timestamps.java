package positions_testcase;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utilpackage.Util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class TestCase03_MoreThan10Timestamps {
    @Test
    void test03(){

        int id = 25544;
        String URL = Util.baseURI+id+"/positions?timestamps="+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+"&units=miles";
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
                body("status", notNullValue()).
                body("error", notNullValue()).
                log().all();
    }
}
