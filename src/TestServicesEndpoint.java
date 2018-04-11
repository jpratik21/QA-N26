import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class TestServicesEndpoint {
	static {
		RestAssured.baseURI = "http://localhost:3030/services";
	}
	static final String SERVICE_ID = "1";
	static final String SERVICE_NAME = "*Geek*";
	
	@Test
	public void aliveTest() {
		expect().
			statusCode(200).and().
			contentType(equalTo("application/json; charset=utf-8")).
		when().
    			get();
    }
	
	@Test
	public void serviceByIDTest() {
        expect().
        		body("id", equalTo(Integer.valueOf(SERVICE_ID))).
        when().
        		get("/"+SERVICE_ID);
    }
	
	
	@Test
	public void servicesByName() {
		with().
			queryParam("name[$like]", SERVICE_NAME).
		expect().
			body("total", greaterThan(0)).
		when().
			get();
	}
	

}
