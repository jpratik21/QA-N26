import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;

public class TestHealthCheckEndpoint {
	static {
		RestAssured.baseURI = "http://localhost:3030/healthcheck";
	}
	static final int NUM_PRODUCTS = 51957;
	static final int NUM_STORES = 1561;
	static final int NUM_CATEGORIES = 4307;
	
	@Test
	public void aliveTest() {
		expect().
			statusCode(200).and().
			contentType(equalTo("application/json; charset=utf-8")).
		when().
    			get();
    }
	
	@Test
	public void nProductsMatchTest() {
        expect().
        		body("documents.products", equalTo(NUM_PRODUCTS)).
        when().
        		get();
    }
	
	@Test
	public void nCategoriesMatchTest() {
        expect().
        		body("documents.categories", equalTo(NUM_CATEGORIES)).
        when().
        		get();
    }
	
	@Test
	public void nStoresMatchTest() {
        expect().
        		body("documents.stores", equalTo(NUM_STORES)).
        when().
        		get();
    }
}
