package positions_testcase;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utilpackage.Util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestCase12_Default_Units {
    @Test
    void test12(){
        int id = 25544;
        String URL = Util.baseURI+id+"/positions?timestamps="+Util.getRandomNumber();
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
                statusCode(200).
                body("name", notNullValue()).
                body("id", notNullValue()).
                body("latitude", notNullValue()).
                body("longitude", notNullValue()).
                body("altitude", notNullValue()).
                body("velocity", notNullValue()).
                body("visibility", notNullValue()).
                body("footprint", notNullValue()).
                body("timestamp", notNullValue()).
                body("daynum", notNullValue()).
                body("solar_lat", notNullValue()).
                body("solar_lon", notNullValue()).
                body("units", notNullValue()).
                body("units", hasItem("kilometers")).
                log().all();
    }
}
