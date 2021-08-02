package tle_testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilpackage.Util;

import static io.restassured.RestAssured.*;

public class TestCase20_HappyPathText {
    @Test
    void test20(){
        String id = "25544";
        String URL = Util.baseURI+id+"/tles?format=text";
        System.out.println("URL generated is: "+URL);
        String response=given().get(URL).asString();
        System.out.println("My response is:"+response);
        Assert.assertTrue(response.contains("ISS (ZARYA)"));
        Assert.assertTrue(response.contains(id));
        given().
                header("Content-Type", "text/plain").
                get(URL).
        then().
                assertThat().
                statusCode(200).
                log().all();
    }
}
