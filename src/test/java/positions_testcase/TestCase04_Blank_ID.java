package positions_testcase;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utilpackage.Util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestCase04_Blank_ID {
    @Test
    void test04(){
        int id = 0;
        String URL = Util.baseURI+id+"/positions?timestamps="+Util.getRandomNumber()+"&units=miles";
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
                body("error", notNullValue(),"error", equalToIgnoringCase("satellite not found")).
                log().all();
    }
}
