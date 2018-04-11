
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;


public class TestProductEndpoint {
	static {
		RestAssured.baseURI = "http://localhost:3030/products";
	}
	static final String PRODUCT_ID = "9132294";
	static final String PRODUCT_NAME = "*Duracell*";
	static final String CATEGORY_NAME = "Car Installation Parts & Accessories";
	static final String PRODUCT_TYPE = "HardGood";
	static final String PRICE = "100";
	
	@Test
	public void aliveTest() {
		expect().
			statusCode(200).and().
			contentType(equalTo("application/json; charset=utf-8")).
		when().
    			get();
    }
	
	@Test
	public void productByIDTest() {
        expect().
        		body("id", equalTo(Integer.valueOf(PRODUCT_ID))).
        when().
        		get("/"+PRODUCT_ID);
    }
	
	@Test
	public void productsByTypeTest() {
		with().
			queryParam("type", PRODUCT_TYPE).
		expect().
			body("total", greaterThan(0)).
		when().
			get();
	}
	
	@Test
	public void productsByCategory() {
		with().
			queryParam("category.name", CATEGORY_NAME).
		expect().
			body("total", greaterThan(0)).
		when().
			get();
	}
	
	@Test
	public void productsByName() {
		with().
			queryParam("name[$like]", PRODUCT_NAME).
		expect().
			body("total", greaterThan(0)).
		when().
			get();
	}
	
	@Test
	public void productsByPrice() {
		with().
			queryParam("price[$gt]", PRICE).
		expect().
			body("total", greaterThan(0)).
		when().
			get();
	}
}
