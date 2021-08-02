package positions_testcase;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utilpackage.Util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestCase10_Negative_Timestamp {
    @Test
    void test10(){
        int id = 25544;
        String timestamp = "-1232345432";
        String URL = Util.baseURI+id+"/positions?timestamps="+timestamp+"&units=miles";
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
                body("status", notNullValue(),"status", equalTo(400)).
                body("error", notNullValue(),"error", containsStringIgnoringCase("invalid timestamp in list: ")).
                log().all();
    }
}
