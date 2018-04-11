import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;


public class TestVersionEndpoint {
	static {
		RestAssured.baseURI = "http://localhost:3030/version";
	}
	static final String VERSION = "1.1.0";
	
	
	@Test
	public void aliveTest() {
		expect().
			statusCode(200).and().
			contentType(equalTo("application/json; charset=utf-8")).
		when().
    			get();
    }
	
	@Test
	public void versionMatchTest() {
        expect().
        		body("version", equalTo(VERSION)).
        when().
        		get();
    }
}
