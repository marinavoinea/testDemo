package sc.dao.util;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;

import sc.model.Book;


/**
 * 
 * @author marina
 *
 */
public class MongoUtil {

	/**
	 * translate Book Pojo to Mongo document
	 * @param book to be translated to Mongo Document
	 * @return Mongo document
	 */
	public static Document getDocument(Book book){		
		Document doc = new Document("name", book.getName())
		        .append("author", book.getAuthor())
		        .append("price", book.getPrice())
		        .append("code", book.getCode())
		        .append("type", book.getType());
		return doc;
	}
	
	/**
	 * translate mongo Doc to Book Pojo
	 * @param bookDoc
	 * @return
	 */
	public static Book getBook(Document bookDoc){		
		Book book = new Book();
		book.setName((String)bookDoc.get("name"));
		book.setAuthor((String)bookDoc.get("author"));
		book.setPrice((Double)bookDoc.get("price"));
		book.setCode((String)bookDoc.get("code"));
		book.setType((String)bookDoc.get("type")); 
		book.setImageUrl((String)bookDoc.get("imageUrl")); 
		return book;
	}
}
