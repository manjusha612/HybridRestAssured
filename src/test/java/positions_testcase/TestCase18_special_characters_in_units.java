package positions_testcase;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utilpackage.Util;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestCase18_special_characters_in_units {
    @Test
    void test18(){
        String id = "25544";
        String units = "$$$";
        String URL = Util.baseURI+id+"/positions?timestamps="+Util.getRandomNumber()+"&units="+units+"";
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
                body("error", notNullValue(),"error", containsStringIgnoringCase("no satellite found")).
                log().all();
    }
}
