package sc.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sc.InternalException;
import sc.constants.Const;
import sc.dao.StoreMongoDao;
import sc.model.Book;
import sc.model.Store;

/**
 * 
 * RESTful services for adding books and getting all books list from store
 * 
 **/
@RestController
@RequestMapping("/store")
public class StoreController {

	private static Logger log = Logger.getLogger(StoreController.class);

	
	StoreMongoDao storeMongoDao;
	
	@Inject
	public StoreController(StoreMongoDao storeMongoDao){
		this.storeMongoDao=storeMongoDao;
	}

	/**
	 * REST service for getting all books inventory
	 **/
	@RequestMapping(value = "/books", headers = "Accept=*/*", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public Store store() {
		try {
			Store store = storeMongoDao.getStore();
			return store;
		} catch (InternalException e) {
			throw e;
		} catch (Exception e) {
			log.error("Cought exception:", e);
			throw new InternalException(Const.REST_SERVICE_ERROR);
		}
	}

	/**
	 * REST service for adding one book to books inventory
	 **/
	@RequestMapping(value = "/book", headers = "Accept=application/json", method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public Book saveBook(@RequestBody Book book) {
		try {
			Book savedBook = storeMongoDao.addBook(book);
			return savedBook;
		} catch (InternalException e) {
			throw e;
		} catch (Exception e) {
			log.error("Cought exception:", e);
			throw new InternalException(Const.REST_SERVICE_ERROR);
		}
	}

	/**
	 * REST service for fetching one book from inventory based on book name and
	 * author
	 */
	@RequestMapping(value = "/books/{name}/{author}", headers = "Accept=*/*", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public Book getBook(@PathVariable String name, @PathVariable String author) {
		try {
			Book book = storeMongoDao.getBook(name, author);
			return book;
		} catch (InternalException e) {
			throw e;
		} catch (Exception e) {
			log.error("Cought exception:", e);
			throw new InternalException(Const.REST_SERVICE_ERROR);
		}
	}
	
	/**
	 * REST service for fetching one book from inventory based on book name and
	 * author
	 */
	@RequestMapping(value = "/books/{name}/{author}", headers = "Accept=*/*", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public Book getBookBy(@PathVariable String name, @PathVariable String author) {
		try {
			Book book = storeMongoDao.getBook(name, author);
			return book;
		} catch (InternalException e) {
			throw e;
		} catch (Exception e) {
			log.error("Cought exception:", e);
			throw new InternalException(Const.REST_SERVICE_ERROR);
		}
	}

	public StoreMongoDao getStoreMongoDao() {
		return storeMongoDao;
	}

	public void setStoreMongoDao(StoreMongoDao storeMongoDao) {
		this.storeMongoDao = storeMongoDao;
	}
}
