package sc.controller;

import static org.mockito.Mockito.when;

import java.nio.charset.Charset;

import javax.inject.Inject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import sc.config.TestRestServiceConfig;
import sc.config.TestRestServiceWebConfig;
import sc.dao.StoreMongoDao;
import sc.model.Book;
import sc.model.Store;

/**
 * 
 * Test suite for testing REST controller in isolation using a Mock Mongo DB Dao
 * 
 * @author marina
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestRestServiceConfig.class,
		TestRestServiceWebConfig.class })
@WebAppConfiguration
public class StoreControllerMockDbTest {
	
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
	            MediaType.APPLICATION_JSON.getSubtype(),
	            Charset.forName("utf8"));

	private MockMvc mockMvc;
	@Inject
	protected WebApplicationContext webApplicationContext;

	@Inject
	private StoreMongoDao storeMongoDaoMock;

	private Store store;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Mockito.reset(storeMongoDaoMock);
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
        store=new Store();
 
		Book book1 = new Book("Book1", "Author1", 32.0, "AB00", "history", "img1.jpg");
		Book book2 = new Book("Book2", "Author2", 25.0, "AB01", "fiction","img2.jpg");
		store.addBook(book1);
		store.addBook(book2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_fetch_all_books() throws Exception {
		when(storeMongoDaoMock.getStore()).thenReturn(store);

		mockMvc.perform(
				get("/store/books")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	//test add book
	//http://spring.io/guides/tutorials/bookmarks/
//	@Test
//    public void addBook() throws Exception {
//        String bookmarkJson = json(new Bookmark(
//                this.account, "http://spring.io", "a bookmark to the best resource for Spring news and information"));
//        this.mockMvc.perform(post("/" + userName + "/bookmarks")
//                .contentType(contentType)
//                .content(bookmarkJson))
//                .andExpect(status().isCreated());
//    }

}
