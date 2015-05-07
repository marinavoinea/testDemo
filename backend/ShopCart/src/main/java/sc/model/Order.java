package sc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * One full order represents a shopping cart info, made of suborders, 
 *  where each order contains a book and its number of copies ordered
 *  At the moment the orders are not stored in Mongo.
 *   
 */
public class Order {

	List<BookSubOrder> orderedBookList;
	double totalPrice;

	public List<BookSubOrder> getOrderedBookList() {
		return orderedBookList;
	}
	public void setOrderedBookList(List<BookSubOrder> orderedBookList) {
		this.orderedBookList = orderedBookList;
	}
	public List<BookSubOrder> addBookSubOrder(BookSubOrder bookSubOrder){
		if (orderedBookList == null){
			orderedBookList = new ArrayList<BookSubOrder>();
		}
		orderedBookList.add(bookSubOrder);
		totalPrice += bookSubOrder.getTotalPrice();
		return orderedBookList;
	}
	
}
