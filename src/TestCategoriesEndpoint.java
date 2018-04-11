import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class TestCategoriesEndpoint {
	static {
		RestAssured.baseURI = "http://localhost:3030/categories";
	}
	static final String CATEGORY_ID = "abcat0010000";
	static final String CATEGORY_NAME = "*Gifts*";
	static final String SUBCATEGORY_NAME = "Unique Gifts";
	static final String SUBCATEGORY_ID = "pcmcat748300579354";
	
	@Test
	public void aliveTest() {
		expect().
			statusCode(200).and().
			contentType(equalTo("application/json; charset=utf-8")).
		when().
    			get();
    }
	
	@Test
	public void categoryByIDTest() {
        expect().
        		body("id", equalTo(CATEGORY_ID)).
        when().
        		get("/"+CATEGORY_ID);
    }
	
	
	@Test
	public void categoriesByName() {
		with().
			queryParam("name[$like]", CATEGORY_NAME).
		expect().
			body("total", greaterThan(0)).
		when().
			get();
	}
	
}
