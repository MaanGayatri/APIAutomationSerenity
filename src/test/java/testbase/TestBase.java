package testbase;
import org.junit.jupiter.api.BeforeAll;
import io.restassured.RestAssured;


public class TestBase {
    @BeforeAll
    public static void init()
    {
        RestAssured.baseURI="http://localhost:3000/Students";
    }
}
