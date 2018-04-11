import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class TestStoresEndPoint {
	static {
		RestAssured.baseURI = "http://localhost:3030/stores";
	}
	static final String STORE_ID = "17";
	static final String CITY = "Sioux Falls";
	static final String ZIP = "57105";
	static final String STATE = "SD";
	static final String TYPE = "BigBox";
	static final String NAME = "*Sioux Falls*";
	
	@Test
	public void aliveTest() {
		expect().
			statusCode(200).and().
			contentType(equalTo("application/json; charset=utf-8")).
		when().
    			get();
    }
	
	@Test
	public void storeByIDTest() {
        expect().
        		body("id", equalTo(Integer.valueOf(STORE_ID))).
        when().
        		get("/"+STORE_ID);
    }
	
	@Test
	public void storessByTypeTest() {
		with().
			queryParam("type", TYPE).
		expect().
			body("total", greaterThan(0)).
		when().
			get();
	}
	
	
	@Test
	public void storessByNameTest() {
		with().
			queryParam("name[$like]", NAME).
		expect().
			body("total", greaterThan(0)).
		when().
			get();
	}
	
	@Test
	public void storesByCityTest() {
		with().
			queryParam("city", CITY).
		expect().
			body("total", greaterThan(0)).
		when().
			get();
	}
	
	@Test
	public void storesByStateTest() {
		with().
			queryParam("state", STATE).
		expect().
			body("total", greaterThan(0)).
		when().
			get();
	}
	
	@Test
	public void storesByZipTest() {
		with().
			queryParam("zip", ZIP).
		expect().
			body("total", greaterThan(0)).
		when().
			get();
	}
	

}
