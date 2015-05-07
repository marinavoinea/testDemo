package sc.controller;

import static com.jayway.restassured.RestAssured.given;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import sc.model.Book;
import sc.model.Store;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


/**
 * Integration testing of REST services using RestAssured framework
 * These tests require the application to be deployed and active (for ex in Tomcat)
 * Also the Mongo DB containig test data has to be up and running
 * 
 * test data preloaded with below mongo commands:
 * 
 * >use store
 * >db.books.insert( {"name":"Book1","author":"Author1","price":32.0,"code":AB00,"description":"historical"})
 * >db.books.insert( {"name":"Book2","author":"Author2","price":25.0,"code":AB01,"description":"fiction"})
 * 
 * @author marina
 *
 */
public class StoreControllerIntegrationTest {
	private static Logger log = Logger.getLogger(StoreControllerIntegrationTest.class);

	

	/**
	 * This test verifies status code and also logs
	 * the json response string
	 */
	@Test
	public void test_fetch_all_books_status_code() {
		Response stringBody = given()
				.contentType("application/json")
				.accept("application/json")
				.when()
				.get("http://localhost:8080/shopcart/store/books")
				.then()
				.statusCode(200)
				.contentType(ContentType.JSON).extract().response();
	    String jsonResponse = stringBody.asString();
		log.debug("test_fetch_all_books_status_code json received:"+ jsonResponse);
	}
	
	/**
	 * This test verifies that the pojo response contains correct data
	 */
	@Test
	public void test_fetch_all_books_pojo() {
		
		Store store = given()
				.contentType("application/json")
				.get("http://localhost:8080/shopcart/store/books")
				.as(Store.class);
		Assert.assertNotNull(store);
		Assert.assertTrue("There should be at  least 2 books in store!",store.getBookList().size()>=2);
		
		Book book1 = getBookByNameAndAuthor("Book1","Author1",store);
		Assert.assertNotNull(book1);
		Assert.assertTrue("Book1 price should be 32.0",book1.getPrice()==32.0);
		Assert.assertTrue("Book1 type should be 'history'",book1.getType().equals("history"));
		
		Book book2 = getBookByNameAndAuthor("Book2","Author2",store);
		Assert.assertNotNull(book1);
		Assert.assertTrue("Book2 price should be 25.0",book2.getPrice()==25.0);
		Assert.assertTrue("Book2 type should be 'fiction'",book2.getType().equals("fiction"));
		
	}

	/**
	 * helper function to extract book from store object based on book name and author
	 * @param name book name
	 * @param author book author
	 * @param store store object 
	 * @return the book found or null otherwise
	 */
	private Book getBookByNameAndAuthor(String name,String author, Store store){
		Book book=null;
		for (Book b : store.getBookList()){
			if (b.getName().equals(name) && b.getAuthor().equals(author)){
				book=b;
				break;
			}
		}
		return book;
	}
}
