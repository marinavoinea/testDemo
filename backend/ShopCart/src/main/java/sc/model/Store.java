package sc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Store object contains the book list
 * @author marina
 *
 */
public class Store {

	List<Book> bookList;
	public Store(){};
	public Store(List<Book> bookList){
		this.bookList=bookList;
	}

	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public List<Book> addBook(Book book){
		if (bookList==null) {
			bookList=new ArrayList<Book>();
		}
		bookList.add(book);	
		return bookList;
	}

}
