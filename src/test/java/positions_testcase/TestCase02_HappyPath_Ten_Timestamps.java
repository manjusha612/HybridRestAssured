package positions_testcase;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utilpackage.Util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class TestCase02_HappyPath_Ten_Timestamps {
    @Test
    void test02(){
        int id = 25544;
        String URL = Util.baseURI+id+"/positions?timestamps="+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+","+Util.getRandomNumber()+"&units=miles";
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
                body("[9].timestamp", notNullValue()).
                body("[9].name", notNullValue()).
                body("[9].id", notNullValue()).
                body("[9].latitude", notNullValue()).
                body("[9].longitude", notNullValue()).
                body("[9].altitude", notNullValue()).
                body("[9].velocity", notNullValue()).
                body("[9].visibility", notNullValue()).
                body("[9].footprint", notNullValue()).
                body("[9].daynum", notNullValue()).
                body("[9].solar_lat", notNullValue()).
                body("[9].solar_lon", notNullValue()).
                body("[9].units", notNullValue()).
                log().all();
    }
}
