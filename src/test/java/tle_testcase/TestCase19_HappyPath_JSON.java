package tle_testcase;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utilpackage.Util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class TestCase19_HappyPath_JSON {
    @Test
    void test19(){
        int id = 25544;
        String URL = Util.baseURI +id+"/tles";
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
                body("requested_timestamp", notNullValue()).
                body("tle_timestamp", notNullValue()).
                body("id", notNullValue()).
                body("name", notNullValue()).
                body("header", notNullValue()).
                body("line1", notNullValue()).
                body("line2", notNullValue()).
                header("Content-Type", "application/json").
                log().all();
    }
}
