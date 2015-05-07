package sc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.mongodb.client.MongoCursor;

import sc.InternalException;
import sc.constants.Const;
import sc.dao.util.MongoUtil;
import sc.model.Book;
import sc.model.Store;

/**
 * Data Access Object for accessing Mongo "store" database
 * 
 * @author marina
 * 
 */
@Named
public class StoreMongoDao extends MongoDao {

	final static Logger log = Logger.getLogger(StoreMongoDao.class);

	/**
	 * add book to store
	 * 
	 * @param book
	 *            to be added
	 * @return the book that has been added to the Store collection
	 */
	public Book addBook(Book book) {
		try {
			initMongo();
			Document bookDoc = MongoUtil.getDocument(book);
			log.debug("Add book  : " + bookDoc.toJson());
			booksCollection.insertOne(bookDoc);
			log.debug("new book count=" + booksCollection.count());
			return book;
		} catch (InternalException e) {
			throw e;
		} catch (Exception e) {
			shutdown();
			log.error("Cought exc:", e);
			throw new InternalException(Const.MONGO_DATA_FETCH_ERROR);
		}
	}

	/**
	 * fetch all books from "books" collection from "store" DB
	 * 
	 * @return store containing all books list
	 */
	public Store getStore() {

		List<Book> bookList = new ArrayList<Book>();
		Store store = new Store(bookList);
		initMongo();
		MongoCursor<Document> cursor = booksCollection.find().iterator();
		try {
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				Book book = MongoUtil.getBook(doc);
				bookList.add(book);
				log.debug("fetched book :" + doc.toJson());
			}
		} catch (InternalException e) {
			throw e;
		} catch (Exception e) {
			log.error("Cought exc:", e);
			shutdown();
			throw new InternalException(Const.MONGO_DATA_FETCH_ERROR);
		} finally {
			cursor.close();
		}
		log.debug("total books:" + bookList.size());
		return store;
	}

	/**
	 * fetch one book from db
	 * 
	 * @param name
	 *            book's name
	 * @param author
	 *            book's author
	 * @return fetched book
	 */
	public Book getBook(String name, String author) {
		Book book = null;
		initMongo();
		return book;
	}

}
