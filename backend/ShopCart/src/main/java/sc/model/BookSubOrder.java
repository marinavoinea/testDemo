package sc.model;

/**
 * 
 * a sub order contains one or more instances of the same book
 * The order is not stored in DB but it may be in the future
 * 
 */
public class BookSubOrder {
	String code;
	int count;
	double totalPrice;

	public String getBookCode() {
		return code;
	}

	public void setBookCode(String bookCode) {
		this.code = bookCode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void addBook(Book book) {
		if (this.code == null) {
			this.code = book.getCode();
			this.count = 1;
			this.totalPrice = book.getPrice();
		} else if (book.getCode() == code) {
			this.count++;
			this.totalPrice += book.getPrice();
		}
	}
}
